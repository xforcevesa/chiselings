package ex2

import chisel3._

class BundleProcessor extends Module {
  // Use a Bundle to define the input and output ports of the module
  // The input ports are dataInA and dataInB, and the output port is dataOut
  val io = IO(new Bundle {
    val dataInA = Input(UInt(16.W))
    val dataInB = Input(UInt(16.W))
    val dataOut = Output(UInt(16.W))
  })

  // Perform a bitwise XOR operation on the input dataInA and dataInB and assign the result to dataOut
  io.dataOut := io.dataInA ^ io.dataInB
}
