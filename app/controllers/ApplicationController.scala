package controllers

import javax.inject._
import play.api.mvc._


class ApplicationController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {


  def contact() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.contact())
  }
}
