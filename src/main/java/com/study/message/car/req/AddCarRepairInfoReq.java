package com.study.message.car.req;

import javax.validation.constraints.NotNull;

import com.study.common.BaseReq;
import com.study.common.IOperationReq;
import com.study.common.constants.BusType;
import com.study.common.constants.ServiceId;
import com.study.common.constants.WorkFlow;
import com.study.common.workflow.IAuditReq;

/**
 * 添加修车信息请求类
 * 
 * @author swiftzsl
 *
 */
public class AddCarRepairInfoReq extends BaseReq implements IOperationReq, IAuditReq {

	@NotNull
	private Long jobNumber;
	@NotNull
	private String carNo;
	@NotNull
	private String component;

	private Long repairId;
	
	@NotNull
	private String auditAccout;

	@Override
	public String getBusType() {
		return BusType.CAR;
	}

	@Override
	public Long getId() {
		return this.repairId;
	}

	public Long getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(Long jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Long getRepairId() {
		return repairId;
	}

	public void setRepairId(Long repairId) {
		this.repairId = repairId;
	}

	@Override
	public Integer getFlowStatus() {
		return WorkFlow.FlowStatus.ADD;
	}

	public void setAuditAccout(String auditAccout) {
		this.auditAccout = auditAccout;
	}

	@Override
	public String getAuditAccout() {
		return auditAccout;
	}

	@Override
	public String getServiceId() {
		return ServiceId.ADD_REPAIRINFO;
	}
}
