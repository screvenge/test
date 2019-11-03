package com.study.common;

import java.io.Closeable;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class CloseUtil {
	public static void close(Closeable close) {
		if (null != close) {
			try {
				close.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Socket close) {
		if (null != close) {
			try {
				close.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet close) {
		if (null != close) {
			try {
				close.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection close) {
		if (null != close) {
			try {
				close.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement close) {
		if (null != close) {
			try {
				close.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
