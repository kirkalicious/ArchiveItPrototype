package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private PrivacySetting privacy;
	private Date dateCreated;
	private Date dateLastCrawled;
	private Status status;
	private Boolean verified;
	private String loginUsername;
	private String loginPassword;
	@OneToMany(mappedBy = "seed", cascade = CascadeType.ALL)
	private List<SeedComment> comments;

	@ManyToOne
	private ArchiveItCollection collection;

	public static Finder<Long, Seed> find = new Finder<Long, Seed>(
			Long.class, Seed.class);
	
	public Seed(Long id, String url, SeedType t) {
		this.id = id;
		this.url = url;
		this.type = t;
		this.frequency = CrawlFrequency.DAILY;
		dateCreated = new Date();
		dateLastCrawled = new Date();
		status = models.Status.ACTIVE;
		privacy = PrivacySetting.PUBLIC;
		verified = false;
		loginUsername = "";
		loginPassword = "";
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

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public List<SeedComment> getComments() {
		return this.comments;
	}

	public void addComment(SeedComment c) {
		comments.add(c);
	}

	public PrivacySetting getPrivacy()
	{
		return privacy;
	}

	public void setPrivacy(PrivacySetting privacy)
	{
		this.privacy = privacy;
	}
}
