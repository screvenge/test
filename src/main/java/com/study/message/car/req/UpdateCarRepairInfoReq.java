package com.study.message.car.req;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.study.common.BaseReq;
import com.study.common.IOperationReq;
import com.study.common.constants.BusType;
import com.study.common.constants.WorkFlow;

/**
 * 更新修车信息请求类
 * @author swiftzsl
 *
 */
public class UpdateCarRepairInfoReq extends BaseReq implements IOperationReq{
	@NotNull
	private Long jobNumber;
	@NotNull
	private String carNo;
	@NotNull
	private String component;
	@NotNull
	private BigDecimal cost;
	
	private Long repairId;
	
	public Long getRepairId() {
		return repairId;
	}

	public void setRepairId(Long repairId) {
		this.repairId = repairId;
	}

	@Override
	public String getBusType() {
		return BusType.CAR;
	}
	
	@Override
	public Long getId() {
		return this.repairId;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
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

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	@Override
	public Integer getFlowStatus() {
		return WorkFlow.FlowStatus.MODIFY;
	}
}
