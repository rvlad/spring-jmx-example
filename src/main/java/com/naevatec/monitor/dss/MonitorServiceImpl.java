package com.naevatec.monitor.dss;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.naevatec.monitor.bean.StatusCode;

@Component
public abstract class MonitorServiceImpl implements MonitorService {

	@Override
	public String getTimestamp() {
		// TODO
		return new Date().toString();
	}

	@Override
	public StatusCode getStatus() {
		// TODO Auto-generated method stub
		return StatusCode.OK;
	}

}
