package models;

public enum ArchiveItCollectionTopic {

	ARTS("Arts & Humanities"), BLOGS("Blogs & Social Media"), COMPUTERS(
			"Computers & Technology"), GOVERNMENT("Government"), GOVERNMENT_CITIES(
			"Government - Cities"), GOVERNMENT_COUNTIES("Government - Counties"), EVENTS(
			"Spontaneous Events"), POLITICS("Politics & Elections"), SCIENCE(
			"Science & Health"), SOCIETY("Society & Culture"), UNIVERSITIES(
			"Universities & Libraries");

	private String value;

	private ArchiveItCollectionTopic(String value) {
		this.value = value;
	}

	String getValue() {
		return this.value;
	}
}
