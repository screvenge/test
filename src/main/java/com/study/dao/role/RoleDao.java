package com.study.dao.role;

import com.study.message.role.data.ResourceRoleRelationInfo;
import com.study.model.role.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    List<String> selectResource(@Param("account") Long account);

    void addAccount(Account account);

	List<String> queryResourceByRoleId(Long roleId);

	List<ResourceRoleRelationInfo> queryResourceByAccount(String account);
}
