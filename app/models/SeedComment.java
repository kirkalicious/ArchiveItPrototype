package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.Form;
import play.db.ebean.Model;

@Entity
public class SeedComment extends Model {

	private static final long serialVersionUID = 3365253291327438191L;
	@Id
	private Long id;
	private String text;
	private Date dateCreated;
	private boolean show;
	private Long userId; // TODO: map to User object later

	@ManyToOne
	private Seed seed;

	public static Form<SeedComment> commentForm = Form.form(SeedComment.class);

	public SeedComment(String text, Seed seed) {
		this.text = text;
		this.seed = seed;
		this.dateCreated = new Date();
		this.show = true;
		this.userId = 1L; // see above
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Long getUserId() {
		return userId;
	}

	public Seed getSeed() {
		return seed;
	}

}
