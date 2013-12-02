package models;

import com.avaje.ebean.annotation.EnumValue;

public enum DublinCoreMetadata {

	@EnumValue("TITLE")
	TITLE("Title"),

	@EnumValue("CREATOR")
	CREATOR("Creator"),

	@EnumValue("SUBJECT")
	SUBJECT("Subject"),

	@EnumValue("DESCRIPTION")
	DESCRIPTION("Description"),

	@EnumValue("PUBLISHER")
	PUBLISHER("Publisher"),

	@EnumValue("CONTRIBUTOR")
	CONTRIBUTOR("Contributor"),

	@EnumValue("DATE")
	DATE("Date"),

	@EnumValue("TYPE")
	TYPE("Type"),

	@EnumValue("FORMAT")
	FORMAT("Format"),

	@EnumValue("IDENTIFIER")
	IDENTIFIER("Identifier"),

	@EnumValue("SOURCE")
	SOURCE("Source"),

	@EnumValue("RELATION")
	RELATION("Relation"),

	@EnumValue("COVERAGE")
	COVERAGE("Coverage"),

	@EnumValue("RIGHTS")
	RIGHTS("Rights"),

	@EnumValue("COLLECTOR")
	COLLECTOR("Collector"),

	@EnumValue("LANGUAGE")
	LANGUAGE("Language");

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
