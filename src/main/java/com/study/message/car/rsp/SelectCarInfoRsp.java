package com.study.message.car.rsp;

import java.util.List;

import com.study.common.BaseRsp;
import com.study.message.car.data.CarInfoOfOne;

/**
 * SelectCarInfo页面模型
 * @author swiftzsl
 *
 */
public class SelectCarInfoRsp extends BaseRsp{
	
	private List<CarInfoOfOne> carInfos;

	public List<CarInfoOfOne> getCarInfos() {
		return carInfos;
	}

	public void setCarInfos(List<CarInfoOfOne> carInfos) {
		this.carInfos = carInfos;
	}

}
