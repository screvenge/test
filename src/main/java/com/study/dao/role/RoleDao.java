package com.study.dao.role;

import com.study.message.role.req.CreateAccountReq;
import com.study.model.role.Account;
import com.study.model.role.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    List<String> selectResource(@Param("account") Long account);

    void addAccount(Account account);

}
