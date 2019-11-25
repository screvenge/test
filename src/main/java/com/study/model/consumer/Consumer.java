package com.study.model.consumer;
/**
 * a_consumer javaModel
 *
 */
public class Consumer {
	
	private Long consumerId;
	
	private String consName;
	
	private String consChineseName;

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public String getConsName() {
		return consName;
	}

	public void setConsName(String consName) {
		this.consName = consName;
	}

	public String getConsChineseName() {
		return consChineseName;
	}

	public void setConsChineseName(String consChineseName) {
		this.consChineseName = consChineseName;
	}

	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", consName=" + consName + ", consChineseName=" + consChineseName
				+ "]";
	}


}
