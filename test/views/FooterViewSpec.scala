package views

import org.jsoup.Jsoup
import org.specs2.mutable.Specification

class FooterViewSpec extends Specification {

  "Footer view page" should {
    def getHtml() = Jsoup.parse(views.html.footer().body)

    "have contact details" in {
      getHtml().select(".contact-heading").text mustEqual "Stay Updated!"
      getHtml().select(".contact-paragraph").text mustEqual "Receive free xxx as a welcome gift."
    }

    "have form to subscribe with name and email add fields" in {
      getHtml().select(".inputs-group-text").toString mustEqual "<input type=\"text\" class=\"inputs-group-text\" placeholder=\"First Name\">"
      getHtml().select(".inputs-group-email").toString mustEqual "<input type=\"email\" class=\"inputs-group-email\" placeholder=\"Your Email Address\">"

      getHtml().select(".inputs-group-btn").attr("value") mustEqual "Subscribe"


    }

  }

}
