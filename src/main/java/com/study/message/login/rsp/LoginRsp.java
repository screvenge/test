package com.study.message.login.rsp;

import java.util.List;

import com.study.common.BaseRsp;
import com.study.message.login.data.UserInfo;

public class LoginRsp extends BaseRsp {
	private List<UserInfo> userInfo;

	public List<UserInfo> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}
}	
