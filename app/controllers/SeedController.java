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



import java.util.Map;

import javax.persistence.metamodel.PluralAttribute.CollectionType;

import com.avaje.ebean.Ebean;

import models.ArchiveItCollection;
import models.Seed;
import models.SeedComment;
import models.SeedType;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class SeedController extends Controller
{
	private static Form<Seed> form = Form.form(Seed.class);
	
	public static Result details(Long id)
	{
		Seed seed = Seed.find.byId(id);
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
	
	public static Result update(Long id)
	{
		Seed s = Seed.find.byId(id);

		Form<Seed> sform = form.bindFromRequest();
		if (sform.hasErrors())
		{
			System.out.println("BAD REQUEST");
			return badRequest();
		}
		System.out.println(sform.toString());

		if (sform.get().getPrivacy() != null)
		{
			s.setPrivacy(sform.get().getPrivacy());
			System.out.println("New privacy setting: "
					+ sform.get().getPrivacy());
		}

		if (sform.get().getStatus() != null)
		{
			s.setStatus(sform.get().getStatus());
			System.out
					.println("New status setting: " + sform.get().getStatus());

		}

		if (sform.get().getFrequency() != null)
		{
			s.setFrequency(sform.get().getFrequency());
			System.out.println("New frequency setting: "
					+ sform.get().getFrequency());

		}
		s.update();

		return ok();

	}

	public static Result update2()
	{
		DynamicForm request = Form.form().bindFromRequest();
		System.out.println(request.toString());
		Map<String, String> data = request.data();
		String pk = request.get("pk");
		System.out.println("pk: " + pk);
		String name = request.get("value");
		System.out.println("name: " + name);

		Seed s = Seed.find.byId(Long.parseLong(pk));
		s.setUrl(name);
		Ebean.save(s);
		return ok();

	}
	public static Result addComment(Long seedId)
	{
		SeedComment c = Form.form(SeedComment.class).bindFromRequest().get();
		Seed seed = Seed.find.byId(seedId);

		System.out.println("Adding comment to seed " + seed.getId());
		SeedComment comment = new SeedComment(c.getText(), seed);
		seed.getComments().add(comment);

		Ebean.update(seed);

		return redirect(routes.SeedController.details(seed.getId()));
	}

}
