
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,List[AlertMessage],List[ArchiveItCollection],List[ArchiveItCollection],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, alerts:List[AlertMessage], activeCollections:  List[ArchiveItCollection], inactiveCollections:List[ArchiveItCollection]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.138*/("""

"""),_display_(Seq[Any](/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
	
  	"""),_display_(Seq[Any](/*5.5*/collections/*5.16*/.index_body(alerts, activeCollections, inactiveCollections))),format.raw/*5.75*/("""
	  	
""")))}/*7.2*/ {_display_(Seq[Any](format.raw/*7.4*/("""
	"""),_display_(Seq[Any](/*8.3*/sidebar/*8.10*/.main_sidebar())),format.raw/*8.25*/("""
""")))})),format.raw/*9.2*/("""

"""))}
    }
    
    def render(title:String,alerts:List[AlertMessage],activeCollections:List[ArchiveItCollection],inactiveCollections:List[ArchiveItCollection]): play.api.templates.HtmlFormat.Appendable = apply(title,alerts,activeCollections,inactiveCollections)
    
    def f:((String,List[AlertMessage],List[ArchiveItCollection],List[ArchiveItCollection]) => play.api.templates.HtmlFormat.Appendable) = (title,alerts,activeCollections,inactiveCollections) => apply(title,alerts,activeCollections,inactiveCollections)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 03 15:54:14 PST 2013
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/collections/index.scala.html
                    HASH: 579717ffe5de2d654f9ddadb6a99449646b82711
                    MATRIX: 857->1|1088->137|1125->140|1144->151|1183->153|1224->160|1243->171|1323->230|1347->237|1385->239|1422->242|1437->249|1473->264|1505->266
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|35->7|35->7|36->8|36->8|36->8|37->9
                    -- GENERATED --
                */
            