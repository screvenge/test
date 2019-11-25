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
import com.study.message.car.req.AddCarRepairInfoReq;
import com.study.model.car.CarRepair;

/**
 * 添加修车信息服务类
 * @author swiftzsl
 *
 */
@Service("addCarRepairInfoService")
public class AddCarRepairInfoService implements IService<AddCarRepairInfoReq, BaseRsp>{
	
	@Autowired
	private CarDao carDao;
	@Autowired
	private StaffDao staffDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public BaseRsp doExcute(AddCarRepairInfoReq req) throws Exception {
		//1.查询staffId和carId
		Long staffId = staffDao.searchStaffIdByJobNumber(req.getJobNumber());
		Long carId = carDao.searchCarIdByCarNo(req.getCarNo());

		if(staffId != null && carId != null) {
			
			CarRepair carRepair = new CarRepair();
			carRepair.setCarId(carId);
			carRepair.setApplyStaffId(staffId);
			carRepair.setComponent(req.getComponent());
			//添加修车申请记录
			carDao.addCarRepairInfo(carRepair);
			//set req的主键id
			req.setRepairId(carRepair.getRepairId());
			
		}else {//没有此员工工号或者车辆编号
			throw new BaseException(9999);
		}
		return new BaseRsp();
	}

}
