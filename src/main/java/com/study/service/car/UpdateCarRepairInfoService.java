package com.study.service.car;

import com.study.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.AccountUtil;
import com.study.common.BaseException;
import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.dao.car.CarDao;
import com.study.dao.staff.StaffDao;
import com.study.message.car.req.UpdateCarRepairInfoReq;
import com.study.model.car.CarRepair;

/**
 * 更新修车信息服务类
 * 
 * @author swiftzsl
 *
 */
@Service("updateCarRepairInfoService")
public class UpdateCarRepairInfoService implements IService<UpdateCarRepairInfoReq, BaseRsp> {

	@Autowired
	private CarDao carDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private RoleService roleService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public BaseRsp doExcute(UpdateCarRepairInfoReq req) throws Exception {

		roleService.checkAuthority(req.getJobNumber(), "updateCarRepairInfo");

		// 1.查询staffId和carId
		Long staffId = staffDao.searchStaffIdByJobNumber(req.getJobNumber());
		Long carId = carDao.searchCarIdByCarNo(req.getCarNo());

		if (staffId != null && carId != null) {
			// 2.获取修车数据
			CarRepair carRepair = carDao.selectCarRepairInfo(carId, req.getComponent());
			if (carRepair != null) {
				if (req.getComponent().equals(carRepair.getComponent())) {
					// set req的repairId属性值
					req.setRepairId(carRepair.getRepairId());

					carRepair.setRepairStaffId(staffId);
					carRepair.setCost(req.getCost());
					carDao.updateCarRepairInfo(carRepair);

					// 设置创建者为员工的工号
					AccountUtil.getInstance().setAccount(req.getJobNumber().toString());

				} else {
					throw new BaseException(9999);
				}

			} else {
				throw new BaseException(9999);
			}

		} else {
			throw new BaseException(9999);
		}

		return new BaseRsp();
	}

}
