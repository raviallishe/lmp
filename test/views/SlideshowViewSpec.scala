package views

import org.jsoup.Jsoup
import org.specs2.mutable.Specification

class SlideshowViewSpec extends Specification {

  "Slide show view page" should {
    def getHtml() = Jsoup.parse(views.html.slideshow().body)

    "have three slides with description" in {
      getHtml().select(".slideshow-slide").size mustEqual 3
      getHtml().select(".slideshow-slide h2").text mustEqual "Slide 1 Slide 2 Slide 3"
      getHtml().select(".slideshow-slide p").text mustEqual "Stop wearing Black because they're making more beautiful colors Killing Me Softly Little Miss India"
    }


  }

}
