sealed abstract class Operation
case class PointerIncrement extends Operation
case class PointerDecrement extends Operation
case class ValueIncrement extends Operation
case class ValueDecrement extends Operation
case class ValuePut extends Operation
case class ValueGet extends Operation
case class LoopStart extends Operation
case class LoopEnd extends Operation

val OperationMap =
  Map(
    "イヤーッ！" -> PointerIncrement,
    "グワーッ！" -> PointerDecrement,
    "アイエエエ！" -> ValueIncrement,
    "ガンバルゾー！ガンバルゾー！" -> ValueDecrement,
    "ワッショイ！" -> ValuePut,
    "サツバツ！" -> ValueGet,
    "ドーモ。" -> LoopStart,
    "サヨナラ！" -> LoopEnd)

val vmMemory = new Array[Integer](64)
val vmPointerStack = 0 :: Nil
val operationSequence = new Array[Operation](1024)
