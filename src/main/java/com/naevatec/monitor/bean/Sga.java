package com.naevatec.monitor.bean;

import java.io.Serializable;
import java.util.List;

public interface Sga extends Serializable {
	SgaType getName();

	StatusCode getStatus();

	void setStatus(StatusCode status);

	String getTimestamp();

	void setTimestamp(String timestamp);

	List<? extends SgaMember> getMembers();

	void setMembers(List<? extends SgaMember> members);
}
