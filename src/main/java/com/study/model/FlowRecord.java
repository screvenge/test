package com.study.model;

public class FlowRecord {
	private Long id;
	
	private Long busId;
	
	private String busType;
	
	private String cacheData;
	
	private String createTime;
	
	private String lastModifyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getCacheData() {
		return cacheData;
	}

	public void setCacheData(String cacheData) {
		this.cacheData = cacheData;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
}
