package controllers;

import java.util.List;

import models.ArchiveItCollection;
import models.ArchiveItCollectionTopic;
import models.CrawlFrequency;
import models.DublinCoreMetadata;
import models.Metadata;
import models.Seed;
import models.SeedType;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.avaje.ebean.Ebean;

public class ArchiveItCollections extends Controller {

	public static Result list() {
		List<ArchiveItCollection> all = Ebean.find(ArchiveItCollection.class)
				.findList();
		return ok(index.render("ArchiveIt Home", all));
	}

	public static Result details(Long id) {
		List<ArchiveItCollection> all = Ebean.find(ArchiveItCollection.class)
				.findList();
		return ok(index.render("ArchiveIt Home", all));
	}

	public static Result save() {

		ArchiveItCollection collection = new ArchiveItCollection(null,
				"Hispanic Literature", CrawlFrequency.DAILY,
				ArchiveItCollectionTopic.ARTS, null, null);

		Metadata data = new Metadata(null,
				DublinCoreMetadata.DESCRIPTION.getValue(),
				"This is a description");
		data.collection = collection;
		collection.metadata.add(data);
		Seed seed = new Seed(null, "920special.com/", SeedType.DEFAULT);
		collection.seeds.add(seed);
		seed.collection = collection;
		try {
			collection.save();
			data.save();
			seed.save();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<ArchiveItCollection> all = Ebean.find(ArchiveItCollection.class)
				.findList();
		return ok(index.render("ArchiveIt Home", all));
	}

}
