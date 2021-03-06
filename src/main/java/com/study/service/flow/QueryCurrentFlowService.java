package com.study.service.flow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.AccountUtil;
import com.study.common.IService;
import com.study.dao.FlowDao;
import com.study.message.flow.FlowInfo;
import com.study.message.flow.QueryCurrentFlowReq;
import com.study.message.flow.QueryCurrentFlowRsp;

@Service("queryCurrentFlowService")
public class QueryCurrentFlowService implements IService<QueryCurrentFlowReq, QueryCurrentFlowRsp> {

	@Autowired
	private FlowDao flowDao;
	
	@Override
	public QueryCurrentFlowRsp doExcute(QueryCurrentFlowReq req) throws Exception {
		List<FlowInfo> flows = flowDao.queryCurrentFlow(AccountUtil.getInstance().getAccount());
		QueryCurrentFlowRsp rsp = new QueryCurrentFlowRsp();
		rsp.setFlowInfos(flows);
		return rsp;
	}
}
