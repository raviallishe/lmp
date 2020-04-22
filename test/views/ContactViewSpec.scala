package views

import org.jsoup.Jsoup
import org.specs2.mutable.Specification

class ContactViewSpec extends Specification {

  "Contact view page" should {
    def getHtml() = Jsoup.parse(views.html.contact().body)

    "have following heading" in {
      getHtml().select(".right").text() mustEqual "Feel free to contact me"
    }


  }

}
