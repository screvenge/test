package com.study.common;

public class BaseRsp {
	private int retCode = 0;

	private String retMsg = "success";

	public BaseRsp() {

	}

	public BaseRsp(int retCode) {
		this.retCode = retCode;
	}
	
	public BaseRsp(int retCode, String msg) {
		this.retCode = retCode;
		this.retMsg = msg;
	}

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
}
