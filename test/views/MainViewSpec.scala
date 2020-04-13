package views

import org.jsoup.Jsoup
import org.specs2.mutable.Specification
import play.twirl.api.{Html, HtmlFormat}


class MainViewSpec extends Specification {

  "Main view page" should {
    val html: HtmlFormat.Appendable = views.html.main("home")(Html(""))

    "render header and footer" in {
      Jsoup.parse(html.body).select(".header .first-nav-item").get(0).text mustEqual "Blog"
      Jsoup.parse(html.body).select(".footer .contact-heading").text mustEqual "Stay Updated!"
    }


  }

}
