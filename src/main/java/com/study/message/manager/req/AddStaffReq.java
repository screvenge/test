package com.study.message.manager.req;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.study.common.BaseReq;
import com.study.message.manager.data.StaffInfo;

/**
 * 添加员工信息请求类
 */
public class AddStaffReq extends BaseReq {

    @NotNull
    private Long jobNumber;

    @Valid
    @NotNull
    private StaffInfo staffInfo;

    public StaffInfo getStaffInfo() {

        return staffInfo;

    }

    public void setStaffInfo(StaffInfo staffInfo) {

        this.staffInfo = staffInfo;

    }

    public Long getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Long jobNumber) {
        this.jobNumber = jobNumber;
    }
}
