package models;

import com.avaje.ebean.annotation.EnumValue;

public enum PrivacySetting {

	@EnumValue("PUBLIC")
	PUBLIC("Public"),

	@EnumValue("PRIVATE")
	PRIVATE("Private");


	private String value;

	private PrivacySetting(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
