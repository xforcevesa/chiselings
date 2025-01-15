package ex3

import chisel3._
import chisel3.experimental.BundleLiterals._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers
import ex3.VectorProcessor

class VectorProcessorSpec extends AnyFreeSpec with Matchers {

  "VectorProcessor should process vectors correctly" in {
    simulate(new VectorProcessor) { dut =>
      for (i <- 1 to 100) {
        val dataInA =
          (0 until 16).map(_ => scala.util.Random.nextInt(2))
        val dataInB =
          (0 until 16).map(_ => scala.util.Random.nextInt(2))

        for (i <- 0 until 16) {
          dut.io.dataInA(i).poke(dataInA(i).U)
          dut.io.dataInB(i).poke(dataInB(i).U)
        }

        dut.clock.step()

        for (i <- 0 until 16) {
          val expectedOut = if (dataInA(i) == 1) dataInB(i) else 0
          dut.io.dataOut(i).expect(expectedOut.U)
        }
      }
    }
  }
}
