package controllers;

import java.util.Date;
import java.util.List;

import models.AlertMessage;
import models.ArchiveItCollection;
import models.ArchiveItCollectionTopic;
import models.CrawlFrequency;
import models.DublinCoreMetadata;
import models.Metadata;
import models.Seed;
import models.SeedComment;
import models.SeedType;
import play.data.Form;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.collections.detail;
import views.html.collections.index;

import com.avaje.ebean.Ebean;

public class CollectionController extends Controller {

	private static final Form<ArchiveItCollection> collectionForm = Form
			.form(ArchiveItCollection.class);
	private static final Form<Seed> seedForm = Form.form(Seed.class);

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
		return ok(detail.render(c.getName() + " Collection", c, seedForm));
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

		if (cform.get().getPrivacy() != null) {
			c.setPrivacy(cform.get().getPrivacy());
			System.out.println("New privacy setting: "
					+ cform.get().getPrivacy());
		}

		if (cform.get().getStatus() != null) {
			c.setStatus(cform.get().getStatus());
			System.out
					.println("New status setting: " + cform.get().getStatus());

		}

		if (cform.get().getFrequency() != null) {
			c.setFrequency(cform.get().getFrequency());
			System.out.println("New frequency setting: "
					+ cform.get().getFrequency());

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

		Metadata data1 = new Metadata(null,
				DublinCoreMetadata.DESCRIPTION.getValue(),
				"This is a description");
		data1.setCollection(collection);
		collection.metadata.add(data1);

		Metadata data2 = new Metadata(null,
				DublinCoreMetadata.PUBLISHER.getValue(), "Random House");
		data2.setCollection(collection);
		collection.metadata.add(data2);

		Metadata data3 = new Metadata(null,
				DublinCoreMetadata.PUBLISHER.getValue(), "Random Bus");
		data3.setCollection(collection);
		collection.metadata.add(data3);

		Seed seed1 = new Seed(null, "activeseed.com/", SeedType.DEFAULT);
		SeedComment comment1 = new SeedComment("TEST: This seed is active",
				seed1);

		Seed seed2 = new Seed(null, "inactiveseed.com/", SeedType.DEFAULT);
		seed2.setStatus(models.Status.INACTIVE);
		SeedComment comment2 = new SeedComment("TEST: This seed is inactive",
				seed2);

		seed1.addComment(comment1);
		seed2.addComment(comment2);

		collection.seeds.add(seed1);
		collection.seeds.add(seed2);

		seed1.setCollection(collection);
		seed2.setCollection(collection);

		try {
			Ebean.save(collection);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list();

	}

	public static Result addSeed(Long collectionId) {
		Form<Seed> seedForm = Form.form(Seed.class).bindFromRequest();
		ArchiveItCollection c = ArchiveItCollection.find.byId(collectionId);
		Seed seed = new Seed(null, seedForm.get().getUrl(), SeedType.DEFAULT);
		seed.setCollection(c);
		c.getSeeds().add(seed);
		Ebean.save(c);
		return details(collectionId);
	}

}
