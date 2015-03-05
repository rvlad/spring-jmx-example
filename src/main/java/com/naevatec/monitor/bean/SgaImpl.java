package com.naevatec.monitor.bean;

import java.util.List;

import com.google.gson.Gson;

public class SgaImpl implements Sga {
	private static final long serialVersionUID = 1L;

	private StatusCode status;
	private String timestamp;
	private List<? extends SgaMember> members;

	@Override
	public StatusCode getStatus() {
		return status;
	}

	@Override
	public void setStatus(StatusCode status) {
		this.status = status;
	}

	@Override
	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public List<? extends SgaMember> getMembers() {
		return members;
	}

	@Override
	public void setMembers(List<? extends SgaMember> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
