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
import com.study.message.login.req.LoginReq;
import com.study.message.login.rsp.LoginRsp;

@RequestMapping("/api")
@Controller
public class LoginController extends BaseController {
	/**
	 * 属性名必须和@Service里一致
	 */
	@Autowired
	private IService<LoginReq, LoginRsp> loginService;
	
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseRsp getUserInfo(@RequestBody LoginReq req) {
		return super.service(loginService, req);
	}
}
