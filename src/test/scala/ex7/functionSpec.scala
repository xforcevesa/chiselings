package ex7

import chisel3._
import chisel3.experimental.BundleLiterals._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers
import ex7.Adder

class functionSpec extends AnyFreeSpec with Matchers {

  "Adder should add two numbers correctly" in {
    simulate(new Adder) { dut =>
      for (i <- 1 to 100) {
        val a = scala.util.Random.nextInt(100)
        val b = scala.util.Random.nextInt(100)
        dut.io.dataInA.poke(a.U)
        dut.io.dataInB.poke(b.U)
        dut.clock.step()
        dut.io.dataOut.expect((a + b).U)
      }
    }
  }
}
