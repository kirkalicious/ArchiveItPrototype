package models;

public enum ArchiveItCollectionStatus {

	ACTIVE("Active"), INACTIVE("Inactive"), DORMANT("Dormant");

	private String value;

	private ArchiveItCollectionStatus(String value) {
		this.value = value;
	}

	String getValue() {
		return this.value;
	}
}
