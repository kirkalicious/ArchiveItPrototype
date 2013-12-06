package controllers;

import models.AlertMessage;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public static Result index() {

		return CollectionController.list();
    }

	public static Result deleteAlert(Long id) {
		AlertMessage message = AlertMessage.find.byId(id);

		if (message != null) {
			message.delete();
			return ok();
		} else {
			return badRequest("Alert not found");
		}
	}

}
