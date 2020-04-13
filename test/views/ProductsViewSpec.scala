package views

import org.jsoup.Jsoup
import org.specs2.mutable.Specification

class ProductsViewSpec extends Specification {

  "Products view page" should {
    def getHtml() = Jsoup.parse(views.html.products().body)

    "have three products with details" in {
      getHtml().select(".product").size mustEqual 3
      getHtml().select(".product h2").text mustEqual "Where is the beach? why walk when you can dance... and hold on to someone Sunday Mood"
      getHtml().select(".product p").text mustEqual "Price: $150 Price: $100 Price: $50"
      getHtml().select(".product a").text mustEqual "Buy Now Buy Now Buy Now"


    }

    "have products heading" in {
      getHtml().select(".products-heading-text").text mustEqual "Featured Illustrations"
    }




  }

}
