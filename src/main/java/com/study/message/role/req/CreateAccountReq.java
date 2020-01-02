package com.study.message.role.req;

import com.study.common.BaseReq;

import javax.validation.constraints.NotNull;

public class CreateAccountReq extends BaseReq {

    @NotNull
    private Long jobNumber;

    @NotNull
    private String name;

    @NotNull
    private String role;

    public Long getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Long jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
