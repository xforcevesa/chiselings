package ex3

import chisel3._

class VectorProcessor extends Module {
  // Use a vector to define the input and output ports of the module
  // The input ports are dataInA and dataInB, and the output port is dataOut
  // Each input and output port is a vector of 16 bits
  val io = IO(new Bundle {
    val dataInA = Input(Vec(16, UInt(1.W)))
    val dataInB = Input(Vec(16, UInt(1.W)))
    val dataOut = Output(Vec(16, UInt(1.W)))
  })

  // Mux the input dataInA and dataInB and assign the result to dataOut
  // If the value of dataInA is 1, assign the value of dataInB to dataOut
  // Otherwise, assign 0 to dataOut
  for (i <- 0 until 16) {
    io.dataOut(i) := Mux(io.dataInA(i) === 1.U, io.dataInB(i), 0.U)
  }
}
