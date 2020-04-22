package views

import org.jsoup.Jsoup
import org.specs2.mutable.Specification

class HeaderViewSpec extends Specification {

  "Header view page" should {
    def getHtml() = Jsoup.parse(views.html.header().body)

    "have different header menu" in {
      getHtml().select(".first-nav-item").size mustEqual 5
      getHtml().select(".first-nav-item").get(0).text mustEqual "BLOG"
      getHtml().select(".first-nav-item").get(1).text mustEqual "SHOP"
      getHtml().select(".first-nav-item").get(2).text mustEqual "COMMISSION"
      getHtml().select(".first-nav-item").get(3).text mustEqual "ABOUT"
      getHtml().select(".first-nav-item").get(4).text mustEqual "CONTACT"
    }
  }
}
