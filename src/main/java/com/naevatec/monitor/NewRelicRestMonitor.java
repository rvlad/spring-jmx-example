package com.naevatec.monitor;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewRelicRestMonitor implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@RequestMapping("getSessionsName2")
	public String getSessionsName2() {
		return "Session " + (int) (Math.random() * 100);
	}

	@RequestMapping("getSessionName2")
	public String getSessionName2(String name) {
		return "Session " + name;
	}

	@RequestMapping("getSessionsCount2")
	public Integer getSessionsCount2() {
		return (int) (Math.random() * 100);
	}

	@RequestMapping("getSessionDss2")
	public Integer getSessionDss2() {
		return (int) (Math.random() * 1000);
	}

	@RequestMapping("getTimeInMilis2")
	public long getTimeInMilis2() {
		return System.currentTimeMillis();
	}

	@RequestMapping("getSessionDssDouble2")
	public Double getSessionDssDouble2() {
		return (Math.random() * 1000);
	}
}
