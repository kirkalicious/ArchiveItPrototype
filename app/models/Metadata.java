package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;

import play.db.ebean.Model;

@Entity
public abstract class Metadata extends Model {

	private static final long serialVersionUID = -6949531195400134288L;
	@Id
	protected Long id;
	protected String key;
	protected String value;

	public Metadata(String key, String value) {
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
