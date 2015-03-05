package com.naevatec.monitor.bean;

public class DssSga extends SgaImpl {
	private static final long serialVersionUID = 1L;

	@Override
	void identify() {
		setName(SgaType.DSS);
	}

}
