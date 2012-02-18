import scala.util.parsing.combinator._

class NSParser extends RegexParsers {

  def satubatuParser: Parser[List[Option[NSCodes.Value]]] =
    rep("イヤーッ！" ^^ (_ => Some(NSCodes.AddressIncrement))
      | "グワーッ！" ^^ (_ => Some(NSCodes.AddressDecrement))
      | "アイエエエ！" ^^ (_ => Some(NSCodes.ValueIncrement))
      | "ガンバルゾー！" ^^ (_ => Some(NSCodes.ValueDecrement))
      | "ワッショイ！" ^^ (_ => Some(NSCodes.ValueGet))
      | "サツバツ！" ^^ (_ => Some(NSCodes.ValuePut))
      | "ドーモ。" ^^ (_ => Some(NSCodes.LoopStart))
      | "サヨナラ！" ^^ (_ => Some(NSCodes.LoopEnd))

      | ".".r ^^ (_ => None))

  def bfLangParser: Parser[List[Option[NSCodes.Value]]] =
    rep(">" ^^ (_ => Some(NSCodes.AddressIncrement))
      | "<" ^^ (_ => Some(NSCodes.AddressDecrement))
      | '+' ^^ (_ => Some(NSCodes.ValueIncrement))
      | "-" ^^ (_ => Some(NSCodes.ValueDecrement))
      | "," ^^ (_ => Some(NSCodes.ValueGet))
      | '.' ^^ (_ => Some(NSCodes.ValuePut))
      | "[" ^^ (_ => Some(NSCodes.LoopStart))
      | "]" ^^ (_ => Some(NSCodes.LoopEnd)))
  //     | whiteSpace ^^ (_ => None))

}