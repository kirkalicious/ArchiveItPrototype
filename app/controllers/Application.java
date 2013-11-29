package controllers;

import java.util.List;

import models.ArchiveItCollection;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.avaje.ebean.Ebean;

public class Application extends Controller {

    public static Result index() {
		List<ArchiveItCollection> all = Ebean.find(ArchiveItCollection.class)
				.findList();
		return ok(index.render("ArchiveIt Home", all));
    }

}
