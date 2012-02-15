
/**
 * @author aki
 * Brainfuckの状態遷移マシン
 */
object BFVirtualMachine {
  val vmMemory = new Array[Integer](64)
  val vmPointerStack = 0 :: Nil
  val operationSequence = new Array[NSCodes](1024)
}