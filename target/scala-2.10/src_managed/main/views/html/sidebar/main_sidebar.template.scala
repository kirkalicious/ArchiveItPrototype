
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
object main_sidebar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""
    <div class="col-md-3" id="sidebar">
      <div class="panel" id="sidebar-panel">
        <div class="panel-heading">Current Subscription</div>
        <div class="panel-body">
          <div class="panel" id="sidebar-panel-data">
            <div class="panel-heading dark"><strong>DATA</strong></div>
            <div class="panel-body">
              <ul class="list-group">
                <li class="list-group-item jumbo"><strong>13.6%</strong> used<hr></li>
                <li class="list-group-item">16.4 GB used</li>
                <li class="list-group-item">124 GB available</li>
              </ul>
            </div>
          </div>
          <div class="panel" id="sidebar-panel-documents">
            <div class="panel-heading dark"><strong>DOCUMENTS</strong></div>
            <div class="panel-body">
              <ul class="list-group">
                <li class="list-group-item jumbo"><strong>45.7%</strong> used<hr></li>
                <li class="list-group-item">457,000 used</li>
                <li class="list-group-item">1,000,000 available</li>
              </ul>
            </div>
          </div>
          <div class="panel" id="sidebar-panel-collections">
            <div class="panel-heading dark"><strong>COLLECTIONS</strong></div>
            <div class="panel-body">
              <ul class="list-group">
                <li class="list-group-item jumbo"><strong>4</strong><hr></li>
                <li class="list-group-item">2 inactive</li>
                <li class="list-group-item">1 dormant</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="panel" id="sidebar-panel-all-subscriptions">
        <div class="panel-heading">All Subscriptions</div>
        <div class="panel-body">
          <div class="panel" id="sidebar-panel-subscription-summary">
            <div class="panel-body">
              <ul class="list-group">
              <li class="list-group-item dark"><strong>DATA ARCHIVED</strong></li>
                <li class="list-group-item jumbo"><strong>500 GB</strong></li>
                <li class="list-group-item dark"><strong>DOCUMENTS CRAWLED</strong></li>
                <li class="list-group-item jumbo"><strong>26,045,123</strong></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="panel panel-default" id="sidebar-panel-help">
        <div class="panel-heading">Help</div>
        <div class="panel-body" style="background-color:#f0f0f0;margin-bottom:20px;">
          <p> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/></p>
        </div>
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
                    SOURCE: /Users/kirkalicious/play-framework/projects/ArchiveItPrototype/app/views/sidebar/main_sidebar.scala.html
                    HASH: ff362d32917d8c5556bb66e4025864b71875793f
                    MATRIX: 782->1|877->3
                    LINES: 26->1|29->1
                    -- GENERATED --
                */
            