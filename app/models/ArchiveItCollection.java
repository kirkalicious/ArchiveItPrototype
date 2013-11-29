package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

import play.db.ebean.Model;

@Entity
public class ArchiveItCollection extends Model {

	private static final long serialVersionUID = 6351358612700080365L;

	@Id
	public Long id;
	public String name;
	public CrawlFrequency frequency;
	public ArchiveItCollectionTopic topic1;
	public ArchiveItCollectionTopic topic2;
	public ArchiveItCollectionTopic topic3;
	public Date dateCreated;
	public Date dateLastCrawl;
	public Date dateNextCrawl;
	public ArchiveItCollectionStatus status;

	@OneToMany(mappedBy = "collection")
	public List<Seed> seeds = new ArrayList<Seed>();
	
	@OneToMany(mappedBy = "collection")
	public List<Metadata> metadata = new ArrayList<Metadata>();

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
		this.status = ArchiveItCollectionStatus.ACTIVE;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
