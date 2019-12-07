package com.study.service.aspect;

import com.study.common.AccountUtil;

public abstract class EmailUtil {
	public static void sendEmail(String moduleId, String msg, String account) {
		System.out.println("模块: " + moduleId + ",发件人: " + AccountUtil.getInstance().getAccount() + ",收件人 : " + account);
		System.out.println("内容: " + msg);
	}
}
