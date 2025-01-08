package ex4

import chisel3._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers
import ex4.Register

class RegisterSpec extends AnyFreeSpec with Matchers {
  "Register should pass input data to output correctly" in {
    simulate(new Register) { dut =>
      for (i <- 1 to 100) {
        val testData = scala.util.Random.nextInt(256)
        dut.io.dataIn.poke(testData.U)
        dut.clock.step()
        dut.io.dataOut.expect(testData.U)
      }
    }
  }
}
