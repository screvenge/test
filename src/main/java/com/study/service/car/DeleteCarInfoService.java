package com.study.service.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.BaseException;
import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.dao.car.CarDao;
import com.study.dao.staff.StaffDao;
import com.study.message.car.req.DeleteCarInfoReq;

/**
 * 删除车辆信息服务类
 * 
 * @author swiftzsl
 *
 */
@Service("deleteCarInfoService")
public class DeleteCarInfoService implements IService<DeleteCarInfoReq, BaseRsp> {

	@Autowired
	private CarDao carDao;
	@Autowired
	private StaffDao staffDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public BaseRsp doExcute(DeleteCarInfoReq req) throws Exception {
		// 1.查询staffId和carId
		Long staffId = staffDao.searchStaffIdByJobNumber(req.getJobNumber());
		Long carId = carDao.searchCarIdByCarNo(req.getCarNo());

		if(staffId != null && carId != null) {
			
			req.setCarId(carId);
			
			carDao.deleteCarInfoByCarId(carId);
			carDao.deletecarComponentInfoByCarId(carId);
			carDao.deletecarRepairInfoByCarId(carId);
			
		}else {
			throw new BaseException(9999);
		}
		
		return new BaseRsp();
	}

}
