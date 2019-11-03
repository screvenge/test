package com.study.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtil {
	private static DataSource ds;// javax的数据源

	private static ThreadLocal<Connection> local = new ThreadLocal<>();// 多线程

	static {// 代码块，连接池技术，之前jdbc每次使用都要新建连接，非常消耗资源，而连接池技术相当于给你创建好了各种连接，只要取用需要的连接就可以，大大提高了效率和资源利用率
		try {
			Properties p = new Properties();

			// 加载db.properties的连接数据
			p.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));

			// 新建数据库dbcp连接池
			ds = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		// 获取ThreadLocal中的连接
		Connection con = local.get();
		if (con == null) {
			try {
				// 如果为空则重新加载连接
				con = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			local.set(con);
		}
		return con;
	}

	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
				local.remove();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			// 关闭资源
			local.get().close();
			local.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
