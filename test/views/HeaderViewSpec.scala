package views

import org.jsoup.Jsoup
import org.specs2.mutable.Specification

class HeaderViewSpec extends Specification {

  "Header view page" should {
    def getHtml() = Jsoup.parse(views.html.header().body)

    "have different header menu" in {
      getHtml().select(".first-nav-item").size mustEqual 5
      getHtml().select(".first-nav-item").get(0).text mustEqual "Blog"
      getHtml().select(".first-nav-item").get(1).text mustEqual "Shop"
      getHtml().select(".first-nav-item").get(2).text mustEqual "Comission"
      getHtml().select(".first-nav-item").get(3).text mustEqual "About"
      getHtml().select(".first-nav-item").get(4).text mustEqual "Contact Us"
    }

    "have a logo" in {
      getHtml().select(".logo img").toString mustEqual "<img src=\"/assets/images/logo.png\" class=\"logo-img\">"
    }

    "have a company heading" in {
      getHtml().select(".heading h1").toString mustEqual "<h1 class=\"heading-text\">Love Me Paris</h1>"
    }
  }

}