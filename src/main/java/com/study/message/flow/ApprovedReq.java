package com.study.message.flow;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.study.common.BaseReq;
import com.study.common.workflow.IAuditReq;

public class ApprovedReq extends BaseReq implements IAuditReq {
	@NotNull
	private Long busId;
	
	@NotBlank
	private String serviceId;
	
	@NotBlank
	private String createUser;

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Override
	public String getAuditAccout() {
		return createUser;
	}
}
