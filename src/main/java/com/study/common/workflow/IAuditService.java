package com.study.common.workflow;

public interface IAuditService {
	/**
	 * 驳回后动作
	 */
	void rejected(Long id);
	
	/**
	 * 审批成功后动作
	 */
	void approved(Long id);	
}
