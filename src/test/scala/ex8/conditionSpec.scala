package ex8

import chisel3._
import chisel3.experimental.BundleLiterals._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class conditionSpec extends AnyFreeSpec with Matchers {
  "Condition should perform correct operations" - {
    "perform AND operation when control is true" in {
      simulate(new Condition) { dut =>
        dut.io.control.poke(true.B)
        dut.io.dataInA.poke(0xff.U)
        dut.io.dataInB.poke(0x0f.U)
        dut.io.dataOut.expect(0x0f.U)
      }
    }
    "perform OR operation when control is false" in {
      simulate(new Condition) { dut =>
        dut.io.control.poke(false.B)
        dut.io.dataInA.poke(0xff.U)
        dut.io.dataInB.poke(0x0f.U)
        dut.io.dataOut.expect(0xff.U)
      }
    }
  }
}
