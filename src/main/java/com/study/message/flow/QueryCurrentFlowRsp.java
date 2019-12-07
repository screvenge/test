package com.study.message.flow;

import java.util.List;

import com.study.common.BaseRsp;

public class QueryCurrentFlowRsp extends BaseRsp {
	private List<FlowInfo> flowInfos;

	public List<FlowInfo> getFlowInfos() {
		return flowInfos;
	}

	public void setFlowInfos(List<FlowInfo> flowInfos) {
		this.flowInfos = flowInfos;
	}
}
