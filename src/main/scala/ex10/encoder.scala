package ex10

import chisel3._
import chisel3.util._

// Define a module that takes a 4-bit input and outputs a 2-bit value
class Encoder extends Module {
  val io = IO(new Bundle {
    val dataIn = Input(UInt(4.W))
    val dataOut = Output(UInt(2.W))
  })

  // Use switch and is to define the output
  io.dataOut := 0.U
  switch(io.dataIn) {
    is("b0001".U) {
      io.dataOut := 0.U
    }
    is("b0010".U) {
      io.dataOut := 1.U
    }
    is("b0100".U) {
      io.dataOut := 2.U
    }
    is("b1000".U) {
      io.dataOut := 3.U
    }
  }
}
