package ex9

import chisel3._
import chisel3.util._

// Define a module that takes a 2-bit input and outputs a 4-bit value
class Decoder extends Module {
  val io = IO(new Bundle {
    val dataIn = Input(UInt(2.W))
    val dataOut = Output(UInt(4.W))
  })

  // Use switch and is to define the output
  io.dataOut := 0.U
  switch(io.dataIn) {
    is(0.U) {
      io.dataOut := "b0001".U
    }
    is(1.U) {
      io.dataOut := "b0010".U
    }
    is(2.U) {
      io.dataOut := "b0100".U
    }
    is(3.U) {
      io.dataOut := "b1000".U
    }
  }
}
