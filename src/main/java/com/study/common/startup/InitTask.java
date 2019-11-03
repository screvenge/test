package com.study.common.startup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.common.CloseUtil;
import com.study.common.JdbcUtil;
import com.study.message.common.TaskInfo;

public class InitTask implements IStartup {
	private static final InitTask INSTANCE = new InitTask();

	public static InitTask getInstance() {
		return INSTANCE;
	}

	@Override
	public void startup() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement("select * from t_taskinfo");
			rs = ps.executeQuery();
			List<TaskInfo> task =  buildTaskInfo(rs);
			System.out.println(task);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);
			CloseUtil.close(ps);
			CloseUtil.close(conn);
		}
	}

	@Override
	public void reboot() {

	}

	private List<TaskInfo> buildTaskInfo(ResultSet rs) {
		List<TaskInfo> list = new ArrayList<>();
		try {
			while (rs.next()) {
				TaskInfo info = new TaskInfo();
				info.setClassName(rs.getString("classname"));
				info.setExcuteTime(rs.getString("excutetime"));
				info.setExpireTime(rs.getInt("expiretime"));
				info.setId(rs.getLong("id"));
				info.setIpAddress(rs.getString("ipaddress"));
				info.setRunStatus(rs.getInt("runstatus"));
				info.setScheduleTime(rs.getInt("scheduletime"));
				info.setTaskName(rs.getString("taskname"));
				info.setNextTime(rs.getString("nexttime"));
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
