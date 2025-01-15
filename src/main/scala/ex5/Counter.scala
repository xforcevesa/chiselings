package ex5

import chisel3._
import ex1.Adder
import ex4.Register

// Define a counter that increments by 1 each cycle
// The counter should output an 8-bit value
// The counter should use an Adder and a Register
class Counter extends Module {
  var io = IO(new Bundle {
    val dataOut = Output(UInt(8.W))
  })

  val adder = Module(new Adder)
  val register = Module(new Register)

  var count = register.io.dataOut

  adder.io.a := count
  adder.io.b := 1.U

  register.io.dataIn := adder.io.c

  io.dataOut := count
}
