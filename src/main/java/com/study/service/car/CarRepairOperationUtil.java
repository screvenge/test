package com.study.service.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.OperationUtil;
import com.study.dao.car.CarDao;

/**
 * 实现OperationUtil接口
 * 重写了query方法为,根据repairId查询carRepair表
 * @author swiftzsl
 *
 */
@Service("carRepairOperationUtil")
public class CarRepairOperationUtil implements OperationUtil{
	
	@Autowired
	private CarDao carDao;
	
	@Override
	public Object query(Long repairId) {
		return carDao.selectCarRepairInfoByRepairId(repairId);
	}

}
