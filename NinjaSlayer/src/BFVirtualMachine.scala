/**
 * @author aki
 * Brainfuckの状態遷移マシン
 * @param codes 命令コード列
 * @param pointers 命令コードの現在位置
 * @param memPtr 現在指しているメモリ
 * @param memory メモリ
 */
class BFVirtualMachine(
    codes: Array[NSCodes.Value],
    pointers: List[Int],
    address: Int,
    memory: Array[BFChar]) {

  require(codes.nonEmpty)
  val vmCodes = codes
  val vmPointers = pointers

  require(address >= 0)
  val vmAddress = address
  val vmMemory = memory

  def this(codes: Array[NSCodes.Value]) =
    this(codes, 0 :: Nil, 0, Array(new BFChar(0)))

  /**
   * @param that
   * @return コード列実行後の状態を返す
   */
  def apply(): BFVirtualMachine = {
    // コードを最後まで実行したら自分を帰して終了
    if (vmPointers.head >= vmCodes.length) this
    else vmCodes(vmPointers.head) match {
      // アドレス位置をインクリメント
      case NSCodes.AddressIncrement =>
        getNextAddressVM(this.address + 1).apply()
      // アドレス位置をデクリメント
      case NSCodes.AddressDecrement =>
        getNextAddressVM(this.address - 1).apply()
      // アドレスの指すメモリをインクリメント
      case NSCodes.ValueIncrement =>
        changeMemory(PlusOrMinus.Increment).apply()
      // アドレスの指すメモリをデクリメント
      case NSCodes.ValueDecrement =>
        changeMemory(PlusOrMinus.Decrement).apply()
      // メモリから値を読み取って標準出力に表示する
      case NSCodes.ValuePut =>
        require(this.vmAddress >= 0 && this.vmAddress < this.vmMemory.length)
        print(this.vmMemory(this.vmAddress))
        getNextAddressVM().apply()
      // 標準入力から一文字読み取ってメモリに保存する
      case NSCodes.ValueGet =>
        val temp = Console.readChar().toInt
        updateInputMemory(temp).apply()
      // 
      case NSCodes.LoopStart =>
        var nest = 0
        var temp_p = vmPointers.head + 1
        if (vmMemory(address).n == 0) {
          while (temp_p < vmCodes.length && !(nest == 0 && vmCodes(temp_p) == NSCodes.LoopEnd)) {
            temp_p = temp_p + 1
            if (vmCodes(temp_p) == NSCodes.LoopStart) {
              nest = nest + 1
            }
            else if (vmCodes(temp_p) == NSCodes.LoopEnd) {
              nest = nest - 1
            }
          }
          (new BFVirtualMachine(vmCodes, (temp_p + 1) :: vmPointers, vmAddress, vmMemory)).apply()
        }
        else
          (new BFVirtualMachine(vmCodes, (vmPointers.head + 1) :: vmPointers, vmAddress, vmMemory)).apply()
      //getNextAddressVM().apply()
      // 
      case NSCodes.LoopEnd =>
        if (vmMemory(address).n != 0)
          (new BFVirtualMachine(vmCodes, vmPointers.tail, vmAddress, vmMemory)).apply()
        else
          getNextAddressVM().apply()
      // 
      case _ => getNextAddressVM().apply()
    }
  }

  /**
   * 次の命令実行直前のVMの状態を返す関数
   * @param ad 次のメモリアドレスポインターの位置
   * @return
   */
  def getNextAddressVM(ad: Int): BFVirtualMachine = {
    new BFVirtualMachine(
      this.vmCodes,
      this.vmPointers.head + 1 :: this.vmPointers.tail,
      ad,
      this.vmMemory)
  }

  def getNextAddressVM(): BFVirtualMachine = {
    new BFVirtualMachine(
      this.vmCodes,
      this.vmPointers.head + 1 :: this.vmPointers.tail,
      this.vmAddress,
      this.vmMemory)
  }

  def getNextValueVM(mem: Array[BFChar]): BFVirtualMachine = {
    new BFVirtualMachine(
      this.vmCodes,
      this.vmPointers.head + 1 :: this.vmPointers.tail,
      this.vmAddress,
      mem)
  }

  object PlusOrMinus extends Enumeration {
    val Increment = Value
    val Decrement = Value
  }

  def changeMemory(s: PlusOrMinus.Value): BFVirtualMachine = {
    var tArray =
      if (vmAddress >= vmMemory.length)
        Array.make(vmAddress + 1, new BFChar(0))
      else vmMemory.clone()
    if (vmAddress >= vmMemory.length)
      Array.copy(vmMemory, 0, tArray, 0, vmMemory.length)

    s match {
      case PlusOrMinus.Increment => tArray.update(vmAddress, tArray(vmAddress).increment())
      case PlusOrMinus.Decrement => tArray.update(vmAddress, tArray(vmAddress).decrement())
    }

    getNextValueVM(tArray.clone())
  }

  def updateInputMemory(v: Int): BFVirtualMachine = {
    var tArray =
      if (vmAddress >= vmMemory.length)
        Array.make(vmAddress + 1, new BFChar(0))
      else vmMemory.clone()
    if (vmAddress >= vmMemory.length)
      Array.copy(vmMemory, 0, tArray, 0, vmMemory.length)

    tArray.update(vmAddress, new BFChar(v))

    getNextValueVM(tArray.clone())
  }

  def generate(ptSkip: Int) = {
    val next = this.vmPointers.head + ptSkip
    if (next > 0) next :: this.vmPointers.tail
    else this.vmPointers

    this.vmMemory
  }
}
