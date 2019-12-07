package com.study.service.car;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.BaseException;
import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.common.constants.Constants;
import com.study.dao.car.CarDao;
import com.study.dao.staff.StaffDao;
import com.study.message.car.data.CarCompInfo;
import com.study.message.car.req.RegisterCarInfoReq;
import com.study.model.car.CarComponent;
import com.study.model.car.CarRecord;

/**
 * 登记车辆信息服务类
 * 
 * @author swiftzsl
 *
 */
@Service("registerCarInfoService")
public class RegisterCarInfoService implements IService<RegisterCarInfoReq, BaseRsp> {

	@Autowired
	private CarDao carDao;
	@Autowired
	private StaffDao staffDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public BaseRsp doExcute(RegisterCarInfoReq req) throws Exception {
		// 根据车牌号获取车辆原有信息
		CarRecord carRecord = carDao.selectOneCarRecordByLicense(req.getLicense());

		if (carRecord != null) {
			if (carRecord.getCarNo() == null || carRecord.getCarNo().equals(req.getCarNo())) {
				// 1.获取员工id
				Long staffId = staffDao.selectStaffByJobNumber(req.getJobNumber()).getStaffId();

				// set req的carId属性值
				req.setCarId(carRecord.getId());

				// 2.将车辆部件信息和验车员工id,车辆id赋值给CarComponent模型,并添加到CarComponent表中
				int ifRigster = addCarCompInfoToTable(req.getCarCompInfo(), staffId, carRecord.getId());

				// 3.根据验车结果修改车辆信息
				// 更新carNo, aduitstatus, status, actualregisttime
				carRecord.setCarNo(req.getCarNo());
				carRecord.setAuditStatus(Constants.YES);
				carRecord.setStatus(ifRigster);

				carDao.updateCarInfo(carRecord);

			} else {
				throw new BaseException(1020);
			}

		} else {
			throw new BaseException(1010);
		}
		return new BaseRsp();
	}

	/**
	 * 将carCompInfo信息添加到a_car_component表中
	 */
	private int addCarCompInfoToTable(CarCompInfo carCompInfo, Long staffId, Long carId) {//tips:方法修饰符,注释要全,包括参数注释

		CarComponent carComponent = new CarComponent();
		BeanUtils.copyProperties(carCompInfo, carComponent);
		carComponent.setCheckStaffId(staffId);
		carComponent.setCarId(carId);

		// 默认不合格
		int rigster = Constants.UNQUALIFIED;

		// 所有部件均合格,则入库
		if (carCompInfo.getLight() == Constants.YES && carCompInfo.getMirror() == Constants.YES
				&& carCompInfo.getDoor() == Constants.YES && carCompInfo.getWindow() == Constants.YES
				&& carCompInfo.getEngine() == Constants.YES && carCompInfo.getBattery() == Constants.YES
				&& carCompInfo.getBumper() == Constants.YES && carCompInfo.getBrake() == Constants.YES
				&& carCompInfo.getTire() == Constants.YES && carCompInfo.getChassis() == Constants.YES
				&& carCompInfo.getTurn() == Constants.YES && carCompInfo.getHorn() == Constants.YES) {

			rigster = Constants.YES;

		}

		carComponent.setEnterStore(rigster);

		carDao.addCarComponentInfo(carComponent);

		return rigster;
	}

}
