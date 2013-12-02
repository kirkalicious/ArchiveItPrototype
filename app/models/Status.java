package models;

import com.avaje.ebean.annotation.EnumValue;

public enum Status {
	@EnumValue("A")
	ACTIVE("Active"),

	@EnumValue("I")
	INACTIVE("Inactive"),

	@EnumValue("D")
	DORMANT("Dormant");

	private String value;

	private Status(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
