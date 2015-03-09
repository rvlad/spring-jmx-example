package com.naevatec.monitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.newrelic.api.agent.Trace;

@Component
public class NewRelicAnnotationMonitor implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Trace
	public String sessionName() {
		return "session 1";
	}

	@Trace
	public List<String> getSessions() {
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

	@Trace
	public String sessionName2(String name) {

		return "session 1:" + name;
	}

	@Trace
	public Integer getCounter() {
		return (int) (Math.random() * 100);
	}

	@Trace
	public Integer getSessionDssCounter() {
		return (int) (Math.random() * 1000);
	}

	@Trace
	public long getTime() {
		return System.currentTimeMillis();
	}

}
