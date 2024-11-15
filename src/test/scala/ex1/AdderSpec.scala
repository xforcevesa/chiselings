package ex1

import chisel3._
import chisel3.experimental.BundleLiterals._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers
import ex1.Adder

class AdderSpec extends AnyFreeSpec with Matchers {

  "Adder should add two numbers correctly" in {
    simulate(new Adder) { dut =>
      for (i <- 1 to 100) {
        val a = scala.util.Random.nextInt(100)
        val b = scala.util.Random.nextInt(100)
        dut.io.a.poke(a.U)
        dut.io.b.poke(b.U)
        dut.clock.step()
        dut.io.c.expect((a + b).U)
      }
    }
  }
}