package ex1

import chisel3._

class Adder extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val c = Output(UInt(9.W))
  })

  // Add the two input values a and b to c
  io.c := io.a + io.b
}
