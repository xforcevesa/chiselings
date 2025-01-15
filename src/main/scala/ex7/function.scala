package ex7

import chisel3._

class Adder extends Module {
  val io = IO(new Bundle {
    val dataInA = Input(UInt(8.W))
    val dataInB = Input(UInt(8.W))
    val dataOut = Output(UInt(8.W))
  })

  // Define a function that adds two UInts
  def adder(a: UInt, b: UInt): UInt = {
    a + b
  }

  // Add the two input values a and b to c
  io.dataOut := adder(io.dataInA, io.dataInB)
}
