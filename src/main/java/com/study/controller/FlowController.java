package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.common.BaseController;
import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.message.flow.ApprovedReq;
import com.study.message.flow.QueryCurrentFlowReq;
import com.study.message.flow.QueryCurrentFlowRsp;
import com.study.message.flow.RejectedReq;

@RequestMapping("/api")
@Controller
public class FlowController extends BaseController {
	@Autowired
	private IService<QueryCurrentFlowReq, QueryCurrentFlowRsp> queryCurrentFlowService;
	
	@Autowired
	private IService<RejectedReq, BaseRsp> rejectedService;
	
	@Autowired
	private IService<ApprovedReq, BaseRsp> approvedService;
	
	/**
	 * 获取当前账号的工作流
	 * @return
	 */
	@RequestMapping("/queryCurrentFlow")
	@ResponseBody
	public BaseRsp queryCurrentFlow(@RequestBody QueryCurrentFlowReq req) {
		return super.service(queryCurrentFlowService, req);
	}
	
	/**
	 * 审批通过
	 * @return
	 */
	@RequestMapping("/approved")
	@ResponseBody
	public BaseRsp approved(@RequestBody ApprovedReq req) {
		return super.service(approvedService, req);
	}
	
	/**
	 * 审批驳回
	 * @return
	 */
	@RequestMapping("/reject")
	@ResponseBody
	public BaseRsp reject(@RequestBody RejectedReq req) {
		return super.service(rejectedService, req);
	}
}
