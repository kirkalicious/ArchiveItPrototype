package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;

import play.db.ebean.Model;

@Entity
public class Metadata extends Model {

	private static final long serialVersionUID = -6949531195400134288L;
	@Id
	private Long id;
	private String key;
	private String value;

	@ManyToOne
	private ArchiveItCollection collection;

	public Metadata(Long id, String key, String value) {
		this.id = id;
		this.key = key;
		this.value = value;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public ArchiveItCollection getCollection()
	{
		return collection;
	}

	public void setCollection(ArchiveItCollection collection)
	{
		this.collection = collection;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public Long getId()
	{
		return id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
