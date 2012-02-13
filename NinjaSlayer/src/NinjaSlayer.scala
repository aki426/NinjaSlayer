import scala.io.Source
object NinjaSlayer {
  def main(args: Array[String]) {
    if (args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines().toList
    }
  }
}