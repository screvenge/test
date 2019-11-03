package com.study.message.login.req;

import com.study.common.BaseReq;

public class LoginReq extends BaseReq {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
