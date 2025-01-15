package ex8

import chisel3._

class Condition extends Module {
  val io = IO(new Bundle {
    val dataInA = Input(UInt(8.W))
    val dataInB = Input(UInt(8.W))
    val control = Input(Bool())
    val dataOut = Output(UInt(8.W))
  })

  // Use when and otherwise to define the output
  when(io.control) {
    // When control is true, output is the AND of dataInA and dataInB
    io.dataOut := io.dataInA & io.dataInB
  }.otherwise {
    // Otherwise, output is the OR of dataInA and dataInB
    io.dataOut := io.dataInA | io.dataInB
  }
}
