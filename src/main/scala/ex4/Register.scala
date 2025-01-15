package ex4

import chisel3._

class Register extends Module {
  // Define a register with an 8-bit input and output
  // The register should store the input value and output it on the next cycle
  val io = IO(new Bundle {
    val dataIn = Input(UInt(8.W))
    val dataOut = Output(UInt(8.W))
  })

  var register = RegInit(0.U)
  io.dataOut := register
  register := io.dataIn
}
