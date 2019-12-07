package com.study.message.flow;

public class FlowInfo {
private Long id;
	
	private Long busId;
	
	private String busType;
	
	private String cacheData;
	
	private String createTime;
	
	private String lastModifyTime;
	
	private Integer auditStatus;
	
	private Integer flowStatus;
	
	/**
	 * 是否是当前工作流 0 否 1 是
	 */
	private Integer isCurrent;
	
	/**
	 * 创建用户
	 */
	private String createUser;
	
	/**
	 * 审批用户
	 */
	private String auditUser;
	
	private Integer serviceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getCacheData() {
		return cacheData;
	}

	public void setCacheData(String cacheData) {
		this.cacheData = cacheData;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(Integer flowStatus) {
		this.flowStatus = flowStatus;
	}

	public Integer getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(Integer isCurrent) {
		this.isCurrent = isCurrent;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
}
