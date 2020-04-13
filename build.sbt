name := """lmp"""
organization := "ravioli"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies ++= Seq("org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  specs2 % Test,
  "org.jsoup" % "jsoup" % "1.8.1" % "test"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "ravioli.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "ravioli.binders._"
