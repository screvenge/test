package com.study.message.common;

public class TaskInfo {
	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 任务名称
	 */
	private String taskName;

	/**
	 * 全限定名
	 */
	private String className;

	/**
	 * 0.启动时执行 1.启动时不执行
	 */
	private Integer runStatus;

	/**
	 * 下次执行时间
	 */
	private String nextTime;

	/**
	 * 周期 单位秒
	 */
	private Integer scheduleTime;

	/**
	 * 时间内执行时间
	 */
	private Integer taskTime;

	/**
	 * 超时时间 单位秒
	 */
	private Integer expireTime;

	/**
	 * 执行ip,-1不限制
	 */
	private String ipAddress;

	/**
	 * 定时任务执行时间,以#分割 -1任何时间执行
	 */
	private String excuteTime;

	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 上次修改时间
	 */
	private String lastModifyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNextTime() {
		return nextTime;
	}

	public void setNextTime(String nextTime) {
		this.nextTime = nextTime;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(Integer runStatus) {
		this.runStatus = runStatus;
	}

	public Integer getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Integer scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Integer getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getExcuteTime() {
		return excuteTime;
	}

	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
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

	public Integer getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(Integer taskTime) {
		this.taskTime = taskTime;
	}

	@Override
	public String toString() {
		return "TaskInfo [id=" + id + ", taskName=" + taskName + ", className=" + className + ", runStatus=" + runStatus
				+ ", nextTime=" + nextTime + ", scheduleTime=" + scheduleTime + ", taskTime=" + taskTime
				+ ", expireTime=" + expireTime + ", ipAddress=" + ipAddress + ", excuteTime=" + excuteTime
				+ ", createTime=" + createTime + ", lastModifyTime=" + lastModifyTime + "]";
	}
}
