package com.study.message.manager.data;

import javax.validation.constraints.NotNull;

/**
 * 与页面交互的员工信息类
 *
 */
public class StaffInfo {
	
	//变量名与json中的变量名完全一致,包括大小写
	@NotNull
	private Long jobNumber;
	@NotNull
	private String department;
	@NotNull
	private String name;
	@NotNull
	private String phone;
	@NotNull
	private String email;
	@NotNull
	private String innerlicenselevel;

	public Long getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(Long jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getInnerlicenselevel() {
		return innerlicenselevel;
	}

	public void setInnerlicenselevel(String innerlicenselevel) {
		this.innerlicenselevel = innerlicenselevel;
	}

	@Override
	public String toString() {
		return "StaffInfo [jobNumber=" + jobNumber + ", department=" + department + ", name=" + name + ", phone="
				+ phone + ", email=" + email + ", innerlicenselevel=" + innerlicenselevel + "]";
	}
	
}
