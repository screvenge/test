package com.study.message.car.req;

import javax.validation.constraints.NotNull;

import com.study.common.BaseReq;
import com.study.common.IOperationReq;
import com.study.common.constants.BusType;
import com.study.common.constants.WorkFlow;

/**
 * 删除车辆信息接口类
 * @author swiftzsl
 *
 */
public class DeleteCarInfoReq extends BaseReq implements IOperationReq{
	@NotNull
	private Long jobNumber;
	@NotNull
	private String carNo;
	
	private Long carId;
	
	@Override
	public String getBusType() {
		return BusType.CAR;
	}
	
	@Override
	public Long getId() {
		return this.carId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
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
	
	@Override
	public Integer getFlowStatus() {
		return WorkFlow.FlowStatus.DELETE;
	}
}
