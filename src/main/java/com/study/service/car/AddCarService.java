package com.study.service.car;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.dao.car.CarDao;
import com.study.message.car.req.AddCarReq;
import com.study.model.car.CarRecord;

@Service("addCarService")
public class AddCarService implements IService<AddCarReq, BaseRsp> {
	@Autowired
	private CarDao carDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public BaseRsp doExcute(AddCarReq req) throws Exception {
		
		CarRecord car = new CarRecord();
		BeanUtils.copyProperties(car, req.getCarInfo());
		carDao.addCarRecord(car);
		return new BaseRsp();
	}
}
