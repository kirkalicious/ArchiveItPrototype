
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
object index_body extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[AlertMessage],List[ArchiveItCollection],List[ArchiveItCollection],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(alerts: List[AlertMessage], activeCollections: List[ArchiveItCollection], inactiveCollections: List[ArchiveItCollection]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.124*/("""

"""),format.raw/*4.1*/("""
  <script>
  $(document).ready(function()"""),format.raw/*6.31*/("""{"""),format.raw/*6.32*/("""
    if ($("#messages-panel .alert").size() == 0	) """),format.raw/*7.51*/("""{"""),format.raw/*7.52*/("""
        $("#messages-panel").hide();
    """),format.raw/*9.5*/("""}"""),format.raw/*9.6*/(""";
    $(".alert").bind('closed.bs.alert', function () """),format.raw/*10.53*/("""{"""),format.raw/*10.54*/("""
    $.ajax("""),format.raw/*11.12*/("""{"""),format.raw/*11.13*/("""
		type: "DELETE",
		url: "/alerts/" + $(this).children().first().attr("alertId"),
		data: """),format.raw/*14.9*/("""{"""),format.raw/*14.10*/(""" """),format.raw/*14.11*/("""}"""),format.raw/*14.12*/("""
		"""),format.raw/*15.3*/("""}"""),format.raw/*15.4*/(""")
		.error(function( msg ) """),format.raw/*16.26*/("""{"""),format.raw/*16.27*/("""
		alert( "Error deleting message on server: " + msg );
	"""),format.raw/*18.2*/("""}"""),format.raw/*18.3*/(""");
      // if all alerts are dismissed, hide the 'Messages' panel
      // size is 1 when closing the last alert
      if ($("#messages-panel .alert").size() == 1) """),format.raw/*21.52*/("""{"""),format.raw/*21.53*/("""
        $("#messages-panel").hide();
      """),format.raw/*23.7*/("""}"""),format.raw/*23.8*/("""
    """),format.raw/*24.5*/("""}"""),format.raw/*24.6*/(""");
  """),format.raw/*25.3*/("""}"""),format.raw/*25.4*/(""");
  </script>
<div class="row" id="messages">
  <div class="col-md-12">
    <div class="panel panel-default" id="messages-panel">
      <div class="panel-heading">Messages</div>
      <div class="panel-body">
        """),_display_(Seq[Any](/*32.10*/for(alert <- alerts) yield /*32.30*/ {_display_(Seq[Any](format.raw/*32.32*/("""
        <div class="alert alert-warning alert-dismissable">
          <button type="button" class="close" data-dismiss="alert" aria-hidden="true" alertId=""""),_display_(Seq[Any](/*34.97*/alert/*34.102*/.getId())),format.raw/*34.110*/("""">
          <span class="glyphicon glyphicon-remove-sign"></span>
          </button>
          """),_display_(Seq[Any](/*37.12*/alert/*37.17*/.getMessage())),format.raw/*37.30*/(""" &nbsp; <a href=""""),_display_(Seq[Any](/*37.48*/alert/*37.53*/.getLink())),format.raw/*37.63*/("""" class="alert-link">View Details ></a>
        </div>
        """)))})),format.raw/*39.10*/("""
      </div>
    </div>
  </div>
</div>       
<div class="row" id="main-collections-active">
        <div class="col-md-12">
           <div class="panel" id="colections-active-panel">
            <div class="panel-heading">Active Collections</div>
            <div class="panel-body">
            <form action=""""),_display_(Seq[Any](/*49.28*/routes/*49.34*/.ArchiveItCollections.save())),format.raw/*49.62*/("""" method="POST">
              <button class="btn btn-default" style="background-color:#999999;color:#fff;margin-bottom:5px;">
                <span class="glyphicon glyphicon-plus"></span> CREATE NEW COLLECTION
              </button>
              </form>
              <table class="table table-condensed">
                <tr>
                  <th>NAME</th>
                  <th>MOST RECENT CRAWL</th>
                  <th>NEXT SCHEDULED CRAWL</th>
                </tr>
                """),_display_(Seq[Any](/*60.18*/for(collection <- activeCollections) yield /*60.54*/ {_display_(Seq[Any](format.raw/*60.56*/("""
                <tr>
                  <td><p><a href="/collections/"""),_display_(Seq[Any](/*62.49*/collection/*62.59*/.getId())),format.raw/*62.67*/("""">"""),_display_(Seq[Any](/*62.70*/collection/*62.80*/.getName())),format.raw/*62.90*/("""</a></p></td>
                  <td><p>"""),_display_(Seq[Any](/*63.27*/collection/*63.37*/.getDateLastCrawl().format("MM/dd/yyyy 'at' hh:mm a zzz"))),format.raw/*63.94*/("""</p></td>
                  <td><p>"""),_display_(Seq[Any](/*64.27*/collection/*64.37*/.getDateNextCrawl().format("MM/dd/yyyy 'at' hh:mm a zzz"))),format.raw/*64.94*/(""" &nbsp;&nbsp;<button class="btn btn-default"> CRAWL NOW </button></p></td></p></td>
                </tr>
                """)))})),format.raw/*66.18*/("""
              </table>
            </div>
          </div>
          <div class="panel" id="colections-inactive-panel">
            <div class="panel-heading">Inctive Collections</div>
            <div class="panel-body">
              <table class="table table-condensed">
                <tr>
                  <th>NAME</th>
                  <th>LAST CRAWL</th>
                  <th>&nbsp;</th>
                </tr>
                """),_display_(Seq[Any](/*79.18*/for(collection <- inactiveCollections) yield /*79.56*/ {_display_(Seq[Any](format.raw/*79.58*/("""
                <tr>
                  <td><p><a href="/collections/"""),_display_(Seq[Any](/*81.49*/collection/*81.59*/.getId())),format.raw/*81.67*/("""">"""),_display_(Seq[Any](/*81.70*/collection/*81.80*/.getName())),format.raw/*81.90*/("""</a></p></td>
                  <td><p>"""),_display_(Seq[Any](/*82.27*/collection/*82.37*/.getDateLastCrawl().format("MM/dd/yyyy 'at' hh:mm a zzz"))),format.raw/*82.94*/("""</p></td>
                  <td><form action=""""),_display_(Seq[Any](/*83.38*/routes/*83.44*/.ArchiveItCollections.activateCollection(collection.getId()))),format.raw/*83.104*/("""" method="POST">
                        <input class="btn btn-default" type="submit" value="Activate Collection">
                      </form>
                      </p></td>
                </tr>
                """)))})),format.raw/*88.18*/("""
              </table>
            </div>
          </div>"""))}
    }
    
    def render(alerts:List[AlertMessage],activeCollections:List[ArchiveItCollection],inactiveCollections:List[ArchiveItCollection]): play.api.templates.HtmlFormat.Appendable = apply(alerts,activeCollections,inactiveCollections)
    
    def f:((List[AlertMessage],List[ArchiveItCollection],List[ArchiveItCollection]) => play.api.templates.HtmlFormat.Appendable) = (alerts,activeCollections,inactiveCollections) => apply(alerts,activeCollections,inactiveCollections)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 03 15:54:14 PST 2013
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/collections/index_body.scala.html
                    HASH: b00bcdae80c0068a535f00184b876e83f1867acc
                    MATRIX: 855->1|1088->123|1116->142|1185->184|1213->185|1291->236|1319->237|1387->279|1414->280|1496->334|1525->335|1565->347|1594->348|1712->439|1741->440|1770->441|1799->442|1829->445|1857->446|1912->473|1941->474|2025->531|2053->532|2246->697|2275->698|2346->742|2374->743|2406->748|2434->749|2466->754|2494->755|2749->974|2785->994|2825->996|3018->1153|3033->1158|3064->1166|3198->1264|3212->1269|3247->1282|3301->1300|3315->1305|3347->1315|3443->1379|3794->1694|3809->1700|3859->1728|4390->2223|4442->2259|4482->2261|4588->2331|4607->2341|4637->2349|4676->2352|4695->2362|4727->2372|4803->2412|4822->2422|4901->2479|4973->2515|4992->2525|5071->2582|5226->2705|5701->3144|5755->3182|5795->3184|5901->3254|5920->3264|5950->3272|5989->3275|6008->3285|6040->3295|6116->3335|6135->3345|6214->3402|6297->3449|6312->3455|6395->3515|6643->3731
                    LINES: 26->1|30->1|32->4|34->6|34->6|35->7|35->7|37->9|37->9|38->10|38->10|39->11|39->11|42->14|42->14|42->14|42->14|43->15|43->15|44->16|44->16|46->18|46->18|49->21|49->21|51->23|51->23|52->24|52->24|53->25|53->25|60->32|60->32|60->32|62->34|62->34|62->34|65->37|65->37|65->37|65->37|65->37|65->37|67->39|77->49|77->49|77->49|88->60|88->60|88->60|90->62|90->62|90->62|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|94->66|107->79|107->79|107->79|109->81|109->81|109->81|109->81|109->81|109->81|110->82|110->82|110->82|111->83|111->83|111->83|116->88
                    -- GENERATED --
                */
            