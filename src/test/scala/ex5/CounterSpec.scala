package ex5

import chisel3._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers
import ex5.Counter

class CounterSpec extends AnyFreeSpec with Matchers {
  "Counter should increment by 1 each cycle" in {
    simulate(new Counter) { dut =>
      var count = 0
      dut.clock.step()
      for (i <- 1 to 100) {
        dut.io.dataOut.expect(count.U)
        dut.clock.step()
        count += 1
      }
    }
  }
}
