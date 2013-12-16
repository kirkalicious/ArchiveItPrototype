package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

import play.db.ebean.Model;
import play.mvc.PathBindable;

@Entity
public class ArchiveItCollection extends Model implements
		PathBindable<ArchiveItCollection> {

	private static final long serialVersionUID = 6351358612700080365L;

	@Id
	private Long id;
	private String name;
	private CrawlFrequency frequency;
	private ArchiveItCollectionTopic topic1;
	private ArchiveItCollectionTopic topic2;
	private ArchiveItCollectionTopic topic3;
	private Date dateCreated;
	private Date dateLastCrawl;
	private Date dateNextCrawl;
	private Status status;
	private PrivacySetting privacy;

	@OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
	public List<Seed> seeds = new ArrayList<Seed>();
	
	@OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
	public List<CollectionMetadata> metadata = new ArrayList<CollectionMetadata>();

	public ArchiveItCollection(Long id, String name, CrawlFrequency frequency,
			ArchiveItCollectionTopic topic1, ArchiveItCollectionTopic topic2,
			ArchiveItCollectionTopic topic3) {
		this.id = id;
		this.name = name;
		this.frequency = frequency;
		this.topic1 = topic1;
		this.topic2 = topic2;
		this.topic3 = topic3;
		this.dateCreated = new Date();
		this.dateLastCrawl = new Date();
		this.dateNextCrawl = new Date();
		this.status = Status.ACTIVE;
		this.setPrivacy(PrivacySetting.PRIVATE);
	}

	public static Finder<Long, ArchiveItCollection> find = new Finder<Long, ArchiveItCollection>(
			Long.class, ArchiveItCollection.class);

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CrawlFrequency getFrequency() {
		return frequency;
	}

	public void setFrequency(CrawlFrequency frequency) {
		this.frequency = frequency;
	}

	public ArchiveItCollectionTopic getTopic1() {
		return topic1;
	}

	public void setTopic1(ArchiveItCollectionTopic topic1) {
		this.topic1 = topic1;
	}

	public ArchiveItCollectionTopic getTopic2() {
		return topic2;
	}

	public void setTopic2(ArchiveItCollectionTopic topic2) {
		this.topic2 = topic2;
	}

	public ArchiveItCollectionTopic getTopic3() {
		return topic3;
	}

	public void setTopic3(ArchiveItCollectionTopic topic3) {
		this.topic3 = topic3;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLastCrawl() {
		return dateLastCrawl;
	}

	public void setDateLastCrawl(Date dateLastCrawl) {
		this.dateLastCrawl = dateLastCrawl;
	}

	public Date getDateNextCrawl() {
		return dateNextCrawl;
	}

	public void setDateNextCrawl(Date dateNextCrawl) {
		this.dateNextCrawl = dateNextCrawl;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Seed> getSeeds() {
		return seeds;
	}

	public void setSeeds(List<Seed> seeds) {
		this.seeds = seeds;
	}

	public List<CollectionMetadata> getCollectionMetadata() {
		return metadata;
	}

	public void setCollectionMetadata(List<CollectionMetadata> metadata) {
		this.metadata = metadata;
	}

	public Long getId() {
		return id;
	}

	public PrivacySetting getPrivacy() {
		return privacy;
	}

	public void setPrivacy(PrivacySetting privacy) {
		this.privacy = privacy;
	}

	@Override
	public String javascriptUnbind() {
		return this.id.toString();
	}

	@Override
	public String unbind(String arg0) {
		return this.id.toString();
	}

	@Override
	public ArchiveItCollection bind(String key, String value) {
		Long id = Long.parseLong(value);
		return find.byId(id);
	}
}
