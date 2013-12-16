/*
 * Classname:	SeedController
 * 
 * Version:		1.0
 *
 * Date:		Dec 5, 2013
 * 
 * Copyright:
 *
 * This is an unpublished work protected by the United States copyright laws
 * and is proprietary to Verizon Wireless.  Disclosure, copying,
 * reproduction, merger translation, modification, enhancement or use by
 * anyone other than authorized employees or licensees of Verizon Wireless
 * without prior written consent of Verizon Wireless is prohibited.
 *
 * Copyright (C) 1992 - 2013 Verizon Wireless, All Rights Reserved.
 *
 * This copyright notice should not be construed as evidence of publication.
 */
package controllers;



import models.ArchiveItCollection;
import models.Seed;
import models.SeedComment;
import models.SeedMetadata;
import models.SeedType;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Ebean;

public class SeedController extends Controller
{
	
	public static Result details(Seed seed)
	{
		Form<SeedComment> form = Form.form(SeedComment.class);
		return ok(views.html.seeds.index.render(seed.getCollection().getName()
				+ " Collection seed", seed, form));
	}

	public static Result save()
	{
		Form<Seed> form = Form.form(Seed.class).bindFromRequest();
		
		try {
			if (form.hasErrors()) {
				Long id = Long.parseLong(form.field("collectionId").value());
				ArchiveItCollection c = ArchiveItCollection.find.byId(id);
				return badRequest(views.html.collections.detail.render(
						"Error in form", c, form));
			}
			play.data.Form.Field urlField = form.field("url");
			play.data.Form.Field collectionIdField = form.field("collectionId");
			Seed seed = new Seed(null, null, SeedType.DEFAULT);
			if (collectionIdField == null || urlField == null)
			{
				return badRequest(views.html.collections.detail.render(
						"Invalid form",
						seed.getCollection(), form));
			}

			Long collectionId = Long.parseLong(collectionIdField.value());
			ArchiveItCollection c = ArchiveItCollection.find.byId(collectionId);
			c.getSeeds().add(seed);
			seed.setCollection(c);
			seed.setUrl(urlField.value());
			Ebean.save(c);
			return redirect("/collections/" + seed.getCollection().getId());

		}
		catch(Exception e) {
			System.out.println("Error processing seed form: "
					+ e.getLocalizedMessage());
			return CollectionController.list();
		}
		
	}
	
	public static Result update(Seed seed)
	{

		DynamicForm requestForm = Form.form().bindFromRequest();

		// In client, use X-Editable for in-line editing of 'name'
		// Has own format for sending updates.
		if (requestForm.get("pk") != null) {
			String name = requestForm.get("value");
			if (name == null || "".equals(name)) {
				flash("Name cannot be empty");
				return badRequest();
			}
			seed.setUrl(name);
			seed.update();
			return ok();
		}

		Form<Seed> sform = Form.form(Seed.class).bindFromRequest();

		if (sform.hasErrors())
		{
			System.out.println("BAD REQUEST");
			System.out.println(sform.errorsAsJson().toString());
			return badRequest();
		}
		System.out.println(sform.toString());

		// Update privacy settings
		if (sform.get().getPrivacy() != null)
		{
			seed.setPrivacy(sform.get().getPrivacy());
			System.out.println("New privacy setting: "
					+ sform.get().getPrivacy());
		}

		// Update status setting
		if (sform.get().getStatus() != null)
		{
			seed.setStatus(sform.get().getStatus());
			System.out
					.println("New status setting: " + sform.get().getStatus());

		}

		// Update crawl frequency
		if (sform.get().getFrequency() != null)
		{
			seed.setFrequency(sform.get().getFrequency());
			System.out.println("New frequency setting: "
					+ sform.get().getFrequency());

		}
		seed.update();

		return ok();

	}

	/**
	 * Add a comment to a seed
	 * 
	 * @param seed
	 * @return
	 */
	public static Result addComment(Seed seed)
	{
		SeedComment c = Form.form(SeedComment.class).bindFromRequest().get();

		System.out.println("Adding comment to seed " + seed.getId());
		SeedComment comment = new SeedComment(c.getText(), seed);
		seed.getComments().add(comment);

		Ebean.update(seed);

		return redirect(routes.SeedController.details(seed));
	}

	public static Result addMetadata(Seed seed) {
		DynamicForm form = Form.form().bindFromRequest();
		String key = form.get("key");
		String value = form.get("value");
		SeedMetadata meta = new SeedMetadata(key, value);
		meta.setSeed(seed);
		seed.getSeedMetadata().add(meta);
		Ebean.save(seed);
		return ok();
	}

	public static Result deleteMetadata(Seed seed, SeedMetadata meta) {
		seed.getSeedMetadata().remove(meta);
		meta.delete();
		Ebean.save(seed);
		return ok();
	}
}
