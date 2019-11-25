package com.study.service.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.OperationUtil;
import com.study.dao.car.CarDao;
/**
 * 根据carId查询出info和component两表的信息
 * @author swiftzsl
 *
 */
@Service("carInfoAndComponentInfoOperationUtil")
public class CarInfoAndComponentInfoOperationUtil implements OperationUtil{
	
	@Autowired
	private CarDao carDao;
	
	@Override
	public Object query(Long carId) {
		return carDao.selectCarAndComponentByCarId(carId);
	}

}
