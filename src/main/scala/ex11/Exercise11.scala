package ex11

import chisel3._

class PipelineStage extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(8.W))
    val out = Output(UInt(8.W))
  })

  val reg = RegNext(io.in)
  io.out := reg
}

class Pipeline extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(8.W))  // Define an 8-bit input port for the pipeline
    val out = Output(UInt(8.W)) // Define an 8-bit output port for the pipeline
  })

  val stage1 = Module(new PipelineStage) // Instantiate the first pipeline stage
  val stage2 = Module(new PipelineStage) // Instantiate the second pipeline stage
  val stage3 = Module(new PipelineStage) // Instantiate the third pipeline stage

  stage1.io.in := io.in // Connect the pipeline input to the first stage's input
  stage2.io.in := stage1.io.out // Connect the first stage's output to the second stage's input
  stage3.io.in := stage2.io.out // Connect the second stage's output to the third stage's input
  io.out := stage3.io.out // Connect the third stage's output to the pipeline output
}