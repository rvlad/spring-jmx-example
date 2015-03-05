package com.naevatec.monitor.bean;

public enum SgaType {
	DSS("dss"), KMS("kms"), WOWZA("wowza");

	private String name;

	private SgaType(String val) {
		this.name = val;
	}

	public String getName() {
		return this.name;
	}

	public static SgaType findByName(String name) {
		for (SgaType st : SgaType.values())
			if (st.name.equalsIgnoreCase(name))
				return st;
		throw new RuntimeException("SGA type not found: " + name);
	}
}
