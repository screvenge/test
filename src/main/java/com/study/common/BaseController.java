package com.study.common;

import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.alibaba.fastjson.JSON;
import com.study.dao.FlowDao;
import com.study.model.FlowRecord;

public class BaseController {
	/**
	 * 工作流dao
	 */
	private FlowDao flowDao;
	
	@SuppressWarnings("unchecked")
	public <Q, P> P service(IService<Q, P> iService, Q req) {
		try {
			return iService.doExcute(req);
		} catch (BaseException e) {
			BaseRsp rsp = new BaseRsp();
			rsp.setRetMsg(RetCodeFactory.getMsg(e.getRetCode(), ((BaseReq) req).getI18n()));
			rsp.setRetCode(e.getRetCode());
			return (P) rsp;
		} catch (Exception e) {
			e.printStackTrace();
			return (P) new BaseRsp(5, "error");
		}
	}
	
	@SuppressWarnings("unchecked")
	public <Q, P> P  serviceWithOperation(IService<Q, P> iService, Q req, OperationUtil util) {
		try {
			P rsp = iService.doExcute(req);

			// 用事务管理器判断是否结束
			// https://blog.csdn.net/qq_31854907/article/details/102584154
			// 必须事务结束才能开始记录操作历史
			if (!TransactionSynchronizationManager.isSynchronizationActive() &&  req instanceof IOperationReq) {
				IOperationReq iReq = (IOperationReq) req;
				Object context = util.query(iReq.getId());
				FlowRecord flow = new FlowRecord();
				flow.setBusId(iReq.getId());
				flow.setBusType(iReq.getBusType());
				flow.setCacheData(JSON.toJSONString(context));
				flowDao.addFlowRecord(flow);
			}

			return rsp;
		} catch (BaseException e) {
			BaseRsp rsp = new BaseRsp();
			rsp.setRetMsg(RetCodeFactory.getMsg(e.getRetCode(), ((BaseReq) req).getI18n()));
			rsp.setRetCode(e.getRetCode());
			return (P) rsp;
		} catch (Exception e) {
			e.printStackTrace();
			return (P) new BaseRsp(5, "error");
		}
	}
}
