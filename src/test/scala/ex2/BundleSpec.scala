package ex2

import chisel3._
import chisel3.experimental.BundleLiterals._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers
import ex2.BundleProcessor

class BundleProcessSpec extends AnyFreeSpec with Matchers {

  "BundleProcessor should perform XOR operation correctly" in {
    simulate(new BundleProcessor) { dut =>
      for (i <- 1 to 100) {
        val dataInA = scala.util.Random.nextInt(100)
        val dataInB = scala.util.Random.nextInt(100)
        dut.io.dataInA.poke(dataInA.U)
        dut.io.dataInB.poke(dataInB.U)
        dut.clock.step()
        dut.io.dataOut.expect((dataInA ^ dataInB).U)
      }
    }
  }
}
