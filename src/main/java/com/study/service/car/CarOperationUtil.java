package com.study.service.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.OperationUtil;
import com.study.dao.car.CarDao;
/**
 * 实现OperationUtil接口
 * 重写了query方法为,根据carId查询carInfo表
 * @author swiftzsl
 *
 */
@Service("carOperationUtil")
public class CarOperationUtil implements OperationUtil {
	@Autowired
	private CarDao carDao;

	/**
	 * 根据carId查询carInfo表
	 */
	@Override
	public Object query(Long id) {
		return carDao.queryCarById(id);
	}
}
