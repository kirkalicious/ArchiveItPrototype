package models;

public enum CrawlFrequency {
	TWICE_DAILY("Twice Daily"),
	DAILY("Daily"),
	WEEKLY("Weekly"),
	MONTHLY("Monthly"),
	BI_MONTHLY("Bi-monthly");
	
	private String value;
	
	private CrawlFrequency(String value) {
        this.value = value;
	}

	String getValue() {
		return this.value;
	}
}
