import scala.util.parsing.combinator._

class NSParser extends RegexParsers {

  def satubatuLang: Parser[List[Option[Any]]] =
    rep("イヤーッ！" ^^ (_ => Some(PointerIncrement))
      | "グワーッ！" ^^ (_ => Some(PointerDecrement))
      | "アイエエエ！" ^^ (_ => Some(ValueIncrement))
      | "ガンバルゾー！" ^^ (_ => Some(ValueDecrement))
      | "ワッショイ！" ^^ (_ => Some(ValueGet))
      | "サツバツ！" ^^ (_ => Some(ValuePut))
      | "ドーモ。" ^^ (_ => Some(LoopStart))
      | "サヨナラ！" ^^ (_ => Some(LoopEnd))
      | """.""".r ^^ (_ => None))

}