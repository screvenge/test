package com.study.message.car.req;

import javax.validation.constraints.NotNull;

import com.study.common.BaseReq;
import com.study.common.IOperationReq;
import com.study.common.constants.BusType;
import com.study.common.constants.ServiceId;
import com.study.common.constants.WorkFlow;
import com.study.common.workflow.IAuditReq;

/**
 * 添加车辆信息请求类
 * @author swiftzsl
 *
 */
public class AddCarInfoReq extends BaseReq implements IOperationReq, IAuditReq {
	@NotNull
	private Long jobNumber;
	
	@NotNull
	private String consumer;
	
	private String licenseId;
	
	private String temLicense;
	
	private String temStartDate;
	
	private String temEndDate;
	
	private Long carId;
	
	@NotNull
	private String auditAccout;
	
	@Override
	public String getBusType() {
		return BusType.CAR;
	}
	
	@Override
	public Long getId() {
		return this.carId;
	}

	public Long getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(Long jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getTemLicense() {
		return temLicense;
	}

	public void setTemLicense(String temLicense) {
		this.temLicense = temLicense;
	}

	public String getTemStartDate() {
		return temStartDate;
	}

	public void setTemStartDate(String temStartDate) {
		this.temStartDate = temStartDate;
	}

	public String getTemEndDate() {
		return temEndDate;
	}

	public void setTemEndDate(String temEndDate) {
		this.temEndDate = temEndDate;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public void setAuditAccout(String auditAccout) {
		this.auditAccout = auditAccout;
	}

	@Override
	public Integer getFlowStatus() {
		return WorkFlow.FlowStatus.ADD;
	}

	@Override
	public String getAuditAccout() {
		return auditAccout;
	}

	@Override
	public String getServiceId() {
		return ServiceId.ADD_CAR;
	}
}
