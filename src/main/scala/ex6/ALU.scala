package ex6

import chisel3._
import chisel3.util._

class ALU extends Module {
  // Define an ALU with two 8-bit inputs and an 8-bit output
  // The ALU should perform the operation specified by the op input
  var io = IO(new Bundle {
    val dataInA = Input(UInt(8.W))
    val dataInB = Input(UInt(8.W))
    val op = Input(UInt(2.W))
    val dataOut = Output(UInt(8.W))
  })

  io.dataOut := 0.U

  // Define the ALU operations
  // Use switch statements to determine the operation to perform
  // The ALU should perform the following operations:
  // 0: Addition
  // 1: Subtraction
  // 2: Bitwise AND
  // 3: Bitwise OR

  switch(io.op) {
    is(0.U) {
      io.dataOut := io.dataInA + io.dataInB
    }
    is(1.U) {
      io.dataOut := io.dataInA - io.dataInB
    }
    is(2.U) {
      io.dataOut := io.dataInA & io.dataInB
    }
    is(3.U) {
      io.dataOut := io.dataInA | io.dataInB
    }
  }
}
