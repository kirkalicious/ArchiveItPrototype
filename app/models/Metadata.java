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
	public Long id;
	public String key;
	public String value;

	@ManyToOne
	public ArchiveItCollection collection;

	public Metadata(Long id, String key, String value) {
		this.id = id;
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
