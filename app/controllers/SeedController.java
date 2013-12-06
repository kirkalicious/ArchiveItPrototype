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


import models.AlertMessage;
import models.Seed;
import play.data.Form;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.seeds.index;

public class SeedController extends Controller
{
	private static Form<Seed> form = Form.form(Seed.class);
	
	public static Result details(Long id)
	{
		Seed seed = Seed.find.byId(id);
		return ok(index.render(seed.getCollection().getName()
				+ " Collection seed", seed));
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

}
