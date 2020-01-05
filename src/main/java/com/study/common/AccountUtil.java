package com.study.common;
/**
 * 单例模式
 * @author swiftzsl
 *
 */
public class AccountUtil {
	private static final AccountUtil INSTANCE = new AccountUtil();
	
	private ThreadLocal<String> threadLocal = new ThreadLocal<>();
	
	private AccountUtil() {
		
	}
	
	public static AccountUtil getInstance() {
		return INSTANCE;
	}
	
	/**
	 * 从请求上下文中获取当前用户账号信息
	 * @return
	 */
	public String getAccount() {//获取threadLocal中mapper的value
		return threadLocal.get();
	}
	
	/**
	 * 设置账户
	 * @param account
	 */
	public void setAccount(String account) {//设置threadLocal中mapper的value
		threadLocal.set(account);
	}
}
