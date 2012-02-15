import scala.util.parsing.combinator._

class NSParser extends RegexParsers {

  def satubatuLang: Parser[List[Any]] =
    rep("イヤーッ！"
      | "グワーッ！"
      | "アイエエエ！"
      | "ガンバルゾー！"
      | "ワッショイ！"
      | "サツバツ！"
      | "ドーモ。"
      | "サヨナラ！"
      | """.""".r)

}