package com.naevatec.monitor.dss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.naevatec.monitor.bean.KmsSgaMember;
import com.naevatec.monitor.bean.SgaMember;
import com.naevatec.monitor.bean.StatusCode;

@Component
public class KmsMonitorServiceImpl extends MonitorServiceImpl implements
		KmsMonitorService {

	@Override
	public StatusCode getKmsStatus() {
		// TODO
		return StatusCode.OK;
	}

	@Override
	public List<? extends SgaMember> getMembers() {
		// TODO
		List<KmsSgaMember> members = new ArrayList<KmsSgaMember>();
		KmsSgaMember m = new KmsSgaMember();
		m.setMemory(2400);
		m.setCpu(71.4);
		m.setImageId("aaasss-sjhsgsg");
		m.setStatus(StatusCode.FAIL);
		m.setUsage(99.90);
		members.add(m);
		KmsSgaMember m1 = new KmsSgaMember();
		m1.setMemory(1200);
		m1.setCpu(0.5);
		m1.setImageId("ffasss-sj222");
		m1.setStatus(StatusCode.OK);
		m1.setUsage(9.90);
		members.add(m1);
		return members;
	}

}
