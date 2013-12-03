
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
object detail_body extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ArchiveItCollection,Form[Seed],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(collection: ArchiveItCollection, seedForm : Form[Seed]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper.twitterBootstrap._


Seq[Any](format.raw/*1.58*/("""

"""),format.raw/*4.1*/("""<script>
$(document).ready(function()"""),format.raw/*5.29*/("""{"""),format.raw/*5.30*/("""
    $("#active-seed-select").click(function(src) """),format.raw/*6.50*/("""{"""),format.raw/*6.51*/("""
       $(".seed-active").each(function() """),format.raw/*7.42*/("""{"""),format.raw/*7.43*/("""
         this.checked = src.target.checked;
    	"""),format.raw/*9.6*/("""}"""),format.raw/*9.7*/(""");
    """),format.raw/*10.5*/("""}"""),format.raw/*10.6*/(""");
    
    $("#inactive-seed-select").click(function(src) """),format.raw/*12.52*/("""{"""),format.raw/*12.53*/("""
       $(".seed-inactive").each(function() """),format.raw/*13.44*/("""{"""),format.raw/*13.45*/("""
         this.checked = src.target.checked;
    	"""),format.raw/*15.6*/("""}"""),format.raw/*15.7*/(""");
    """),format.raw/*16.5*/("""}"""),format.raw/*16.6*/(""");
    
	$("#collectionPrivacy").change(function() """),format.raw/*18.44*/("""{"""),format.raw/*18.45*/("""
		$.ajax("""),format.raw/*19.10*/("""{"""),format.raw/*19.11*/("""
			beforeSend: function()"""),format.raw/*20.26*/("""{"""),format.raw/*20.27*/("""
     			$('#loading-indicator').show();
   			"""),format.raw/*22.7*/("""}"""),format.raw/*22.8*/(""",
   			complete: function()"""),format.raw/*23.27*/("""{"""),format.raw/*23.28*/("""
     			$('#loading-indicator').hide();
   			"""),format.raw/*25.7*/("""}"""),format.raw/*25.8*/(""",
			type: "PUT",
			url: "/collections/" + $(this).attr("collectionId"),
			data: """),format.raw/*28.10*/("""{"""),format.raw/*28.11*/("""privacy: $(this).find("option:selected").val()"""),format.raw/*28.57*/("""}"""),format.raw/*28.58*/("""
			"""),format.raw/*29.4*/("""}"""),format.raw/*29.5*/(""")
			.error(function( msg ) """),format.raw/*30.27*/("""{"""),format.raw/*30.28*/("""
				alert( "Unable to update privacy");
			"""),format.raw/*32.4*/("""}"""),format.raw/*32.5*/(""");
	"""),format.raw/*33.2*/("""}"""),format.raw/*33.3*/(""");
	$("#collectionStatus").change(function() """),format.raw/*34.43*/("""{"""),format.raw/*34.44*/("""
		var request = """),format.raw/*35.17*/("""{"""),format.raw/*35.18*/("""
			beforeSend: function()"""),format.raw/*36.26*/("""{"""),format.raw/*36.27*/("""
     			$('#loading-indicator').show();
   			"""),format.raw/*38.7*/("""}"""),format.raw/*38.8*/(""",
   			complete: function()"""),format.raw/*39.27*/("""{"""),format.raw/*39.28*/("""
     			$('#loading-indicator').hide();
   			"""),format.raw/*41.7*/("""}"""),format.raw/*41.8*/(""",
			type: "PUT",
			url: "/collections/" + $(this).attr("collectionId"),
			data: """),format.raw/*44.10*/("""{"""),format.raw/*44.11*/("""status: $(this).find("option:selected").val()"""),format.raw/*44.56*/("""}"""),format.raw/*44.57*/("""
			"""),format.raw/*45.4*/("""}"""),format.raw/*45.5*/(""";
		console.log(request);
		$.ajax(request)
			.error(function( msg ) """),format.raw/*48.27*/("""{"""),format.raw/*48.28*/("""
			alert( "Unable to update status");
		"""),format.raw/*50.3*/("""}"""),format.raw/*50.4*/(""");
	"""),format.raw/*51.2*/("""}"""),format.raw/*51.3*/(""");
	$("#collectionFrequency").change(function() """),format.raw/*52.46*/("""{"""),format.raw/*52.47*/("""
		var request = """),format.raw/*53.17*/("""{"""),format.raw/*53.18*/("""
			beforeSend: function()"""),format.raw/*54.26*/("""{"""),format.raw/*54.27*/("""
     			$('#loading-indicator').show();
   			"""),format.raw/*56.7*/("""}"""),format.raw/*56.8*/(""",
   			complete: function()"""),format.raw/*57.27*/("""{"""),format.raw/*57.28*/("""
     			$('#loading-indicator').hide();
   			"""),format.raw/*59.7*/("""}"""),format.raw/*59.8*/(""",
			type: "PUT",
			url: "/collections/" + $(this).attr("collectionId"),
			data: """),format.raw/*62.10*/("""{"""),format.raw/*62.11*/("""frequency: $(this).find("option:selected").val()"""),format.raw/*62.59*/("""}"""),format.raw/*62.60*/("""
			"""),format.raw/*63.4*/("""}"""),format.raw/*63.5*/(""";
		console.log(request);
		$.ajax(request)
			.error(function( msg ) """),format.raw/*66.27*/("""{"""),format.raw/*66.28*/("""
			alert( "Unable to update frequency");
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/(""");
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""");
"""),format.raw/*70.1*/("""}"""),format.raw/*70.2*/(""");

</script>
<img src="/images/loading.gif" id="loading-indicator" style="display:none" />
      <div class="row" id="main-collections-active">
        <div class="col-md-12">
          <div class="panel" id="collection-head-panel">
            <div class="panel-heading">Collection</div>
            <div class="panel-body">
              <div class="row" style="background-color:#f0f0f0">
                <div class="col-md-5" style="padding-left:0px">
                  <form action=""""),_display_(Seq[Any](/*81.34*/routes/*81.40*/.ArchiveItCollections.edit(collection.getId()))),format.raw/*81.86*/("""" method="POST">
                  <button class="btn btn-default" style="background-color:#f0f0f0; margin-bottom:5px;float:left;border:none; padding-left:6px;padding-right:6px;">
                    <span class="glyphicon glyphicon-pencil" ></span>
                  </button>
                  <h2>"""),_display_(Seq[Any](/*85.24*/collection/*85.34*/.getName())),format.raw/*85.44*/("""</h2>
              	  </form>
                </div>
                <div class="col-md-3" style="padding-left:0px">
                  <p> created on """),_display_(Seq[Any](/*89.35*/collection/*89.45*/.getDateCreated().format("MM/dd/yy"))),format.raw/*89.81*/("""</p>
                </div>
                <div class="col-md-4" style="padding-left:0px">
                  <select id="collectionPrivacy" collectionId=""""),_display_(Seq[Any](/*92.65*/collection/*92.75*/.getId)),format.raw/*92.81*/("""">
                  	"""),_display_(Seq[Any](/*93.21*/for(p <- PrivacySetting.values()) yield /*93.54*/ {_display_(Seq[Any](format.raw/*93.56*/("""
                  	  <option value=""""),_display_(Seq[Any](/*94.38*/p)),format.raw/*94.39*/("""" """),_display_(Seq[Any](/*94.42*/if(p == collection.getPrivacy())/*94.74*/ {_display_(Seq[Any](format.raw/*94.76*/("""selected""")))})),format.raw/*94.85*/(""">"""),_display_(Seq[Any](/*94.87*/p/*94.88*/.getValue)),format.raw/*94.97*/("""</option>
                  	""")))})),format.raw/*95.21*/("""
                  </select>
                  <select id="collectionStatus" collectionId=""""),_display_(Seq[Any](/*97.64*/collection/*97.74*/.getId)),format.raw/*97.80*/("""">
                  	"""),_display_(Seq[Any](/*98.21*/for(s <- Status.values()) yield /*98.46*/ {_display_(Seq[Any](format.raw/*98.48*/("""
                  	  <option value=""""),_display_(Seq[Any](/*99.38*/s)),format.raw/*99.39*/("""" """),_display_(Seq[Any](/*99.42*/if(s == collection.getStatus())/*99.73*/ {_display_(Seq[Any](format.raw/*99.75*/("""selected""")))})),format.raw/*99.84*/(""">"""),_display_(Seq[Any](/*99.86*/s/*99.87*/.getValue)),format.raw/*99.96*/("""</option>
                  	""")))})),format.raw/*100.21*/("""
                  </select>
                </div>
              </div>
            </div>
            <div class="row" style="background-color:#666666">
              <div class="col-md-12" >
                <div class="btn-group">
                  <button type="button" class="btn">CRAWL SCOPE</button>
                  <button type="button" class="btn">COLLECTION METADATA</button>
                  <button type="button" class="btn">DOCUMENT METADATA</button>
                  <button type="button" class="btn">REPORTS</button>
                  <button type="button" class="btn">MISSING URLS</button>
                </div>
              </div>
            </div>
          </div>
          <div class="panel" id="collection-head-panel">
            <div class="panel-heading">Crawling Activity</div>
            <div class="panel-body">
              <table class="table table-condensed">
                <tr>
                  <th>FREQUENCY</th>
                  <th>MOST RECENT CRAWL</th>
                  <th>NEXT SCHEDULED CRAWL</th>
                </tr>
                <tr>
                  <td><select id="collectionFrequency" collectionId=""""),_display_(Seq[Any](/*127.71*/collection/*127.81*/.getId)),format.raw/*127.87*/("""">
                  	"""),_display_(Seq[Any](/*128.21*/for(s <- CrawlFrequency.values()) yield /*128.54*/ {_display_(Seq[Any](format.raw/*128.56*/("""
                  	  <option value=""""),_display_(Seq[Any](/*129.38*/s)),format.raw/*129.39*/("""" """),_display_(Seq[Any](/*129.42*/if(s == collection.getFrequency())/*129.76*/ {_display_(Seq[Any](format.raw/*129.78*/("""selected""")))})),format.raw/*129.87*/(""">"""),_display_(Seq[Any](/*129.89*/s/*129.90*/.getValue)),format.raw/*129.99*/("""</option>
                  	""")))})),format.raw/*130.21*/("""
                  </select></td>
                  <td>"""),_display_(Seq[Any](/*132.24*/collection/*132.34*/.getDateLastCrawl().format("MM/dd/yyyy 'at' hh:mm a zzz"))),format.raw/*132.91*/("""</td>
                  <td>"""),_display_(Seq[Any](/*133.24*/collection/*133.34*/.getDateNextCrawl().format("MM/dd/yyyy 'at' hh:mm a zzz"))),format.raw/*133.91*/(""" &nbsp; <button class="btn">CRAWL NOW</button></td>
                </tr>
              </table>
            </div>
          </div>
          <div class="panel" id="collection-head-panel">
            <div class="panel-heading">Active Seeds</div>
            <div class="panel-body">
              
              <div class="row" style="background-color:#f0f0f0;">
              """),_display_(Seq[Any](/*143.16*/helper/*143.22*/.form(action = routes.ArchiveItCollections.addSeed(collection.getId))/*143.91*/ {_display_(Seq[Any](format.raw/*143.93*/("""
              	<div class="col-md-6">
              	  """),_display_(Seq[Any](/*145.19*/helper/*145.25*/.inputText(seedForm("url"),'_label->"", 'class->"form-control", 'placeholder->"Enter a new seed URL"))),format.raw/*145.126*/("""
                </div>
                <div class="col-md-2">
                  <input type="submit" class="btn btn-primary" value="ADD SEED">
                </div>
              """)))})),format.raw/*150.16*/("""
                <div class="col-md4">
                	<a href="">+ Add seeds in bulk</a>
                </div>
              </div>
              <table>
                <tr>
                  <th><input type="checkbox" id="active-seed-select"></th>
                  <th>URL</th>
                  <th>FREQUENCY</th>
                  <th>MOST RECENT CRAWL</th>
                  <th>CRAWL REPORT</th>
                  <th>COMMENTS</th>
                </tr>
                """),_display_(Seq[Any](/*164.18*/for(s <- collection.getSeeds()) yield /*164.49*/{_display_(Seq[Any](format.raw/*164.50*/("""
                  """),_display_(Seq[Any](/*165.20*/if(s.getStatus == Status.ACTIVE)/*165.52*/ {_display_(Seq[Any](format.raw/*165.54*/("""
                  <tr>
                    <td><input type="checkbox" class="seed-active" id=""""),_display_(Seq[Any](/*167.73*/s/*167.74*/.getId)),format.raw/*167.80*/(""""></td>
                    <td><a href=""""),_display_(Seq[Any](/*168.35*/s/*168.36*/.getUrl)),format.raw/*168.43*/("""" target="_blank">"""),_display_(Seq[Any](/*168.62*/s/*168.63*/.getUrl)),format.raw/*168.70*/("""</a></td>
                    <td>"""),_display_(Seq[Any](/*169.26*/s/*169.27*/.getFrequency().getValue())),format.raw/*169.53*/("""</td>
                    <td>"""),_display_(Seq[Any](/*170.26*/s/*170.27*/.getDateLastCrawled)),format.raw/*170.46*/("""</td>
                    <td><a href="">view ></a></td>
                    <td><a href="">2 ></a></td>
                  </tr>
                  """)))})),format.raw/*174.20*/("""
                """)))})),format.raw/*175.18*/("""
              </table>
            </div>
            
            <div class="panel" id="collection-head-panel">
            <div class="panel-heading">Inctive Seeds</div>
            <div class="panel-body">
              
              
              <table>
                <tr>
                  <th><input type="checkbox" id="active-seed-select"></th>
                  <th>URL</th>
                  <th>LAST CRAWL</th>
                  <th>CRAWL REPORT</th>
                  <th>COMMENTS</th>
                </tr>
                """),_display_(Seq[Any](/*192.18*/for(s <- collection.getSeeds()) yield /*192.49*/{_display_(Seq[Any](format.raw/*192.50*/("""
                  """),_display_(Seq[Any](/*193.20*/if(s.getStatus == Status.INACTIVE)/*193.54*/ {_display_(Seq[Any](format.raw/*193.56*/("""
                  <tr>
                    <td><input type="checkbox" class="seed-active" id=""""),_display_(Seq[Any](/*195.73*/s/*195.74*/.getId)),format.raw/*195.80*/(""""></td>
                    <td><a href=""""),_display_(Seq[Any](/*196.35*/s/*196.36*/.getUrl)),format.raw/*196.43*/("""" target="_blank">"""),_display_(Seq[Any](/*196.62*/s/*196.63*/.getUrl)),format.raw/*196.70*/("""</a></td>
                    <td>"""),_display_(Seq[Any](/*197.26*/s/*197.27*/.getDateLastCrawled)),format.raw/*197.46*/("""</td>
                    <td><a href="">view ></a></td>
                    <td><a href="">2 ></a></td>
                  </tr>
                  """)))})),format.raw/*201.20*/("""
                """)))})),format.raw/*202.18*/("""
              </table>
            </div>
            
          </div>
        </div>
      </div>
"""))}
    }
    
    def render(collection:ArchiveItCollection,seedForm:Form[Seed]): play.api.templates.HtmlFormat.Appendable = apply(collection,seedForm)
    
    def f:((ArchiveItCollection,Form[Seed]) => play.api.templates.HtmlFormat.Appendable) = (collection,seedForm) => apply(collection,seedForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 03 14:55:26 PST 2013
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/collections/detail_body.scala.html
                    HASH: 17c066aff3aa34d959396b100104a11829c27d14
                    MATRIX: 816->1|999->57|1027->93|1091->130|1119->131|1196->181|1224->182|1293->224|1321->225|1397->275|1424->276|1458->283|1486->284|1573->343|1602->344|1674->388|1703->389|1780->439|1808->440|1842->447|1870->448|1949->499|1978->500|2016->510|2045->511|2099->537|2128->538|2202->585|2230->586|2286->614|2315->615|2389->662|2417->663|2528->746|2557->747|2631->793|2660->794|2691->798|2719->799|2775->827|2804->828|2875->872|2903->873|2934->877|2962->878|3035->923|3064->924|3109->941|3138->942|3192->968|3221->969|3295->1016|3323->1017|3379->1045|3408->1046|3482->1093|3510->1094|3621->1177|3650->1178|3723->1223|3752->1224|3783->1228|3811->1229|3909->1299|3938->1300|4006->1341|4034->1342|4065->1346|4093->1347|4169->1395|4198->1396|4243->1413|4272->1414|4326->1440|4355->1441|4429->1488|4457->1489|4513->1517|4542->1518|4616->1565|4644->1566|4755->1649|4784->1650|4860->1698|4889->1699|4920->1703|4948->1704|5046->1774|5075->1775|5146->1819|5174->1820|5205->1824|5233->1825|5263->1828|5291->1829|5816->2318|5831->2324|5899->2370|6236->2671|6255->2681|6287->2691|6475->2843|6494->2853|6552->2889|6744->3045|6763->3055|6791->3061|6850->3084|6899->3117|6939->3119|7013->3157|7036->3158|7075->3161|7116->3193|7156->3195|7197->3204|7235->3206|7245->3207|7276->3216|7338->3246|7466->3338|7485->3348|7513->3354|7572->3377|7613->3402|7653->3404|7727->3442|7750->3443|7789->3446|7829->3477|7869->3479|7910->3488|7948->3490|7958->3491|7989->3500|8052->3530|9252->4693|9272->4703|9301->4709|9361->4732|9411->4765|9452->4767|9527->4805|9551->4806|9591->4809|9635->4843|9676->4845|9718->4854|9757->4856|9768->4857|9800->4866|9863->4896|9957->4953|9977->4963|10057->5020|10123->5049|10143->5059|10223->5116|10641->5497|10657->5503|10736->5572|10777->5574|10871->5631|10887->5637|11012->5738|11227->5920|11745->6401|11793->6432|11833->6433|11890->6453|11932->6485|11973->6487|12106->6583|12117->6584|12146->6590|12225->6632|12236->6633|12266->6640|12322->6659|12333->6660|12363->6667|12435->6702|12446->6703|12495->6729|12563->6760|12574->6761|12616->6780|12797->6928|12848->6946|13428->7489|13476->7520|13516->7521|13573->7541|13617->7575|13658->7577|13791->7673|13802->7674|13831->7680|13910->7722|13921->7723|13951->7730|14007->7749|14018->7750|14048->7757|14120->7792|14131->7793|14173->7812|14354->7960|14405->7978
                    LINES: 26->1|30->1|32->4|33->5|33->5|34->6|34->6|35->7|35->7|37->9|37->9|38->10|38->10|40->12|40->12|41->13|41->13|43->15|43->15|44->16|44->16|46->18|46->18|47->19|47->19|48->20|48->20|50->22|50->22|51->23|51->23|53->25|53->25|56->28|56->28|56->28|56->28|57->29|57->29|58->30|58->30|60->32|60->32|61->33|61->33|62->34|62->34|63->35|63->35|64->36|64->36|66->38|66->38|67->39|67->39|69->41|69->41|72->44|72->44|72->44|72->44|73->45|73->45|76->48|76->48|78->50|78->50|79->51|79->51|80->52|80->52|81->53|81->53|82->54|82->54|84->56|84->56|85->57|85->57|87->59|87->59|90->62|90->62|90->62|90->62|91->63|91->63|94->66|94->66|96->68|96->68|97->69|97->69|98->70|98->70|109->81|109->81|109->81|113->85|113->85|113->85|117->89|117->89|117->89|120->92|120->92|120->92|121->93|121->93|121->93|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|123->95|125->97|125->97|125->97|126->98|126->98|126->98|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|128->100|155->127|155->127|155->127|156->128|156->128|156->128|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|158->130|160->132|160->132|160->132|161->133|161->133|161->133|171->143|171->143|171->143|171->143|173->145|173->145|173->145|178->150|192->164|192->164|192->164|193->165|193->165|193->165|195->167|195->167|195->167|196->168|196->168|196->168|196->168|196->168|196->168|197->169|197->169|197->169|198->170|198->170|198->170|202->174|203->175|220->192|220->192|220->192|221->193|221->193|221->193|223->195|223->195|223->195|224->196|224->196|224->196|224->196|224->196|224->196|225->197|225->197|225->197|229->201|230->202
                    -- GENERATED --
                */
            