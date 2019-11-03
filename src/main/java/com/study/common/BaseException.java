package com.study.common;

public class BaseException extends Exception {
	private static final long serialVersionUID = 4838380560222048594L;

	private int retCode;

	public int getRetCode() {
		return retCode;
	}

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(int retCode) {
		super();
		this.retCode = retCode;
	}
}
