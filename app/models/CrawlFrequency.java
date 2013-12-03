package models;

import com.avaje.ebean.annotation.EnumValue;

public enum CrawlFrequency {

	@EnumValue("2D")
	TWICE_DAILY("Twice Daily"),

	@EnumValue("D")
	DAILY("Daily"),

	@EnumValue("W")
	WEEKLY("Weekly"),

	@EnumValue("M")
	MONTHLY("Monthly"),

	@EnumValue("BM")
	BI_MONTHLY("Bi-monthly"),

	@EnumValue("Q")
	QUARTERLY("Quarterly"),

	@EnumValue("S")
	SEMIANNUALLY("Semiannually"),

	@EnumValue("A")
	ANNUALLY("Annually");
	
	private String value;
	
	private CrawlFrequency(String value) {
        this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
