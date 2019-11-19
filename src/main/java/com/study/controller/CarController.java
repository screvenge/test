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
import com.study.message.car.req.AddCarReq;
import com.study.service.car.CarOperationUtil;

@RequestMapping("/api")
@Controller
public class CarController extends BaseController {
	@Autowired
	private IService<AddCarReq, BaseRsp> addCarService;
	
	@Autowired
	private CarOperationUtil carOperationUtil;
	
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp addCar(@RequestBody AddCarReq req) {
		return super.serviceWithOperation(addCarService, req, carOperationUtil);
	}
}
