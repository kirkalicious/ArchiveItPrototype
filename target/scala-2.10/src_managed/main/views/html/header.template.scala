
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
object header extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""
<div class="container" id="container-header">
  <div class="row" id="header" style="background-color:#333333;color:#fff">
    <div class="col-md-1" style="padding:0"><h3 style="margin-top:3">Partner Logo</h3></div>
    <div class="col-md-11">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <p class="text-right" style="padding-top:0px,margin-top:10px,margin-bottom:10px"><small>Welcome&nbsp;<a href="member/kirktarou">Kirk Tarou</a></small></p>
            <p class="text-right" style="margin-bottom:0px"><small><a href="/settings">Account Settings</a> | <a href="/help">Help</a> | <a href="/admin/user">User Admin</a> | <a href="/logout">Log Out</a></small></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12"><p class="text-left" style="margin-top:0px"><small>member since January 2009</small></p></div>
        </div>
      </div>
    </div>
  </div>
</div>

"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 03 15:54:13 PST 2013
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/header.scala.html
                    HASH: 9b35eb60d57b6e86dc0e1ffdbfee6922d715e0bb
                    MATRIX: 768->1|863->3
                    LINES: 26->1|29->1
                    -- GENERATED --
                */
            