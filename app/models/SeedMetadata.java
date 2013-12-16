package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.mvc.PathBindable;

@Entity
public class SeedMetadata extends Metadata implements PathBindable<SeedMetadata> {

	private static final long serialVersionUID = 6788597577588560921L;

	@ManyToOne
	private Seed seed;
	
	public SeedMetadata(String key, String value) {
		super(key, value);
	}

	public Seed getSeed() {
		return seed;
	}

	public void setSeed(Seed seed) {
		this.seed = seed;
	}

	@Override
	public SeedMetadata bind(String key, String value) {
		Long id = Long.parseLong(value);
		return find.byId(id);
	}

	@Override
	public String unbind(String key) {
		return this.id.toString();
	}

	@Override
	public String javascriptUnbind() {
		return this.id.toString();
	}

	public static Finder<Long, SeedMetadata> find = new Finder<Long, SeedMetadata>(
			Long.class, SeedMetadata.class);
}
