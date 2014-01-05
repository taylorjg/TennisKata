package jt.katas.tennis

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
 * Created by Jonathan Taylor on 05/01/2014.
 */
class ScoreFormatterSpec extends FunSpec {

  describe("Tennis score") {

    it("should initially return '0/0'") {
      val player1 = new Player("Becker")
      val player2 = new Player("McEnroe")
      val game = new Game(player1, player2)
      val actual = ScoreFormatter.score(game)
      assertResult("0/0")(actual)
    }

    it("should return 'winner: Becker' after a love game to player1") {
      val player1 = new Player("Becker")
      val player2 = new Player("McEnroe")
      val game = new Game(player1, player2)
      game.pointsScored(List.fill(4)(player1))
      val actual = ScoreFormatter.score(game)
      assertResult("winner: Becker")(actual)
    }

    it("should return 'deuce' at deuce") {
      val player1 = new Player("Becker")
      val player2 = new Player("McEnroe")
      val game = new Game(player1, player2)
      game.pointsScored(List.fill(3)(player2))
      game.pointsScored(List.fill(3)(player1))
      val actual = ScoreFormatter.score(game)
      assertResult("deuce")(actual)
    }

    it("should return 'advantage: McEnroe' after player2 scores a point after deuce") {
      val player1 = new Player("Becker")
      val player2 = new Player("McEnroe")
      val game = new Game(player1, player2)
      game.pointsScored(List.fill(3)(player2))
      game.pointsScored(List.fill(3)(player1))
      game.pointScored(player2)
      val actual = ScoreFormatter.score(game)
      assertResult("advantage: McEnroe")(actual)
    }

    it("should return '15/0' after player1 has scored a point") {
      val player1 = new Player("Becker")
      val player2 = new Player("McEnroe")
      val game = new Game(player1, player2)
      game.pointScored(player1)
      val actual = ScoreFormatter.score(game)
      assertResult("15/0")(actual)
    }

    it("should return '30/40' after player1 has scored 2 points and player2 has scored 3 points") {
      val player1 = new Player("Becker")
      val player2 = new Player("McEnroe")
      val game = new Game(player1, player2)
      game.pointScored(player1)
      game.pointScored(player1)
      game.pointScored(player2)
      game.pointScored(player2)
      game.pointScored(player2)
      val actual = ScoreFormatter.score(game)
      assertResult("30/40")(actual)
    }
  }
}
