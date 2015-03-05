package com.naevatec.monitor.dss;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naevatec.monitor.bean.SgaMember;
import com.naevatec.monitor.bean.StatusCode;


@Service
public interface MonitorService {
	String getTimestamp();

	StatusCode getStatus();

	List<? extends SgaMember> getMembers();
}
