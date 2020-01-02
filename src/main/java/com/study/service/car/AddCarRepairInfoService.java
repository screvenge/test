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
import com.study.common.constants.BusType;
import com.study.common.constants.ServiceId;
import com.study.common.constants.WorkFlow;
import com.study.common.workflow.IAuditService;
import com.study.dao.FlowDao;
import com.study.dao.car.CarDao;
import com.study.dao.staff.StaffDao;
import com.study.message.car.req.AddCarRepairInfoReq;
import com.study.model.FlowRecord;
import com.study.model.car.CarRepair;
import com.study.service.aspect.SendEmail;

/**
 * 添加修车信息服务类
 * 
 * @author swiftzsl
 *
 */
@Service("addCarRepairInfoService")
public class AddCarRepairInfoService implements IService<AddCarRepairInfoReq, BaseRsp>, IAuditService {

	@Autowired
	private CarDao carDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private FlowDao flowDao;
	@Autowired
	private RoleService roleService;

	@Override
	@SendEmail(serviceId = ServiceId.ADD_REPAIRINFO, msg = "发件人新增了修车申请, 请您审批")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public BaseRsp doExcute(AddCarRepairInfoReq req) throws Exception {

		roleService.checkAuthority(req.getJobNumber(),"addCarRepairInfo");

		// 1.查询staffId和carId
		Long staffId = staffDao.searchStaffIdByJobNumber(req.getJobNumber());
		Long carId = carDao.searchCarIdByCarNo(req.getCarNo());

		if (staffId != null && carId != null) {

			CarRepair carRepair = new CarRepair();
			carRepair.setCarId(carId);
			carRepair.setApplyStaffId(staffId);
			carRepair.setComponent(req.getComponent());
			// 添加修车申请记录
			carDao.addCarRepairInfo(carRepair);
			// set req的主键id
			req.setRepairId(carRepair.getRepairId());

			// 设置创建者为申请员工的工号
			AccountUtil.getInstance().setAccount(req.getJobNumber().toString());

		} else {// 没有此员工工号或者车辆编号
			throw new BaseException(9999);
		}
		return new BaseRsp();
	}

	/**
	 * 审批通过
	 */
	@Override
	public void approved(Long id) {
		// 修改汽车状态为审批通过
		carDao.updateAuditStatus(id, WorkFlow.AuditStatus.APPROVED);

		// 修改工作流状态为审批通过
		FlowRecord flowRecord = new FlowRecord();
		flowRecord.setAuditStatus(WorkFlow.AuditStatus.APPROVED);
		flowRecord.setIsCurrent(WorkFlow.IS_NOT_CURRENT);
		flowRecord.setBusId(id);
		flowRecord.setBusType(BusType.CAR);
		flowDao.updateCurrentFlow(flowRecord);
	}

	/**
	 * 审批拒绝(审批拒绝的可以删除)
	 */
	@Override
	public void rejected(Long id) {
		// 修改汽车状态为审批拒绝
		carDao.updateAuditStatus(id, WorkFlow.AuditStatus.REJECT);

		// 修改工作流状态为审批拒绝
		FlowRecord flowRecord = new FlowRecord();
		flowRecord.setAuditStatus(WorkFlow.AuditStatus.REJECT);
		flowRecord.setIsCurrent(WorkFlow.IS_NOT_CURRENT);
		flowRecord.setBusId(id);
		flowRecord.setBusType(BusType.CAR);
		flowDao.updateCurrentFlow(flowRecord);
	}

}
