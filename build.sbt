scalaVersion := "2.12.2"

resolvers += Resolver.bintrayRepo("underscoreio", "training")

initialCommands in console := """
      |import doodle.core._
      |import doodle.core.Image._
      |import doodle.syntax._
      |import doodle.jvm.Java2DFrame._
      |import doodle.backend.StandardInterpreter._
      |import doodle.examples._
    """.trim.stripMargin

cleanupCommands in console := """
      |doodle.jvm.quit()
    """.trim.stripMargin

libraryDependencies ++= Seq(
  "underscoreio" %% "doodle" % "0.8.0",
  "org.typelevel" %% "cats" % "0.9.0"
)
