package com.naevatec.monitor.bean;

import java.io.Serializable;

public class SgaMember implements Serializable {
	private static final long serialVersionUID = 1L;

	private String imageId;
	private StatusCode status;
	private Double cpu;
	private Integer memory;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public StatusCode getStatus() {
		return status;
	}

	public void setStatus(StatusCode status) {
		this.status = status;
	}

	public Double getCpu() {
		return cpu;
	}

	public void setCpu(Double cpu) {
		this.cpu = cpu;
	}

	public Integer getMemory() {
		return memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}
}
