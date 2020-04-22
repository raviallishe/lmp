package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test.Helpers._
import play.api.test._


class ApplicationControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "HomeController GET" should {

    "render the home page from a new instance of controller" in {
      val controller = new ApplicationController(stubControllerComponents())
      val home = controller.contact().apply(FakeRequest(GET, "/contact"))

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Feel free to contact me")
    }

  }
}
