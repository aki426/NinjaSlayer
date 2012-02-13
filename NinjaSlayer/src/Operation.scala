/**
 * @author aki
 * Brainfuckの命令セットを規定
 */
sealed abstract class Operation
case class PointerIncrement extends Operation // ポインターを進める
case class PointerDecrement extends Operation //ポインターを戻す
case class ValueIncrement extends Operation //ポインターの指している値をインクリメントする
case class ValueDecrement extends Operation //ポインターの指している値をデクリメントする
case class ValuePut extends Operation //値を標準出力に書き出す
case class ValueGet extends Operation //値を標準入力から読み取る
case class LoopStart extends Operation //ループを開始
case class LoopEnd extends Operation //ループを終了




