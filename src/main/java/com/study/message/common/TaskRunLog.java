package com.study.message.common;

public class TaskRunLog {
	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 任务名称
	 */
	private String taskName;

	/**
	 * 日志时间
	 */
	private String logTime;

	/**
	 * 运行状态
	 */
	private Integer status;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 上次修改时间
	 */
	private String lastModifyTime;

	public TaskRunLog() {

	}

	public TaskRunLog(String taskName, Integer status, String description) {
		super();
		this.taskName = taskName;
		this.status = status;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
