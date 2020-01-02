package com.study.dao.role;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    List<String> selectResource(@Param("account") Long account);

}
