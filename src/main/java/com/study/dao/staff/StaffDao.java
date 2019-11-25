package com.study.dao.staff;

import org.apache.ibatis.annotations.Param;

import com.study.model.staff.Staff;

/**
 * 员工信息相关接口类
 * @author swiftzsl
 *
 */
public interface StaffDao {
	
	/**
	 * 添加员工信息 ==>  a_staff表
	 */
	public void addStaff(@Param("staff")Staff staff,@Param("departmentName")String departmentName);
	
	/**
	 * 根据工号查询员工详细信息
	 */
	public Staff selectStaffByJobNumber(@Param("jobNumber")Long jobNumber);
	
	/**
	 * 根据工号查询员工id
	 */
	public Long searchStaffIdByJobNumber(@Param("jobNumber")Long jobNumber);

}
