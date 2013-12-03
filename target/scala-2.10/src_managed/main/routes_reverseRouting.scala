// @SOURCE:/Users/kirkalicious/play-framework/projects/ArchiveItPrototype/conf/routes
// @HASH:0e46ec2b6792e179e9d577b2a8c73ca7e5f0cb1f
// @DATE:Tue Dec 03 15:54:11 PST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:24
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:6
package controllers {

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseArchiveItCollections {
    

// @LINE:13
def edit(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "collections/" + implicitly[PathBindable[Long]].unbind("id", id) + "/edit")
}
                                                

// @LINE:17
def deactivateCollection(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "collections/" + implicitly[PathBindable[Long]].unbind("id", id) + "/deactivate")
}
                                                

// @LINE:15
def update(id:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "collections/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:14
def details(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "collections/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:16
def activateCollection(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "collections/" + implicitly[PathBindable[Long]].unbind("id", id) + "/activate")
}
                                                

// @LINE:18
def addSeed(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "collections/" + implicitly[PathBindable[Long]].unbind("id", id) + "/seed")
}
                                                

// @LINE:11
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "collections")
}
                                                

// @LINE:12
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "collections/save")
}
                                                
    
}
                          

// @LINE:24
// @LINE:21
class ReverseAssets {
    

// @LINE:24
// @LINE:21
def at(file:String): Call = {
   (file: @unchecked) match {
// @LINE:21
case (file) if file == "/fonts/glyphicons-halflings-regular.eot" => Call("GET", _prefix + { _defaultPrefix } + "assets/fonts/glyphicons-halflings-regular.eot")
                                                        
// @LINE:24
case (file) if true => Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
   }
}
                                                
    
}
                          

// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def deleteAlert(id:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "alerts/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:24
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseArchiveItCollections {
    

// @LINE:13
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ArchiveItCollections.edit",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "collections/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/edit"})
      }
   """
)
                        

// @LINE:17
def deactivateCollection : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ArchiveItCollections.deactivateCollection",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "collections/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/deactivate"})
      }
   """
)
                        

// @LINE:15
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ArchiveItCollections.update",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "collections/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:14
def details : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ArchiveItCollections.details",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "collections/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:16
def activateCollection : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ArchiveItCollections.activateCollection",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "collections/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/activate"})
      }
   """
)
                        

// @LINE:18
def addSeed : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ArchiveItCollections.addSeed",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "collections/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/seed"})
      }
   """
)
                        

// @LINE:11
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ArchiveItCollections.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "collections"})
      }
   """
)
                        

// @LINE:12
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ArchiveItCollections.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "collections/save"})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:21
class ReverseAssets {
    

// @LINE:24
// @LINE:21
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      if (file == """ + implicitly[JavascriptLitteral[String]].to("/fonts/glyphicons-halflings-regular.eot") + """) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/fonts/glyphicons-halflings-regular.eot"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      }
   """
)
                        
    
}
              

// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def deleteAlert : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteAlert",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "alerts/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:24
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseArchiveItCollections {
    

// @LINE:13
def edit(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ArchiveItCollections.edit(id), HandlerDef(this, "controllers.ArchiveItCollections", "edit", Seq(classOf[Long]), "POST", """""", _prefix + """collections/$id<[^/]+>/edit""")
)
                      

// @LINE:17
def deactivateCollection(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ArchiveItCollections.deactivateCollection(id), HandlerDef(this, "controllers.ArchiveItCollections", "deactivateCollection", Seq(classOf[Long]), "POST", """""", _prefix + """collections/$id<[^/]+>/deactivate""")
)
                      

// @LINE:15
def update(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ArchiveItCollections.update(id), HandlerDef(this, "controllers.ArchiveItCollections", "update", Seq(classOf[Long]), "PUT", """""", _prefix + """collections/$id<[^/]+>""")
)
                      

// @LINE:14
def details(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ArchiveItCollections.details(id), HandlerDef(this, "controllers.ArchiveItCollections", "details", Seq(classOf[Long]), "GET", """""", _prefix + """collections/$id<[^/]+>""")
)
                      

// @LINE:16
def activateCollection(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ArchiveItCollections.activateCollection(id), HandlerDef(this, "controllers.ArchiveItCollections", "activateCollection", Seq(classOf[Long]), "POST", """""", _prefix + """collections/$id<[^/]+>/activate""")
)
                      

// @LINE:18
def addSeed(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ArchiveItCollections.addSeed(id), HandlerDef(this, "controllers.ArchiveItCollections", "addSeed", Seq(classOf[Long]), "POST", """""", _prefix + """collections/$id<[^/]+>/seed""")
)
                      

// @LINE:11
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ArchiveItCollections.list(), HandlerDef(this, "controllers.ArchiveItCollections", "list", Seq(), "GET", """ Collections""", _prefix + """collections""")
)
                      

// @LINE:12
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ArchiveItCollections.save(), HandlerDef(this, "controllers.ArchiveItCollections", "save", Seq(), "POST", """""", _prefix + """collections/save""")
)
                      
    
}
                          

// @LINE:24
// @LINE:21
class ReverseAssets {
    

// @LINE:21
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map Bootstrap images""", _prefix + """assets/fonts/glyphicons-halflings-regular.eot""")
)
                      
    
}
                          

// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def deleteAlert(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteAlert(id), HandlerDef(this, "controllers.Application", "deleteAlert", Seq(classOf[Long]), "DELETE", """""", _prefix + """alerts/$id<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    