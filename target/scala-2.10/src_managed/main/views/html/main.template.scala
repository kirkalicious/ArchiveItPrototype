
package views.html

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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(mainContent: Html)(mainSidebar: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.55*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <meta name='viewport' content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*9.99*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.54*/routes/*10.60*/.Assets.at("stylesheets/main.css"))),format.raw/*10.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.59*/routes/*11.65*/.Assets.at("images/favicon.png"))),format.raw/*11.97*/("""">
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*12.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("javascripts/bootstrap.js"))),format.raw/*13.67*/("""" type="text/javascript"></script>
        
    </head>
    <body>
    	<section class="header">"""),_display_(Seq[Any](/*17.31*/header())),format.raw/*17.39*/("""</section>
    	<section class="nav">"""),_display_(Seq[Any](/*18.28*/nav())),format.raw/*18.33*/("""</section>
    	<section class="main">
    	<div class="container" id="container-main">
  		  <div class="row" id="main">
  		    <div class="col-md-9" id="main-view">
  			<section class="main-content">"""),_display_(Seq[Any](/*23.37*/mainContent)),format.raw/*23.48*/("""</section>
  			</div>
  			<section class="main-sidebar">"""),_display_(Seq[Any](/*25.37*/mainSidebar)),format.raw/*25.48*/("""</section>
  		  </div>
  		 </div>
  		</section>
		<section class="footer">"""),_display_(Seq[Any](/*29.28*/footer())),format.raw/*29.36*/("""</section>
    </body>
</html>
"""))}
    }
    
    def render(title:String,mainContent:Html,mainSidebar:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(mainContent)(mainSidebar)
    
    def f:((String) => (Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (mainContent) => (mainSidebar) => apply(title)(mainContent)(mainSidebar)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 03 14:55:26 PST 2013
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/main.scala.html
                    HASH: 4b0e572e717a0720fd8c5fa57cf252e8234f661f
                    MATRIX: 783->1|930->54|1018->107|1044->112|1220->253|1234->259|1294->298|1386->354|1401->360|1457->394|1554->455|1569->461|1623->493|1684->518|1699->524|1766->569|1859->626|1874->632|1934->670|2067->767|2097->775|2171->813|2198->818|2438->1022|2471->1033|2566->1092|2599->1103|2713->1181|2743->1189
                    LINES: 26->1|29->1|35->7|35->7|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|45->17|45->17|46->18|46->18|51->23|51->23|53->25|53->25|57->29|57->29
                    -- GENERATED --
                */
            