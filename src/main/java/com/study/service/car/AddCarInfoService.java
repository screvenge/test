package com.study.service.car;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.study.common.constants.Constants;
import com.study.common.constants.ServiceId;
import com.study.common.constants.WorkFlow;
import com.study.common.workflow.IAuditService;
import com.study.dao.FlowDao;
import com.study.dao.car.CarDao;
import com.study.dao.staff.StaffDao;
import com.study.message.car.req.AddCarInfoReq;
import com.study.model.FlowRecord;
import com.study.model.car.CarRecord;
import com.study.model.staff.Staff;
import com.study.service.aspect.SendEmail;

/**
 * 添加车辆信息服务类
 * 
 * @author swiftzsl
 *
 */
@Service("addCarInfoService")
public class AddCarInfoService implements IService<AddCarInfoReq, BaseRsp>, IAuditService {

	@Autowired
	private CarDao carDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private FlowDao flowDao;

	@Override
	@SendEmail(serviceId = ServiceId.ADD_CAR, msg = "发件人新增了一辆汽车, 请您审批")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public BaseRsp doExcute(AddCarInfoReq req) throws Exception {
		CarRecord carRecord = addReqInfoToCarRecord(req);

		//在car_info表中插入数据,并返回主键id给carRecord
		carDao.addCarInfo(carRecord);

		//将req的carId属性赋值为id的值
		req.setCarId(carRecord.getId());
		
		//设置创建者为申请员工的工号
		AccountUtil.getInstance().setAccount(req.getJobNumber() + "");

		return new BaseRsp();
	}

	/**
	 * 将请求数据添加到CarRecord模型
	 * 
	 * @throws BaseException
	 */
	private CarRecord addReqInfoToCarRecord(AddCarInfoReq req) throws BaseException {
		CarRecord carRecord = new CarRecord();

		// 查询客户id
		Long consumerId = carDao.selectConsumerIdByName(req.getConsumer());
		if (consumerId != null) {
			carRecord.setConsumerId(consumerId);
		} else {
			throw new BaseException(1030);
		}

		// 查询员工id以及所在部门id
		Staff staff = staffDao.selectStaffByJobNumber(req.getJobNumber());
		if (staff != null) {
			carRecord.setDepartmentId(staff.getDepartmentId());
			carRecord.setStaffId(staff.getStaffId());
		} else {
			throw new BaseException(1040);
		}

		// 将请求数据映射到carRecord模型中
//		BeanUtils.copyProperties(req, carRecord);
		carRecord.setLicenseId(req.getLicenseId());
		carRecord.setTemLicense(req.getTemLicense());
		carRecord.setTemStartDate(req.getTemStartDate());
		carRecord.setTemEndDate(req.getTemEndDate());

		// 判断是否有牌照
		if (!"".equals(carRecord.getLicenseId())) {// 有正式牌照//tips:把引号放在前面,.equals防止空指针88  92 
			carRecord.setHasLicense(Constants.YES);
			carRecord.setHasTempLicense(Constants.NO);
			carRecord.setTemLicense(null);
			carRecord.setTemStartDate(null);
			carRecord.setTemEndDate(null);
		} else if (!"".equals(carRecord.getTemLicense())) {// 无正式牌照但有临时牌照
			carRecord.setHasLicense(Constants.NO);
			carRecord.setHasTempLicense(Constants.YES);
			carRecord.setLicenseId(null);
			if (!"".equals(carRecord.getTemStartDate()) && !"".equals(carRecord.getTemEndDate())) {
				validDateFormat(carRecord);
			} else {
				throw new BaseException(9999);
			}

		} else {// 无任何牌照
			throw new BaseException(9999);
		}
		
		return carRecord;
	}

	/**
	 * 校验日期格式
	 * 
	 * @throws BaseException
	 */
	private void validDateFormat(CarRecord carRecord) throws BaseException {//tips:定义方法时尽量不要用default
		String temStartDate = carRecord.getTemStartDate();
		String temEndDate = carRecord.getTemEndDate();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			@SuppressWarnings("unused")
			Date start = simpleDateFormat.parse(temStartDate);
			@SuppressWarnings("unused")
			Date end = simpleDateFormat.parse(temEndDate);
		} catch (ParseException e) {
			throw new BaseException(9999);
		}
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
