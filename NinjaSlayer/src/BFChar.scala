import scala.Math._
/**
 * brainfuck用charエミュレーションメモリ
 */

class BFChar(i: Integer) {
  def this() = {
    this(0)
  }
  val n: Integer =
    if (i > 127) i % 128
    else if (i < 0) 128 - (abs(i)) % 128
    else i

  def add(i: Integer): BFChar = {
    new BFChar(this.n + i)
  }

  def increment(): BFChar = {
    new BFChar(this.n + 1)
  }

  def decrement(): BFChar = {
    new BFChar(this.n - 1)
  }

  def toChar(): Char = this.n.toChar
  override def toString(): String = this.n.toChar.toString()
}