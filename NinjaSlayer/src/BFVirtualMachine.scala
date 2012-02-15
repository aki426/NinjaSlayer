
/**
 * @author aki
 * Brainfuckの状態遷移マシン
 */
class BFVirtualMachine {
  val vmPointers = 0 :: Nil
  val vmMemory: Array[Integer] = new Array[Integer](1)

  def apply(code: NSCodes) = code match {
    case PointerIncrement => generate(1)
    case _                => this
  }

  def generate(ptSkip: Integer) = {
    val next = this.vmPointers.head + ptSkip
    if (next > 0) next :: this.vmPointers.tail
    else this.vmPointers

    this.vmMemory
  }

  /*  def apply(code: NSCodes): BFVirtualMachine = code match {
    case PointerIncrement => new BFVirtualMachine // ポインターを進める
    case PointerDecrement => new BFVirtualMachine //ポインターを戻す
    case ValueIncrement   => new BFVirtualMachine //ポインターの指している値をインクリメントする
    case ValueDecrement   => new BFVirtualMachine //ポインターの指している値をデクリメントする
    case ValuePut         => new BFVirtualMachine //値を標準出力に書き出す
    case ValueGet         => new BFVirtualMachine //値を標準入力から読み取る
    case LoopStart        => new BFVirtualMachine //ループを開始
    case LoopEnd          => new BFVirtualMachine //ループを終了

  }
*/ }

object BFVirtualMachine {

}