package ex6

import chisel3._
import chisel3.experimental.BundleLiterals._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class ALUSpec extends AnyFreeSpec with Matchers {

  "ALU should perform correct operations" - {

    // Test for Addition (op = 0)
    "should perform Addition" in {
      simulate(new ALU) { dut =>
        for (i <- 0 until 10) {
          val dataInA = scala.util.Random.nextInt(128) // 8-bit values
          val dataInB = scala.util.Random.nextInt(128)
          dut.io.dataInA.poke(dataInA.U)
          dut.io.dataInB.poke(dataInB.U)
          dut.io.op.poke(0.U) // op = 0 (Addition)
          dut.clock.step()
          dut.io.dataOut.expect(dataInA + dataInB) // Ensure 8-bit wrap around
        }
      }
    }

    // Test for Subtraction (op = 1)
    "should perform Subtraction" in {
      simulate(new ALU) { dut =>
        for (i <- 0 until 10) {
          val dataInA = scala.util.Random.nextInt(128)
          val dataInB = scala.util.Random.nextInt(128)
          dut.io.dataInA.poke(dataInA.U)
          dut.io.dataInB.poke(dataInB.U)
          dut.io.op.poke(1.U) // op = 1 (Subtraction)
          dut.clock.step()
          dut.io.dataOut.expect(
            ((dataInA - dataInB + 256) % 256).U
          ) // Ensure 8-bit wrap around
        }
      }
    }

    // Test for Bitwise AND (op = 2)
    "should perform Bitwise AND" in {
      simulate(new ALU) { dut =>
        for (i <- 0 until 10) {
          val dataInA = scala.util.Random.nextInt(256)
          val dataInB = scala.util.Random.nextInt(256)
          dut.io.dataInA.poke(dataInA.U)
          dut.io.dataInB.poke(dataInB.U)
          dut.io.op.poke(2.U) // op = 2 (Bitwise AND)
          dut.clock.step()
          dut.io.dataOut.expect((dataInA & dataInB).U)
        }
      }
    }

    // Test for Bitwise OR (op = 3)
    "should perform Bitwise OR" in {
      simulate(new ALU) { dut =>
        for (i <- 0 until 10) {
          val dataInA = scala.util.Random.nextInt(256)
          val dataInB = scala.util.Random.nextInt(256)
          dut.io.dataInA.poke(dataInA.U)
          dut.io.dataInB.poke(dataInB.U)
          dut.io.op.poke(3.U) // op = 3 (Bitwise OR)
          dut.clock.step()
          dut.io.dataOut.expect((dataInA | dataInB).U)
        }
      }
    }
  }
}
