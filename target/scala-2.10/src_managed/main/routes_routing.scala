// @SOURCE:/Users/kirkalicious/play-framework/projects/ArchiveItPrototype/conf/routes
// @HASH:0e46ec2b6792e179e9d577b2a8c73ca7e5f0cb1f
// @DATE:Tue Dec 03 15:54:11 PST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Application_deleteAlert1 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("alerts/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:11
private[this] lazy val controllers_ArchiveItCollections_list2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("collections"))))
        

// @LINE:12
private[this] lazy val controllers_ArchiveItCollections_save3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("collections/save"))))
        

// @LINE:13
private[this] lazy val controllers_ArchiveItCollections_edit4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("collections/"),DynamicPart("id", """[^/]+""",true),StaticPart("/edit"))))
        

// @LINE:14
private[this] lazy val controllers_ArchiveItCollections_details5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("collections/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_ArchiveItCollections_update6 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("collections/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:16
private[this] lazy val controllers_ArchiveItCollections_activateCollection7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("collections/"),DynamicPart("id", """[^/]+""",true),StaticPart("/activate"))))
        

// @LINE:17
private[this] lazy val controllers_ArchiveItCollections_deactivateCollection8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("collections/"),DynamicPart("id", """[^/]+""",true),StaticPart("/deactivate"))))
        

// @LINE:18
private[this] lazy val controllers_ArchiveItCollections_addSeed9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("collections/"),DynamicPart("id", """[^/]+""",true),StaticPart("/seed"))))
        

// @LINE:21
private[this] lazy val controllers_Assets_at10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/fonts/glyphicons-halflings-regular.eot"))))
        

// @LINE:24
private[this] lazy val controllers_Assets_at11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """alerts/$id<[^/]+>""","""controllers.Application.deleteAlert(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """collections""","""controllers.ArchiveItCollections.list()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """collections/save""","""controllers.ArchiveItCollections.save()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """collections/$id<[^/]+>/edit""","""controllers.ArchiveItCollections.edit(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """collections/$id<[^/]+>""","""controllers.ArchiveItCollections.details(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """collections/$id<[^/]+>""","""controllers.ArchiveItCollections.update(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """collections/$id<[^/]+>/activate""","""controllers.ArchiveItCollections.activateCollection(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """collections/$id<[^/]+>/deactivate""","""controllers.ArchiveItCollections.deactivateCollection(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """collections/$id<[^/]+>/seed""","""controllers.ArchiveItCollections.addSeed(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/fonts/glyphicons-halflings-regular.eot""","""controllers.Assets.at(path:String = "/public", file:String = "/fonts/glyphicons-halflings-regular.eot")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Application_deleteAlert1(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Application.deleteAlert(id), HandlerDef(this, "controllers.Application", "deleteAlert", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """alerts/$id<[^/]+>"""))
   }
}
        

// @LINE:11
case controllers_ArchiveItCollections_list2(params) => {
   call { 
        invokeHandler(controllers.ArchiveItCollections.list(), HandlerDef(this, "controllers.ArchiveItCollections", "list", Nil,"GET", """ Collections""", Routes.prefix + """collections"""))
   }
}
        

// @LINE:12
case controllers_ArchiveItCollections_save3(params) => {
   call { 
        invokeHandler(controllers.ArchiveItCollections.save(), HandlerDef(this, "controllers.ArchiveItCollections", "save", Nil,"POST", """""", Routes.prefix + """collections/save"""))
   }
}
        

// @LINE:13
case controllers_ArchiveItCollections_edit4(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.ArchiveItCollections.edit(id), HandlerDef(this, "controllers.ArchiveItCollections", "edit", Seq(classOf[Long]),"POST", """""", Routes.prefix + """collections/$id<[^/]+>/edit"""))
   }
}
        

// @LINE:14
case controllers_ArchiveItCollections_details5(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.ArchiveItCollections.details(id), HandlerDef(this, "controllers.ArchiveItCollections", "details", Seq(classOf[Long]),"GET", """""", Routes.prefix + """collections/$id<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_ArchiveItCollections_update6(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.ArchiveItCollections.update(id), HandlerDef(this, "controllers.ArchiveItCollections", "update", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """collections/$id<[^/]+>"""))
   }
}
        

// @LINE:16
case controllers_ArchiveItCollections_activateCollection7(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.ArchiveItCollections.activateCollection(id), HandlerDef(this, "controllers.ArchiveItCollections", "activateCollection", Seq(classOf[Long]),"POST", """""", Routes.prefix + """collections/$id<[^/]+>/activate"""))
   }
}
        

// @LINE:17
case controllers_ArchiveItCollections_deactivateCollection8(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.ArchiveItCollections.deactivateCollection(id), HandlerDef(this, "controllers.ArchiveItCollections", "deactivateCollection", Seq(classOf[Long]),"POST", """""", Routes.prefix + """collections/$id<[^/]+>/deactivate"""))
   }
}
        

// @LINE:18
case controllers_ArchiveItCollections_addSeed9(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.ArchiveItCollections.addSeed(id), HandlerDef(this, "controllers.ArchiveItCollections", "addSeed", Seq(classOf[Long]),"POST", """""", Routes.prefix + """collections/$id<[^/]+>/seed"""))
   }
}
        

// @LINE:21
case controllers_Assets_at10(params) => {
   call(Param[String]("path", Right("/public")), Param[String]("file", Right("/fonts/glyphicons-halflings-regular.eot"))) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map Bootstrap images""", Routes.prefix + """assets/fonts/glyphicons-halflings-regular.eot"""))
   }
}
        

// @LINE:24
case controllers_Assets_at11(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     