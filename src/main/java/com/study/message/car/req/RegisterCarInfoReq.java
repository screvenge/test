package com.study.message.car.req;

import javax.validation.constraints.NotNull;

import com.study.common.BaseReq;
import com.study.common.IOperationReq;
import com.study.common.constants.BusType;
import com.study.message.car.data.CarCompInfo;

/**
 * 登记车辆信息请求接口模型
 * @author swiftzsl
 *
 */
public class RegisterCarInfoReq extends BaseReq implements IOperationReq{
	@NotNull
	private Long jobNumber;
	@NotNull
	private String carNo;
	@NotNull
	private String license;
	@NotNull
	private CarCompInfo carCompInfo;
	
	private Long carId;
	
	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

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

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public CarCompInfo getCarCompInfo() {
		return carCompInfo;
	}

	public void setCarCompInfo(CarCompInfo carCompInfo) {
		this.carCompInfo = carCompInfo;
	}

}
