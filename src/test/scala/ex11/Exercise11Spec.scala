package ex11

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import org.scalatest.matchers.should.Matchers

class PipelineSpec extends FreeSpec with ChiselScalatestTester with Matchers {
  "Pipeline should propagate values through stages" in {
    test(new Pipeline) { dut =>
      for (i <- 0 until 256) {
        dut.io.in.poke(i.U)
        dut.clock.step(1)
        if (i >= 3) {
          dut.io.out.expect((i - 3).U)
        }
      }
    }
  }
}