
package views.html.collections

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object detail extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,ArchiveItCollection,Form[Seed],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, collection:  ArchiveItCollection, seedForm: Form[Seed]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.73*/("""

"""),_display_(Seq[Any](/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
	
  	"""),_display_(Seq[Any](/*5.5*/collections/*5.16*/.detail_body(collection, seedForm))),format.raw/*5.50*/("""
	  	
""")))}/*7.2*/ {_display_(Seq[Any](format.raw/*7.4*/("""
	"""),_display_(Seq[Any](/*8.3*/sidebar/*8.10*/.help_sidebar())),format.raw/*8.25*/("""
""")))})))}
    }
    
    def render(title:String,collection:ArchiveItCollection,seedForm:Form[Seed]): play.api.templates.HtmlFormat.Appendable = apply(title,collection,seedForm)
    
    def f:((String,ArchiveItCollection,Form[Seed]) => play.api.templates.HtmlFormat.Appendable) = (title,collection,seedForm) => apply(title,collection,seedForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 03 15:54:14 PST 2013
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/collections/detail.scala.html
                    HASH: ad54ff06822331088737a0a397224b5dcf9a0a84
                    MATRIX: 818->1|983->72|1020->75|1039->86|1078->88|1119->95|1138->106|1193->140|1217->147|1255->149|1292->152|1307->159|1343->174
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|35->7|35->7|36->8|36->8|36->8
                    -- GENERATED --
                */
            