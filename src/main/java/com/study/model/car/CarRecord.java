package com.study.model.car;

public class CarRecord {
	private Long id;
	
	private String carNo;
	
	private Integer hasLicense;
	
	private String licenseId;
	
	private Integer hasTempLicense;
	
	private String temStartDate;
	
	private Integer auditStatus;
	
	private Integer status;
	
	private Long departmentId;
	
	private Long staffId;
	
	private Long consumerId;
	
	private String registTime;
	
	private String actualRegistTime;
	
	private String outTime;
	
	private String temLicense;
	
	private String temEndDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public Integer getHasLicense() {
		return hasLicense;
	}

	public void setHasLicense(Integer hasLicense) {
		this.hasLicense = hasLicense;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public Integer getHasTempLicense() {
		return hasTempLicense;
	}

	public void setHasTempLicense(Integer hasTempLicense) {
		this.hasTempLicense = hasTempLicense;
	}

	public String getTemStartDate() {
		return temStartDate;
	}

	public void setTemStartDate(String temStartDate) {
		this.temStartDate = temStartDate;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public String getRegistTime() {
		return registTime;
	}

	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}

	public String getActualRegistTime() {
		return actualRegistTime;
	}

	public void setActualRegistTime(String actualRegistTime) {
		this.actualRegistTime = actualRegistTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getTemLicense() {
		return temLicense;
	}

	public void setTemLicense(String temLicense) {
		this.temLicense = temLicense;
	}

	public String getTemEndDate() {
		return temEndDate;
	}

	public void setTemEndDate(String temEndDate) {
		this.temEndDate = temEndDate;
	}

	@Override
	public String toString() {
		return "CarRecord [id=" + id + ", carNo=" + carNo + ", hasLicense=" + hasLicense + ", licenseId=" + licenseId
				+ ", hasTempLicense=" + hasTempLicense + ", temStartDate=" + temStartDate + ", auditStatus="
				+ auditStatus + ", status=" + status + ", departmentId=" + departmentId + ", staffId=" + staffId
				+ ", consumerId=" + consumerId + ", registTime=" + registTime + ", actualRegistTime=" + actualRegistTime
				+ ", outTime=" + outTime + ", temLicense=" + temLicense + ", temEndDate=" + temEndDate + "]";
	}
}
