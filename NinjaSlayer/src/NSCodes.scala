/**
 * @author aki
 * 命令セットを規定
 */
sealed abstract class NSCodes
case class PointerIncrement extends NSCodes // ポインターを進める
case class PointerDecrement extends NSCodes //ポインターを戻す
case class ValueIncrement extends NSCodes //ポインターの指している値をインクリメントする
case class ValueDecrement extends NSCodes //ポインターの指している値をデクリメントする
case class ValuePut extends NSCodes //値を標準出力に書き出す
case class ValueGet extends NSCodes //値を標準入力から読み取る
case class LoopStart extends NSCodes //ループを開始
case class LoopEnd extends NSCodes //ループを終了

case class NOPCode extends NSCodes //nop



