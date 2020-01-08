package com.study.dao.role;

import com.study.message.role.data.ResourceRoleRelationInfo;
import com.study.model.role.Account;
import com.study.model.role.Resource;
import com.study.model.role.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    //根据账号查询接口名
    List<String> selectResource(@Param("account") Long account);

    //添加账号
    void addAccount(Account account);

    //添加角色
    void addRole(Role role);

    //根据角色id,查询接口名
	List<String> queryResourceByRoleId(Long roleId);

	//查询接口名称和对应的角色id
	List<ResourceRoleRelationInfo> queryResourceByAccount(String account);

	//查询所有角色名
    List<String> selectAllRoleNames();

    //根据名称查询roleId
    Long selectRoleId(@Param("roleName") String roleName);

    //新增资源
    void addResource(Resource resource);

    //向关联表中插入数据
    void addRelationShip(@Param("roleId") Long roleId,@Param("resourceId") Long resourceId);
}
