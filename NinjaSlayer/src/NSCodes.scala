/**
 * @author aki
 * 命令セットを規定
 */
object NSCodes extends Enumeration {
  type NSCodes = Value

  val AddressIncrement = Value // アドレスポインターを進める
  val AddressDecrement = Value // アドレスポインターを戻す
  val ValueIncrement = Value // アドレスポインターの指している値をインクリメントする
  val ValueDecrement = Value // アドレスポインターの指している値をデクリメントする
  val ValuePut = Value // 値を標準出力に書き出す
  val ValueGet = Value // 値を標準入力から読み取る
  val LoopStart = Value // ループを開始
  val LoopEnd = Value // ループを終了
}
