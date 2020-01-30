package com.study.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.study.message.common.TaskInfo;
import com.study.message.common.TaskRunLog;

/**
 * 抽象定时任务基类
 * 
 * @author reborn
 *
 */
public abstract class AbstractTask {
	/**
	 * 是否是任意时间段
	 */
	private final String ANY = "-1";

	/**
	 * 分隔符
	 */
	private final String SIGN = "#";

	/**
	 * 子类的定时任务业务逻辑
	 */
	public abstract void mainWork() throws Exception;

	/**
	 * 获取定时任务名
	 * 
	 * @return 任务名
	 */
	public abstract String getTaskName();

	// 定时任务主要方法
	public void work(TaskInfo info) {
		
		if (info.getRunStatus() == 0) {
			return;
		}

		// 执行时间段
		String excuteTime = info.getExcuteTime();
		String startTime;
		String endTime;

		if (excuteTime.equals(ANY)) {
			// 土鳖写法
			startTime = "00:00:00";
			endTime = "23:59:59";
		} else if (excuteTime.split(SIGN).length > 1) {
			startTime = excuteTime.split(SIGN)[0];
			endTime = excuteTime.split(SIGN)[1];
			/** 校验时间格式 是否是HH:mm:ss格式,此处偷懒就省略了 */
		} else {
			System.out.println("脚本语句有误");
			return;
		}

		try {
			// 校验时间格式 是否是HH:mm:ss格式,此处偷懒就省略了
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

			final long startMills = sdf.parse(startTime).getTime();
			final long endMills = sdf.parse(endTime).getTime();
			// 下次执行时间
			final String nextTime = info.getNextTime();

			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					try {
						SimpleDateFormat wholeSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						long currentTime = sdf.parse(sdf.format(new Date())).getTime();
						long wholeCurrentTime = wholeSdf.parse(wholeSdf.format(new Date())).getTime();

						long nextMills = wholeSdf.parse(nextTime).getTime();

						// 执行标记
						boolean flag = true;
						// 如果小于下次执行时间,则不执行
						if (wholeCurrentTime <= nextMills) {
							flag = false;
						}
						// 如果小于,说明当天执行
						else if (startMills <= endMills && currentTime >= startMills && currentTime <= endMills) {
							// 小于结束时间,那么执行
							mainWork();
						}
						// 如果是跨天执行
						else if (currentTime > startMills || currentTime < endMills) {
							// 小于结束时间,那么执行
							mainWork();
						}
						// 不执行
						else {
							flag = false;
						}

						if (flag) {
							// 监测定时任务是否超时 逻辑还没写
							
							
							// 修改下次执行时间
							updateLog(info.getClassName(), info.getScheduleTime());
							// 添加日志
							addLog(new TaskRunLog(getTaskName(), 0, "success"));
						}
					}
					// 检测到异常,添加异常的状态
					catch (Exception e) {
						e.printStackTrace();
						addLog(new TaskRunLog(getTaskName(), 3, e.toString()));
					}
				}
			};

			buildSchedule(new Timer(), task, info);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 定时任务方法
	 * 
	 * @param timer
	 * @param task
	 * @param info
	 */
	private void buildSchedule(Timer timer, TimerTask task, TaskInfo info) {
		// 此处单位为毫秒
		timer.scheduleAtFixedRate(task, info.getRunStatus(), info.getScheduleTime() * 1000);
	}

	/**
	 * 更新下次执行任务时间
	 * 
	 * @param scheduleTime
	 *            定时任务执行周期
	 * @param className
	 *            类全限定名
	 */
	private void updateLog(String className, Integer scheduleTime) {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 使用日历类对时间进行添加
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, scheduleTime);
			String nextTime = sdf.format(cal.getTime());

			String sql = "update t_taskinfo set nexttime = ? where classname = ?";

			conn = JdbcUtil.getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, nextTime);
			ps.setString(2, className);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加运行成功日志到数据库
	 * 
	 * @param log 日志
	 */
	private void addLog(TaskRunLog log) {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String sql = "insert into t_taskrunlog values (null,?,current_timestamp(),?,?,current_timestamp(),current_timestamp())";

			conn = JdbcUtil.getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, getTaskName());
			ps.setInt(2, log.getStatus());
			ps.setString(3, log.getDescription());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
