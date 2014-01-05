package jt.katas.tennis

import org.scalatest.FunSpec

/**
 * Created by Jonathan Taylor on 05/01/2014.
 */
class PlayerSpec extends FunSpec {

  describe("A player") {

    it("should have a name") {
      val player = new Player("Becker")
      assertResult("Becker")(player.name)
    }

    it("should use the player name as the string representation") {
      val player = new Player("Becker")
      assertResult("Becker")(player.toString)
    }
  }
}
