package com.naevatec.monitor;

import java.io.Serializable;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.naevatec.monitor:type=NewRelicJmxMonitor", description = "SGA Monitor Info")
public class NewRelicJmxMonitor implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedAttribute
	public String getSessionsName() {
		return "Session " + (int) (Math.random() * 100);
	}

	@ManagedOperation
	public String getSessionName(String name) {
		return "Session " + name;
	}

	@ManagedAttribute
	public Integer getSessionsCount() {
		return (int) (Math.random() * 100);
	}

	@ManagedAttribute
	public Integer getSessionDss() {
		return (int) (Math.random() * 1000);
	}

	@ManagedAttribute
	public long getTimeInMilis() {
		return System.currentTimeMillis();
	}

	@ManagedAttribute
	public Double getSessionDssDouble() {
		return (Math.random() * 1000);
	}
}
