package com.study.message.car.req;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.study.common.BaseReq;
import com.study.common.IOperationReq;
import com.study.common.constants.BusType;
import com.study.message.car.data.CarInfo;

public class AddCarReq extends BaseReq implements IOperationReq {
	@NotNull
	@Valid
	private CarInfo carInfo;

	public CarInfo getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}

	@Override
	public String getBusType() {
		return BusType.CAR;
	}

	@Override
	public Long getId() {
		return carInfo.getId();
	}
}
