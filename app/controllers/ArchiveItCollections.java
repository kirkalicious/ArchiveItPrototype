package controllers;

import java.util.List;

import models.AlertMessage;
import models.ArchiveItCollection;
import models.ArchiveItCollectionTopic;
import models.CrawlFrequency;
import models.DublinCoreMetadata;
import models.Metadata;
import models.Seed;
import models.SeedType;
import play.data.Form;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.collections.detail;
import views.html.collections.index;

import com.avaje.ebean.Ebean;

public class ArchiveItCollections extends Controller {

	public static Result list() {
		List<ArchiveItCollection> active = ArchiveItCollection.find.where()
				.eq("status", models.Status.ACTIVE).findList();
		List<ArchiveItCollection> inactive = ArchiveItCollection.find.where()
				.eq("status", models.Status.INACTIVE).findList();
		List<AlertMessage> alerts = AlertMessage.find.all();
		return ok(index.render("ArchiveIt Home", alerts, active, inactive));
	}

	public static Result details(Long id) {
		ArchiveItCollection c = ArchiveItCollection.find.byId(id);
		return ok(detail.render(c.getName() + " Collection", c));
	}

	public static Result edit(Long id) {

		return details(id);
	}

	public static Result update(Long id) {
		ArchiveItCollection c = ArchiveItCollection.find.byId(id);

		Form<ArchiveItCollection> cform = Form.form(
				ArchiveItCollection.class)
				.bindFromRequest();
		if (cform.hasErrors()) {
			System.out.println("BAD REQUEST");
			return badRequest();
		}
		System.out.println(cform.toString());
		System.out.println("New privacy setting: " + cform.get().getPrivacy());

		if (cform.get().getPrivacy() != null) {
			c.setPrivacy(cform.get().getPrivacy());
		}

		if (cform.get().getStatus() != null) {
			c.setStatus(cform.get().getStatus());
		}

		if (cform.get().getFrequency() != null) {
			c.setFrequency(cform.get().getFrequency());
		}
		c.update();

		return ok();

	}
	@Transactional
	public static Result activateCollection(Long id) {
		ArchiveItCollection c = ArchiveItCollection.find.byId(id);
		c.setStatus(models.Status.ACTIVE);
		c.update();
		return list();
	}

	@Transactional
	public static Result deactivateCollection(Long id) {
		ArchiveItCollection c = ArchiveItCollection.find.byId(id);
		c.setStatus(models.Status.INACTIVE);
		c.update();
		AlertMessage a = new AlertMessage(1L, "Collection " + c.getName()
				+ " marked inactive.", "/collections/" + c.getId());
		a.save();
		return list();
	}

	static List<ArchiveItCollection> getAllCollections() {
		return ArchiveItCollection.find.all();
		// return Ebean.find(ArchiveItCollection.class).findList();
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
		seed.setCollection(collection);
		try {
			Ebean.save(collection);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list();

	}

}
