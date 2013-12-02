package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;

import play.db.ebean.Model;

@Entity
public class Seed extends Model {

	private static final long serialVersionUID = 38853523136852527L;

	@Id
	private Long id;
	private String url;
	private SeedType type;
	private CrawlFrequency frequency;
	private Date dateCreated;
	private Date dateLastCrawled;
	private Status status;

	@ManyToOne
	private ArchiveItCollection collection;

	public Seed(Long id, String url, SeedType t) {
		this.id = id;
		this.url = url;
		this.type = t;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SeedType getType() {
		return type;
	}

	public void setType(SeedType type) {
		this.type = type;
	}

	public CrawlFrequency getFrequency() {
		return frequency;
	}

	public void setFrequency(CrawlFrequency frequency) {
		this.frequency = frequency;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLastCrawled() {
		return dateLastCrawled;
	}

	public void setDateLastCrawled(Date dateLastCrawled) {
		this.dateLastCrawled = dateLastCrawled;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ArchiveItCollection getCollection() {
		return collection;
	}

	public void setCollection(ArchiveItCollection collection) {
		this.collection = collection;
	}

	public Long getId() {
		return id;
	}
}
