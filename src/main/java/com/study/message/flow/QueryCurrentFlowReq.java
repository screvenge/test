package com.study.message.flow;

import com.study.common.BaseReq;

import javax.validation.constraints.NotNull;

public class QueryCurrentFlowReq extends BaseReq {

    @NotNull
    private Long jobNumber;

    public Long getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Long jobNumber) {
        this.jobNumber = jobNumber;
    }
}
