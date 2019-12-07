package com.study.message.car.req;

import javax.validation.constraints.NotNull;

import com.study.common.BaseReq;

/**
 * 查询车辆详细信息请求类
 * 
 * @author swiftzsl
 *
 */
public class SelectCarInfoReq extends BaseReq {

	@NotNull
	private Long jobNumber;
	@NotNull
	private String carNo;
	
	/**
	 * 工作流id
	 */
	private Long flowId;

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

	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}
}
