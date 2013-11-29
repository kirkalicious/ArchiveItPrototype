package models;

public enum SeedType {
	DEFAULT("Default"), NEWS_RSS("News/RSS feed"), ONE_PAGE(
			"Crawl one page only");

	private String value;

	private SeedType(String value) {
		this.value = value;
	}

	String getValue() {
		return this.value;
	}
}
