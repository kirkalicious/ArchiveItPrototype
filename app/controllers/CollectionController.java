package controllers;

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
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.collections.detail;
import views.html.collections.index;

import com.avaje.ebean.Ebean;

public class CollectionController extends Controller {

	/**
	 * List of all collections
	 * 
	 * @return
	 */
	public static Result list()
	{
		List<ArchiveItCollection> active = ArchiveItCollection.find.where()
				.eq("status", models.Status.ACTIVE).findList();
		List<ArchiveItCollection> inactive = ArchiveItCollection.find.where()
				.eq("status", models.Status.INACTIVE).findList();
		List<AlertMessage> alerts = AlertMessage.find.all();
		return ok(index.render("ArchiveIt Home", alerts, active, inactive));
	}

	/**
	 * Show details of a single collection
	 * 
	 * Pass seed form for adding seeds
	 * 
	 * @param collection
	 * @return
	 */
	public static Result details(ArchiveItCollection collection) {
		Form<Seed> seedForm = Form.form(Seed.class);
		return ok(detail.render(collection.getName() + " Collection",
				collection, seedForm));
	}

	/**
	 * Update fields in a collection
	 * 
	 * @param c
	 *            - the collection to update
	 * @return
	 */
	public static Result update(ArchiveItCollection c) {

		DynamicForm requestForm = Form.form().bindFromRequest();

		// In client, use X-Editable for in-line editing of 'name'
		// Has own format for sending updates.
		if (requestForm.get("pk") != null) {
			String name = requestForm.get("value");
			if (name == null || "".equals(name)) {
				flash("Name cannot be empty");
				return badRequest();
			}
			c.setName(name);
			c.update();
			return ok();
		}

		// Form with values from the client
		Form<ArchiveItCollection> cform = Form.form(
				ArchiveItCollection.class)
				.bindFromRequest();

		if (cform.hasErrors()) {
			System.out.println("BAD REQUEST");
			System.out.println(cform.errorsAsJson().toString());
			return badRequest();
		}

		// Update privacy settings
		if (cform.get().getPrivacy() != null) {
			c.setPrivacy(cform.get().getPrivacy());
			System.out.println("New privacy setting: "
					+ cform.get().getPrivacy());
		}

		// Update Status
		// If set to INACTIVE, create an Alert
		if (cform.get().getStatus() != null) {
			c.setStatus(cform.get().getStatus());
			System.out
					.println("New status setting: " + cform.get().getStatus());
			if (c.getStatus() == models.Status.INACTIVE)
			{
				AlertMessage a = new AlertMessage(1L, "Collection "
						+ c.getName() + " marked inactive.", "/collections/"
						+ c.getId());
				a.save();
			}

		}

		// Update Frequency
		// TODO: Remove if this is not a Collection-level attribute
		if (cform.get().getFrequency() != null) {
			c.setFrequency(cform.get().getFrequency());
			System.out.println("New frequency setting: "
					+ cform.get().getFrequency());

		}

		// Update the object in the database
		c.update();

		return ok();

	}

	/**
	 * Create a collection with set parameters.
	 * 
	 * TODO: Provide form for user to specify all parameters
	 * 
	 * @return
	 */
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

		Seed seed1 = new Seed(null, "http://activeseed.com", SeedType.DEFAULT);
		SeedComment comment1 = new SeedComment("TEST: This seed is active",
				seed1);

		Seed seed2 = new Seed(null, "http://inactiveseed.com", SeedType.DEFAULT);
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

	/**
	 * Add a seed to the collection
	 * 
	 * @param collectionId
	 * @return
	 */
	public static Result addSeed(Long collectionId) {
		Form<Seed> seedForm = Form.form(Seed.class).bindFromRequest();
		ArchiveItCollection c = ArchiveItCollection.find.byId(collectionId);
		Seed seed = new Seed(null, seedForm.get().getUrl(), SeedType.DEFAULT);
		seed.setCollection(c);
		c.getSeeds().add(seed);
		Ebean.save(c);
		return details(c);
	}

}
