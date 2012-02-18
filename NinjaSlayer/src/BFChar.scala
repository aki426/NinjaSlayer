import scala.Math._
/**
 * brainfuck用charエミュレーションメモリ
 */

class BFChar(i: Int) {
  def this() = {
    this(0)
  }
  val n: Int =
    if (i > 127) i % 128
    else if (i < 0) 128 - (abs(i)) % 128
    else i

  def add(i: Int): BFChar = {
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