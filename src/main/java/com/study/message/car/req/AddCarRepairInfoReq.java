package com.study.message.car.req;

import javax.validation.constraints.NotNull;

import com.study.common.BaseReq;
import com.study.common.IOperationReq;
import com.study.common.constants.BusType;

/**
 * 添加修车信息请求类
 * @author swiftzsl
 *
 */
public class AddCarRepairInfoReq extends BaseReq implements IOperationReq{
	
	@NotNull
	private Long jobNumber;
	@NotNull
	private String carNo;
	@NotNull
	private String component;
	
	private Long repairId;
	
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

}
