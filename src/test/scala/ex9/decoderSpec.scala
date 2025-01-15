package ex9

import chisel3._
import chisel3.experimental.BundleLiterals._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class decoderSpec extends AnyFreeSpec with Matchers {
  "Decoder should perform correct operations" in {
    simulate(new Decoder) { dut =>
      dut.io.dataIn.poke(0.U)
      dut.io.dataOut.expect("b0001".U)
      dut.io.dataIn.poke(1.U)
      dut.io.dataOut.expect("b0010".U)
      dut.io.dataIn.poke(2.U)
      dut.io.dataOut.expect("b0100".U)
      dut.io.dataIn.poke(3.U)
      dut.io.dataOut.expect("b1000".U)
    }
  }
}
