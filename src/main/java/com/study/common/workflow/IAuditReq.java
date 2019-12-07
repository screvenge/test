package com.study.common.workflow;

public interface IAuditReq {
	/**
	 * 获取审批人账号
	 * @return 审批人账号
	 */
	String getAuditAccout();
	
	String getServiceId();
}
