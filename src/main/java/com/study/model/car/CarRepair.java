package com.study.model.car;

/**
 * a_car_repair javaModel
 *
 */

import java.math.BigDecimal;

public class CarRepair {

	private Long repairId;

	private Long carId;

	private String component;

	private BigDecimal cost;

	private Long applyStaffId;

	private Long repairStaffId;

	private String applyTime;

	private String repairTime;
	
	private String defaulttime = "2011-01-01";

	public String getDefaulttime() {
		return defaulttime;
	}

	public void setDefaulttime(String defaulttime) {
		this.defaulttime = defaulttime;
	}

	public Long getRepairId() {
		return repairId;
	}

	public void setRepairId(Long repairId) {
		this.repairId = repairId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Long getApplyStaffId() {
		return applyStaffId;
	}

	public void setApplyStaffId(Long applyStaffId) {
		this.applyStaffId = applyStaffId;
	}

	public Long getRepairStaffId() {
		return repairStaffId;
	}

	public void setRepairStaffId(Long repairStaffId) {
		this.repairStaffId = repairStaffId;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}

	@Override
	public String toString() {
		return "CarRepair [repairId=" + repairId + ", carId=" + carId + ", component=" + component + ", cost=" + cost
				+ ", applyStaffId=" + applyStaffId + ", repairStaffId=" + repairStaffId + ", applyTime=" + applyTime
				+ ", repairTime=" + repairTime + ", defaulttime=" + defaulttime + "]";
	}

}
