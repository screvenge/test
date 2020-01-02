package com.study.service.car;

import java.util.List;

/**
 * SelectCarInfo服务类
 * @author swiftzsl
 *
 */

import com.study.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.BaseException;
import com.study.common.IService;
import com.study.dao.car.CarDao;
import com.study.dao.staff.StaffDao;
import com.study.message.car.data.CarInfoOfOne;
import com.study.message.car.req.SelectCarInfoReq;
import com.study.message.car.rsp.SelectCarInfoRsp;

@Service("selectCarInfoService")
public class SelectCarInfoService implements IService<SelectCarInfoReq, SelectCarInfoRsp> {

	@Autowired
	private CarDao carDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private RoleService roleService;


	@Override
	public SelectCarInfoRsp doExcute(SelectCarInfoReq req) throws Exception {
		// 查询员工是否存在
		Long staffId = staffDao.searchStaffIdByJobNumber(req.getJobNumber());
		if (staffId != null) {

			roleService.checkAuthority(req.getJobNumber(), "registerCarInfo");
			
			//查询车辆信息
			List<CarInfoOfOne> carInfoOfOnes = carDao.selectCarInfoByCarNo(req.getCarNo());
			SelectCarInfoRsp rsp = new SelectCarInfoRsp();
			rsp.setCarInfos(carInfoOfOnes);
			return rsp;

		} else {
			throw new BaseException(9999);
		}

	}

}
