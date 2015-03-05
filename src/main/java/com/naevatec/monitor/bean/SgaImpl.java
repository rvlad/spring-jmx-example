package com.naevatec.monitor.bean;

import java.util.List;

public abstract class SgaImpl implements Sga {
	private static final long serialVersionUID = 1L;

	private SgaType name;
	private StatusCode status;
	private String timestamp;
	private List<? extends SgaMember> members;

	public SgaImpl() {
		identify();
	}

	abstract void identify();

	final void setName(SgaType name) {
		this.name = name;
	}

	@Override
	public SgaType getName() {
		return this.name;
	}

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
}
