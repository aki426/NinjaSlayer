import scala.io.Source

/**
 * @author aki
 * ニンジャスレイヤー言語解釈・実行機械
 * コミットテスト。
 */
object NinjaSlayer {
  def main(args: Array[String]) {
    if (args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines().toList
    }
  }

  /**
   * 命令セットを規定
   */
  val OperationMap =
    Map(
      "イヤーッ！" -> PointerIncrement,
      "グワーッ！" -> PointerDecrement,
      "アイエエエ！" -> ValueIncrement,
      "ガンバルゾー！" -> ValueDecrement,
      "ワッショイ！" -> ValuePut,
      "サツバツ！" -> ValueGet,
      "ドーモ。" -> LoopStart,
      "サヨナラ！" -> LoopEnd)

}