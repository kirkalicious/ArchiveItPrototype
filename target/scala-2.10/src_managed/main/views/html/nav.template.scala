
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
object nav extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""
<div class="container" id="container-nav">
  <div class="row" id="nav">
    <nav class="navbar" role="navigation" style="background-color:#666666;border-radius:0;">
      <ul class="nav navbar-nav">
        <li><a href="/collections" class="navbar-brand">COLLECTIONS</a></li>
        <li><a href="/crawls" class="navbar-brand">CRAWLS</a></li>
        <li><a href="/reports" class="navbar-brand">REPORTS</a></li>
        <li><a href="/archive" class="navbar-brand">ARCHIVE</a></li>
      </ul>
    </nav>
  </div>
</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 03 14:55:26 PST 2013
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/nav.scala.html
                    HASH: b1244657b6e69dfc5524d19eb0994677123e8cd2
                    MATRIX: 765->1|860->3
                    LINES: 26->1|29->1
                    -- GENERATED --
                */
            