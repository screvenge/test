package com.study.message.car.data;

/**
 * 车辆selectCarInfo页面模型
 * @author swiftzsl
 *
 */
public class CarInfoOfOne {
	
	private Long carId;
	
	private String carNo;
	
	private String licenseId;
	
	private String temLicense;
	
	private String temStartDate;
	
	private String temEndDate;
	
	private Integer auditStatus;
	
	private Integer status;
	
	private StaffInfo staffInfo;
	
	private String consName;

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
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

	public StaffInfo getStaffInfo() {
		return staffInfo;
	}

	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}

	public String getConsName() {
		return consName;
	}

	public void setConsName(String consName) {
		this.consName = consName;
	}

	@Override
	public String toString() {
		return "CarInfo [carId=" + carId + ", carNo=" + carNo + "]";
	}

}
