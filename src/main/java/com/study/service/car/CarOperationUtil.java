package com.study.service.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.OperationUtil;
import com.study.dao.car.CarDao;

@Service("carOperationUtil")
public class CarOperationUtil implements OperationUtil {
	@Autowired
	private CarDao carDao;

	@Override
	public Object query(Long id) {
		return carDao.queryCarById(id);
	}
}
