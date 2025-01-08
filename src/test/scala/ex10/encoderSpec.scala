package ex10

import chisel3._

import chisel3.experimental.BundleLiterals._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class encoderSpec extends AnyFreeSpec with Matchers {
  "Encoder should perform correct operations" in {
    simulate(new Encoder) { dut =>
      dut.io.dataIn.poke("b0001".U)
      dut.io.dataOut.expect(0.U)
      dut.io.dataIn.poke("b0010".U)
      dut.io.dataOut.expect(1.U)
      dut.io.dataIn.poke("b0100".U)
      dut.io.dataOut.expect(2.U)
      dut.io.dataIn.poke("b1000".U)
      dut.io.dataOut.expect(3.U)
    }
  }
}
