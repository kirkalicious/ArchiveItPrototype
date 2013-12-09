import play.GlobalSettings;
import play.libs.F;
import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.SimpleResult;
import controllers.Application;

public class Global extends GlobalSettings {

	// Send all unknown handler requests to application home
	@Override
	public Promise<SimpleResult> onHandlerNotFound(RequestHeader arg0) {
		System.out.println("No handler found");
		System.out.println("Method: " + arg0.method());
		System.out.println("Path: " + arg0.path());
		return F.Promise
				.<SimpleResult> pure((SimpleResult) Application.index());
	}

}