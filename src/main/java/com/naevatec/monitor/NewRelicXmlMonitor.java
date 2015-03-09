package com.naevatec.monitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class NewRelicXmlMonitor implements
		Serializable {
	private static final long serialVersionUID = 1L;

	public List<String> xmlSessions() {
		return new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("session 1");
				add("session 2");
			}
		};
	}

	public String xmlSessionName2(String name) {
		return "session 1:" + name;
	}

	public Integer xmlSessionsCount() {
		return (int) (Math.random() * 100);
	}

	public Integer xmlSessionDss() {
		return (int) (Math.random() * 1000);
	}

	public long xmlTimeInMilis() {
		return System.currentTimeMillis();
	}

	public Double xmlSessionDssDouble() {
		return (Math.random() * 1000);
	}
}
