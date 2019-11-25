package com.study.message.car.data;
/**
 * a_car_component 和 a_car_info 表
 * @author swiftzsl
 *
 */

import com.study.model.car.CarComponent;
import com.study.model.car.CarRecord;

public class CarAndComponent {
	
	private CarRecord carRecord;
	
	private CarComponent carComponent;

	public CarRecord getCarRecord() {
		return carRecord;
	}

	public void setCarRecord(CarRecord carRecord) {
		this.carRecord = carRecord;
	}

	public CarComponent getCarComponent() {
		return carComponent;
	}

	public void setCarComponent(CarComponent carComponent) {
		this.carComponent = carComponent;
	}

}
