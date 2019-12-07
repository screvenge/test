package com.study.common;

import java.util.Map;

import com.study.common.startup.SpringAware;
import com.study.common.workflow.IAuditService;

/**
 * 审批策略工厂模式
 * @author reborn
 *
 */
public class AuditStrategyFactory {	
	private static final AuditStrategyFactory INSTANCE = new AuditStrategyFactory();
	
	/**
	 * key为serviceId, value为service在spring中的名称
	 */
	private Map<String, String> serviceConfigs;
	
	private AuditStrategyFactory() {
		
	}
	
	public static AuditStrategyFactory getInstance() {
		return INSTANCE;
	}

	public void setServiceConfigs(Map<String, String> serviceConfigs) {
		this.serviceConfigs = serviceConfigs;
	}
	
	public IAuditService getService(String serviceId) {
		return SpringAware.getBean(serviceConfigs.get(serviceId));
	}
}
