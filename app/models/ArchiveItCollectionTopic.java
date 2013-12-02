package models;

import com.avaje.ebean.annotation.EnumValue;

public enum ArchiveItCollectionTopic {
	@EnumValue("ARTS")
	ARTS("Arts & Humanities"),

	@EnumValue("BLOGS")
	BLOGS("Blogs & Social Media"),

	@EnumValue("COMPUTERS")
	COMPUTERS("Computers & Technology"),

	@EnumValue("GOV")
	GOV("Government"),

	@EnumValue("GOV_CITIES")
	GOV_CITIES("Government - Cities"),

	@EnumValue("GOV_COUNTIES")
	GOV_COUNTIES("Government - Counties"),

	@EnumValue("EVENTS")
	EVENTS("Spontaneous Events"),

	@EnumValue("POLITICS")
	POLITICS("Politics & Elections"),

	@EnumValue("SCIENCE")
	SCIENCE("Science & Health"),

	@EnumValue("SOCIETY")
	SOCIETY("Society & Culture"),

	@EnumValue("UNIVERSITIES")
	UNIVERSITIES("Universities & Libraries");

	private String value;

	private ArchiveItCollectionTopic(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
