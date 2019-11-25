package com.study.model.department;
/**
 * a_department javaModel
 *
 */
public class Department {
	
	private Long departmentId;
	
	private String depName;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", depName=" + depName + "]";
	}
	

}
