package com.study.message.car.req;

import com.study.common.BaseReq;
import com.study.common.IOperationReq;
import com.study.common.constants.BusType;

public class AddCarReq extends BaseReq implements IOperationReq {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getBusType() {
		return BusType.CAR;
	}
}
