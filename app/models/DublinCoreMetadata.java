package models;

public enum DublinCoreMetadata {
	TITLE("Title"), CREATOR("Creator"), SUBJECT("Subject"), DESCRIPTION(
			"Description"), PUBLISHER("Publisher"), CONTRIBUTOR("Contributor"), DATE(
			"Date"), TYPE("Type"), FORMAT("Format"), IDENTIFIER("Identifier"), SOURCE(
			"Source"), RELATION("Relation"), COVERAGE("Coverage"), RIGHTS(
			"Rights"), COLLECTOR("Collector"), LANGUAGE("Language");

	private String value;

	private DublinCoreMetadata(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return value;
	}
}
