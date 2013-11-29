package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;

import play.db.ebean.Model;

@Entity
public class Seed extends Model {

	private static final long serialVersionUID = 38853523136852527L;

	@Id
	public Long id;
	public String url;
	public SeedType type;

	@ManyToOne
	public ArchiveItCollection collection;

	public Seed(Long id, String url, SeedType t) {
		this.id = id;
		this.url = url;
		this.type = t;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
