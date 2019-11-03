package com.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.message.login.data.UserInfo;

public interface LoginDao {
	List<UserInfo> queryUserByName(@Param("name") String name);
	
	int addUser(UserInfo userInfo);
}
