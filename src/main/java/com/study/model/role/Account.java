package com.study.model.role;

import sun.util.resources.ga.LocaleNames_ga;

/**
 * 账号
 * 一个账号对应一个角色
 */
public class Account {

    Long id;

    Long account;

    String accountName;

    Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
