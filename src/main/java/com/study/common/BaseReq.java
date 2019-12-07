package com.study.common;

import com.study.common.web.Fill;
import com.study.common.web.FillName;

@Fill
public class BaseReq {
	private String i18n;
	
	private String account;
	
	public String getI18n() {
		return i18n;
	}

	@FillName(name = "i18n")
	public void setI18n(String i18n) {
		this.i18n = i18n;
	}

	public String getAccount() {
		return account;
	}

	@FillName(name = "account")
	public void setAccount(String account) {
		this.account = account;
	}
}
