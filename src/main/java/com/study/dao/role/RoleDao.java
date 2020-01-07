package com.study.dao.role;

import com.study.message.role.data.ResourceInfo;
import com.study.model.role.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    List<String> selectResource(@Param("account") Long account);

    void addAccount(Account account);

	List<ResourceInfo> queryResourceByAccount(@Param("account") String account);

    /**
     * 新增角色
     * @param desc 角色名
     */
	void addRole(@Param("desc") String desc);

}
