import scala.io.Source
/**
 * @author aki
 * ニンジャスレイヤー言語解釈・実行機械
 */
object NinjaSlayer extends NSParser {
  def main(args: Array[String]): Unit = {
    assert(args.nonEmpty)
    assert(args(0).endsWith(".ns") | args(0).endsWith(".njslyr") | args(0).endsWith(".b"))

    val codes = Source.fromFile(args(0)).getLines().toList.toString()
    //println(codes)
    val li =
      if (args(0).endsWith(".b"))
        parseAll(bfLangParser, codes).get.filter(_ != None).map(_.get)
      else
        parseAll(satubatuParser, codes).get.filter(_ != None).map(_.get)

    //li.foreach(print)
    //println(li.toArray)

    val ninja = new BFVirtualMachine(li.toArray)
    ninja.apply()

  }

  /*  def runNinja(codes: List[NSCodes], vm: BFVirtualMachine): BFVirtualMachine = codes match {
    case Nil     => vm
    case x :: xs => runNinja(xs, vm.apply(x))
  }
*/ }