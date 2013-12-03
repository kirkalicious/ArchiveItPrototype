
package views.html.sidebar

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
object help_sidebar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""
    <div class="col-md-3" id="sidebar">
      <div class="panel" id="sidebar-panel">
        <div class="panel panel-default" id="sidebar-panel-help">
        <div class="panel-heading">Help</div>
        <div class="panel-body" style="background-color:#f0f0f0;margin-bottom:20px;">
          <p> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/></p>
        </div>
      </div>
    </div>
  </div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 03 15:54:14 PST 2013
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/sidebar/help_sidebar.scala.html
                    HASH: 0e20cd6a8f8fb0d9603a38ff6dd393c7d8df87ce
                    MATRIX: 782->1|877->3
                    LINES: 26->1|29->1
                    -- GENERATED --
                */
            