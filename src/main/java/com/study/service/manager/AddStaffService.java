package com.study.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.common.constants.Constants;
import com.study.dao.staff.StaffDao;
import com.study.message.manager.data.StaffInfo;
import com.study.message.manager.req.AddStaffReq;
import com.study.model.staff.Staff;

/**
 * 添加员工信息服务类
 * 
 * @author swiftzsl
 *
 */
@Service("addStaffService")
public class AddStaffService implements IService<AddStaffReq, BaseRsp> {

	@Autowired
	StaffDao staffDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public BaseRsp doExcute(AddStaffReq req) throws Exception {
		
		//将请求数据添加到数据库Staff模型
		Staff staff = addReqInfoToStaff(req);

		//添加员工信息到员工表
		staffDao.addStaff(staff,req.getStaffInfo().getDepartment());
		return new BaseRsp();
		
	}
	
	/**
	 * 将请求数据添加到数据库Staff模型
	 */
	private Staff addReqInfoToStaff(AddStaffReq req) {
		StaffInfo staffInfo = req.getStaffInfo();
		Staff staff = new Staff();
		staff.setJobNumber(staffInfo.getJobNumber());
		staff.setStaffName(staffInfo.getName());
		staff.setPhone(staffInfo.getPhone());
		staff.setEmail(staffInfo.getEmail());
		staff.setInnerlicenselevel(staffInfo.getInnerlicenselevel());
		
		if(staffInfo.getInnerlicenselevel().equals("")) {//无内部驾照等级
			staff.setHasInnerlicense(Constants.NO);
		}else {//有内部驾照
			staff.setHasInnerlicense(Constants.YES);
		}
		return staff;
		
	}

}
