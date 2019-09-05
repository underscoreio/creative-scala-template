import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._
import doodle.reactor._
import scala.concurrent.duration._

// To use this example:
//
// 1. run `sbt`
// 2. run the `run` command within `sbt`
object Example {
  val image =
    Image
      .circle(10)
      .fillColor(Color.red)
      .on(Image.circle(20).fillColor(Color.aquamarine))
      .on(Image.circle(30).fillColor(Color.steelBlue))

  val animation =
    Reactor
      .linearRamp(-200, 200, 1)
      .tickRate(20.millis)
      .render{x =>
        val y = x.degrees.sin * 200
        val planet = Image.circle(20.0).noStroke.fillColor(Color.seaGreen)
        val moon = Image.circle(5.0).noStroke.fillColor(Color.slateGray).at((x * 10).degrees.cos * 50, (x * 10).degrees.sin * 50)

        moon.on(planet).at(x, y)
      }

  val frame = Frame.size(600, 600)


  def main(args: Array[String]): Unit = {
    image.draw()

    // Comment out the above and uncomment the below to display the animation
    // animation.run(frame)
  }
}
