package com.naevatec.monitor;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.naevatec.monitor.bean.Sga;

@Component
public class SgaAggregate {

	private Sga dss;
	private Sga kms;
	private Sga wowza;

	public Sga getDss() {
		return dss;
	}

	public void setDss(Sga dssSga) {
		this.dss = dssSga;
	}

	public Sga getKms() {
		return kms;
	}

	public void setKms(Sga kmsSga) {
		this.kms = kmsSga;
	}

	public Sga getWowza() {
		return wowza;
	}

	public void setWowza(Sga wowzaSga) {
		this.wowza = wowzaSga;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
