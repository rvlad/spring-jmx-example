package com.naevatec.monitor.dss;

import org.springframework.stereotype.Service;

import com.naevatec.monitor.bean.StatusCode;

@Service
public interface DssMonitorService extends MonitorService {
	StatusCode getDssStatus();
}
