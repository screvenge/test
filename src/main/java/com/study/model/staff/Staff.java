package com.study.model.staff;
/**
 * a_staff javaModel
 *
 */
public class Staff {
	
	private Long staffId;
	
	private Long jobNumber;
	
	private Long departmentId;
	
	private String staffName;
	
	private String phone;
	
	private String email;
	
	private Integer hasInnerlicense;
	
	private String innerlicenselevel;

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Long getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(Long jobNumber) {
		this.jobNumber = jobNumber;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getHasInnerlicense() {
		return hasInnerlicense;
	}

	public void setHasInnerlicense(Integer hasInnerlicense) {
		this.hasInnerlicense = hasInnerlicense;
	}

	public String getInnerlicenselevel() {
		return innerlicenselevel;
	}

	public void setInnerlicenselevel(String innerlicenselevel) {
		this.innerlicenselevel = innerlicenselevel;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", jobNumber=" + jobNumber + ", departmentId=" + departmentId
				+ ", staffName=" + staffName + ", phone=" + phone + ", email=" + email + ", hasInnerlicense="
				+ hasInnerlicense + ", innerlicenselevel=" + innerlicenselevel + "]";
	}

}
