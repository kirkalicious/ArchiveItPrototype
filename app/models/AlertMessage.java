package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class AlertMessage extends Model {

	private static final long serialVersionUID = -466453921529700996L;

	@Id
	private Long id;

	@ManyToOne
	private Long subscriptionId;

	private String message;

	private String link;

	public AlertMessage(Long subscriptionId, String message, String link) {
		this.subscriptionId = subscriptionId;
		this.message = message;
		this.link = link;
	}

	public static Finder<Long, AlertMessage> find = new Finder<Long, AlertMessage>(
			Long.class, AlertMessage.class);

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getId() {
		return id;
	}

}
