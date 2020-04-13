package views

import org.specs2.mutable.Specification
import org.jsoup.Jsoup

class HomeViewSpec extends Specification {

  "Home view page" should {

    def getHtml() = Jsoup.parse(views.html.home().body)

    "render slideshow page" in {
      getHtml().select("#slideshow").isEmpty mustEqual false
    }

    "render products page" in {
      getHtml().select("#products").isEmpty mustEqual false
    }
  }

}
