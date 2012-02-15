
/**
 * @author aki
 * Brainfuckの状態遷移マシン
 */
class BFVirtualMachine {
  val vmMemory = new Array[Integer](64)
  val vmPointerStack = 0 :: Nil
  val operationSequence = new Array[NSCodes](1024)

  def apply(code: NSCodes): BFVirtualMachine = code match {
    case PointerIncrement => new BFVirtualMachine // ポインターを進める
    case PointerDecrement => new BFVirtualMachine //ポインターを戻す
    case ValueIncrement   => new BFVirtualMachine //ポインターの指している値をインクリメントする
    case ValueDecrement   => new BFVirtualMachine //ポインターの指している値をデクリメントする
    case ValuePut         => new BFVirtualMachine //値を標準出力に書き出す
    case ValueGet         => new BFVirtualMachine //値を標準入力から読み取る
    case LoopStart        => new BFVirtualMachine //ループを開始
    case LoopEnd          => new BFVirtualMachine //ループを終了

  }
}