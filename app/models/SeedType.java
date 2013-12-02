package models;

import com.avaje.ebean.annotation.EnumValue;

public enum SeedType {

	@EnumValue("DEFAULT")
	DEFAULT("Default"),

	@EnumValue("NEWS_RSS")
	NEWS_RSS("News/RSS feed"),

	@EnumValue("ONE_PAGE")
	ONE_PAGE("Crawl one page only");

	private String value;

	private SeedType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
