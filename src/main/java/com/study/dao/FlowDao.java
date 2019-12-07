package com.study.dao;

import java.util.List;

import com.study.message.flow.FlowInfo;
import com.study.model.FlowRecord;

public interface FlowDao {
	int addFlowRecord(FlowRecord flowRecord);
	
	int updateCurrentFlow(FlowRecord flowRecord);
	
	List<FlowInfo> queryCurrentFlow(String account);
}
