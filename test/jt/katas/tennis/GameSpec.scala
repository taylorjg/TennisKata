package jt.katas.tennis

import org.scalatest.FunSpec

/**
 * Created by Jonathan Taylor on 05/01/2014.
 */
class GameSpec extends FunSpec {

  val player1 = new Player("Becker")
  val player2 = new Player("McEnroe")

  describe("A simple tennis game") {

    describe("initialisation scenarios") {

      it("should let me to configure the players") {
        val game = new Game(player1, player2)
        assertResult(player1)(game.player1)
        assertResult(player2)(game.player2)
      }

      it("should initially have a score of zero for both players") {
        val game = new Game(player1, player2)
        assertResult(0)(game.scoreFor(player1))
        assertResult(0)(game.scoreFor(player2))
      }

      it("should initially indicate that no player has won yet") {
        val game = new Game(player1, player2)
        assertResult(None)(game.winner)
      }

      it("should initially indicate that it is not deuce") {
        val game = new Game(player1, player2)
        assertResult(false)(game.deuce)
      }

      it("should initially indicate that no player has advantage yet") {
        val game = new Game(player1, player2)
        assertResult(None)(game.advantage)
      }
    }

    describe("scoring scenarios") {

      it("should let me indicate that a point has been scored") {
        val game = new Game(player1, player2)
        game.pointScored(player1)
        assertResult(1)(game.scoreFor(player1))
      }

      it("should let me indicate a series of points scored") {
        val game = new Game(player1, player2)
        game.pointsScored(
          player1,
          player2,
          player2,
          player1,
          player1)
        assertResult(3)(game.scoreFor(player1))
        assertResult(2)(game.scoreFor(player2))
      }

      it("should let me indicate a list of points scored") {
        val game = new Game(player1, player2)
        game.pointsScored(List(player1, player2, player1))
        assertResult(2)(game.scoreFor(player1))
        assertResult(1)(game.scoreFor(player2))
      }

      it("should indicate the correct winner for a love game") {
        val game = new Game(player1, player2)
        game.pointsScored(List.fill(4)(player1))
        assertResult(Some(player1))(game.winner)
      }

      it("should indicate that it is deuce at 40 all") {
        val game = new Game(player1, player2)
        game.pointsScored(List.fill(3)(player1) ::: List.fill(3)(player2))
        assertResult(true)(game.deuce)
      }

      it("should indicate advantage to player1 when it has been deuce and player1 scores another point") {
        val game = new Game(player1, player2)
        game.pointsScored(List.fill(3)(player1) ::: List.fill(3)(player2))
        assertResult(None)(game.advantage)
        game.pointScored(player1)
        assertResult(Some(player1))(game.advantage)
      }
    }

    describe("reset") {
      it("should reset the game") {
        val game = new Game(player1, player2)
        game.pointsScored(player1, player2, player2)
        assertResult(game.player1Score)(1)
        assertResult(game.player2Score)(2)
        game.reset()
        assertResult(game.player1Score)(0)
        assertResult(game.player2Score)(0)
      }
    }
  }
}
