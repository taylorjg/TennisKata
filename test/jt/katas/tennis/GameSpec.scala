package jt.katas.tennis

import org.scalatest.FunSpec

/**
 * Created by Jonathan Taylor on 05/01/2014.
 */
class GameSpec extends FunSpec {

  describe("A simple tennis game") {

    it("should let me to configure the players") {
      val player1 = new Player("Becker")
      val player2 = new Player("McEnroe")
      val game = new Game(player1, player2)
      assertResult(player1)(game.player1)
      assertResult(player2)(game.player2)
    }

    it("should initially have a score of zero for both players") {
      val player1 = new Player("Becker")
      val player2 = new Player("McEnroe")
      val game = new Game(player1, player2)
      assertResult(0)(game.scoreFor(player1))
      assertResult(0)(game.scoreFor(player2))
    }

    it("should let me indicate which player won the next point") {
      val player1 = new Player("Becker")
      val player2 = new Player("McEnroe")
      val game = new Game(player1, player2)
      game.pointScoredBy(player1)
      assertResult(1)(game.scoreFor(player1))
    }
  }
}
