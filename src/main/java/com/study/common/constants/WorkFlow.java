package com.study.common.constants;

public interface WorkFlow {
	/**
	 * 不是当前工作流
	 */
	int IS_NOT_CURRENT = 0;
	
	/**
	 * 是当前工作流
	 */
	int IS_CURRENT = 1;
	
	interface AuditStatus {
		/**
		 * 操作历史
		 */
		int OPERATION = 0;
		
		/**
		 * 审批中
		 */
		int AUDITING = 1;
		
		/**
		 * 审批通过
		 */
		int APPROVED = 2;
		
		/**
		 * 驳回
		 */
		int REJECT = 3;
	}
	
	interface FlowStatus {
		/**
		 * 工作流
		 */
		int ADUIT = 0;
		
		/**
		 * 修改
		 */
		int MODIFY = 1;
		
		/**
		 * 新增
		 */
		int ADD = 2;
		
		/**
		 * 删除
		 */
		int DELETE = 3;
	}
}
