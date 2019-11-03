package com.study.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.BaseException;
import com.study.common.IService;
import com.study.dao.LoginDao;
import com.study.message.login.req.LoginReq;
import com.study.message.login.rsp.LoginRsp;

// @Service == @Service("iService")
// @Autowired 顺序    类型(包括泛型) -> 名称
@Service("loginService")
public class LoginService implements IService<LoginReq, LoginRsp> {
	@Autowired
	private LoginDao loginDao;
	
	@Override
	// Propagation 传播性 Propagation.REQUIRED只有一个事务, 其他有这个注解的事务, 会包含原来的大的事务里
	// rollbackFor Exception.class 所有Exception及其子类的异常 会回滚
	// isolation 隔离性
	// READ_UNCOMMITTED	读未提交	脏读，幻读，重复读
	// READ_COMMITTED 读提交（推荐） 	幻读（侧重于增删），重复读（侧重于改）
	// REPEATABLE_READ 可重复读  幻读 (锁行)
	// SERIALIZABLE 序列 (锁表)
	// DEFAULT 数据库默认隔离级别	Oracle是READ_COMMITTED MySQL是REPEATABLE_READ
	
	// 从REPEATABLE_READ开始, 大大增加死锁的概率, 还有性能 综合利弊, 一般都会选择READ_COMMITTED
	
	public LoginRsp doExcute(LoginReq req) throws Exception {
		if (req.getName() == null) {
			throw new BaseException(1000);
		}
		LoginRsp rsp = new LoginRsp();
		rsp.setUserInfo(loginDao.queryUserByName(req.getName()));
		
		return rsp;
	}
}
