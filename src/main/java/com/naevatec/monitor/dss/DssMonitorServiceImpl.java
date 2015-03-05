package com.naevatec.monitor.dss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.naevatec.monitor.bean.DssSgaMember;
import com.naevatec.monitor.bean.Sga;
import com.naevatec.monitor.bean.SgaImpl;
import com.naevatec.monitor.bean.SgaMember;
import com.naevatec.monitor.bean.StatusCode;

@Component
public class DssMonitorServiceImpl extends MonitorServiceImpl implements
		DssMonitorService {

	@Override
	public StatusCode getDssStatus() {
		// TODO
		return StatusCode.FAIL;
	}

	@Override
	public List<? extends SgaMember> getMembers() {
		// TODO
		List<DssSgaMember> members = new ArrayList<DssSgaMember>();
		DssSgaMember m = new DssSgaMember();
		m.setMemory(5400);
		m.setCpu(71.4);
		m.setImageId("aaasss-sjhsgsg");
		m.setStatus(StatusCode.OK);
		members.add(m);
		DssSgaMember m1 = new DssSgaMember();
		m1.setMemory(200);
		m1.setCpu(0.4);
		m1.setImageId("ffasss-sj222");
		m1.setStatus(StatusCode.FAIL);
		members.add(m1);
		return members;
	}

	@Override
	public Sga getSga() {
		Sga sga = new SgaImpl();
		sga.setMembers(getMembers());
		sga.setStatus(getDssStatus());
		sga.setTimestamp(getTimestamp());
		return sga;
	}

}
