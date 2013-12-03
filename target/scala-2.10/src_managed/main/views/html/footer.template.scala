
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
object footer extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""
<div class="container" id="container-footer" style="background-color:#666666">
  <div class="row">
    <div class="col-md-8 col-md-offset-2">
      <div class="navbar navbar-bottom" style="background-color:#666666;border:none;">
        <ul class="nav nav-justified">
          <li class=""><a href=""><small>HELP</small></a></li>
          <li class=""><a href=""><small>SUBMIT A QUESTION</small></a></li>
          <li class=""><a href=""><small>BOOKMARKLET</small></a></li>
          <li class=""><a href=""><small>CONTACT US</small></a></li>
          <li class=""><a href=""><small>ABOUT ARCHIVE-IT</small></a></li>
        </ul>
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
                    DATE: Tue Dec 03 14:55:25 PST 2013
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/footer.scala.html
                    HASH: ac1a2a7286f8cc5512c357002111c7c5391e0b7f
                    MATRIX: 768->1|863->3
                    LINES: 26->1|29->1
                    -- GENERATED --
                */
            