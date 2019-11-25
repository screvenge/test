package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.common.BaseController;
import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.message.car.req.AddCarInfoReq;
import com.study.message.car.req.AddCarRepairInfoReq;
import com.study.message.car.req.AddCarReq;
import com.study.message.car.req.DeleteCarInfoReq;
import com.study.message.car.req.RegisterCarInfoReq;
import com.study.message.car.req.SelectCarInfoReq;
import com.study.message.car.req.UpdateCarRepairInfoReq;
import com.study.message.car.rsp.SelectCarInfoRsp;
import com.study.message.manager.req.AddStaffReq;
import com.study.service.car.CarInfoAndComponentInfoOperationUtil;
import com.study.service.car.CarOperationUtil;
import com.study.service.car.CarRepairOperationUtil;

@RequestMapping("/api")
@Controller
public class CarController extends BaseController {

	@Autowired
	private IService<AddCarReq, BaseRsp> addCarService;
	@Autowired
	private IService<AddStaffReq, BaseRsp> addStaffService;
	@Autowired
	private IService<AddCarInfoReq, BaseRsp> addCarInfoService;
	@Autowired
	private IService<AddCarRepairInfoReq, BaseRsp> addCarRepairInfoService;
	@Autowired
	private IService<RegisterCarInfoReq, BaseRsp> registerCarInfoService;
	@Autowired
	private IService<UpdateCarRepairInfoReq, BaseRsp> updateCarRepairInfoService;
	@Autowired
	private IService<DeleteCarInfoReq, BaseRsp> deleteCarInfoService;
	@Autowired
	private IService<SelectCarInfoReq, SelectCarInfoRsp> selectCarInfoService;

	@Autowired
	private CarOperationUtil carOperationUtil;
	@Autowired
	private CarRepairOperationUtil carRepairOperationUtil;
	@Autowired
	private CarInfoAndComponentInfoOperationUtil carInfoAndComponentInfoOperationUtil;

	/**
	 * 在car_info表中简单插入一行数据
	 */
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp addCar(@RequestBody AddCarReq req) {
		return super.serviceWithOperation(addCarService, req, carOperationUtil);
	}

	/**
	 * 添加员工信息接口
	 */
	@RequestMapping(value = "/addStaff", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp addStaff(@RequestBody AddStaffReq addStaffReq) {
		return super.service(addStaffService, addStaffReq);
	}

	/**
	 * 添加车辆信息
	 */
	@RequestMapping(value = "/addCarInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp addCarInfo(@RequestBody AddCarInfoReq req) {
//		return super.service(addCarInfoService, req);
		return super.serviceWithOperation(addCarInfoService, req, carOperationUtil);
	}

	/**
	 * 添加修车信息
	 */
	@RequestMapping(value = "/addCarRepairInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp addCarRepairInfo(@RequestBody AddCarRepairInfoReq req) {
//		return super.service(addCarRepairInfoService, req);
		return super.serviceWithOperation(addCarRepairInfoService, req, carRepairOperationUtil);
	}

	/**
	 * 登记车辆信息
	 */
	@RequestMapping(value = "/registerCarInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp registerCarInfo(@RequestBody RegisterCarInfoReq req) {
//		return super.service(registerCarInfoService, req);
		return super.serviceWithOperation(registerCarInfoService, req, carInfoAndComponentInfoOperationUtil);
	}

	/**
	 * 更新修车信息
	 */
	@RequestMapping(value = "/updateCarRepairInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp updateCarRepairInfo(@RequestBody UpdateCarRepairInfoReq req) {
//		return super.service(updateCarRepairInfoService, req);
		return super.serviceWithOperation(updateCarRepairInfoService, req, carRepairOperationUtil);
	}

	/**
	 * 删除车辆信息
	 */
	@RequestMapping(value = "/deleteCarInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp deleteCarInfo(@RequestBody DeleteCarInfoReq req) {
		return super.service(deleteCarInfoService, req);
	}

	/**
	 * 查询车辆信息
	 */
	@RequestMapping(value = "/selectCarInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp selectCarInfo(@RequestBody SelectCarInfoReq req) {
		return super.service(selectCarInfoService, req);
	}

}
