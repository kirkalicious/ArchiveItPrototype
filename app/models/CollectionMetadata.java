package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.mvc.PathBindable;

@Entity
public class CollectionMetadata extends Metadata implements
		PathBindable<CollectionMetadata> {

	private static final long serialVersionUID = -6837782232788486153L;

	@ManyToOne
	private ArchiveItCollection collection;

	public CollectionMetadata(String key, String value) {
		super(key, value);
	}

	public ArchiveItCollection getCollection() {
		return collection;
	}

	public void setCollection(ArchiveItCollection collection) {
		this.collection = collection;
	}

	@Override
	public CollectionMetadata bind(String key, String value) {
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

	public static Finder<Long, CollectionMetadata> find = new Finder<Long, CollectionMetadata>(
			Long.class, CollectionMetadata.class);
}
