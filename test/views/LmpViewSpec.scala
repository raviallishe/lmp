package views

import org.jsoup.Jsoup
import org.specs2.mutable.Specification

class LmpViewSpec extends Specification {

  "LMP view page" should {
    def getHtml() = Jsoup.parse(views.html.lmp().body)

    "have a logo" in {
      getHtml().select(".logo img").toString mustEqual "<img src=\"/assets/images/logo.png\" class=\"logo-img\">"
    }.pendingUntilFixed("feature is commented")

    "have a company heading" in {
      getHtml().select(".heading h1").toString mustEqual "<h1 class=\"main-heading\">Love me Paris</h1>"
    }
  }

}
