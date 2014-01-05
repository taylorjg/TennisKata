package jt.katas.tennis

/**
 * Created by Jonathan Taylor on 05/01/2014.
 */
object ScoreFormatter {

  def score(game: Game) = {
    game match {
      case _ if game.winner.isDefined => "winner: " + game.winner.get.name
      case _ if game.advantage.isDefined => "advantage: " + game.advantage.get.name
      case _ if game.deuce => "deuce"
      case _ => formatSimpleScores(game)
    }
  }

  private def formatSimpleScores(game: Game) = {
    "%s/%s".format(
      formatSimpleScore(game.player1Score),
      formatSimpleScore(game.player2Score))
  }
  
  private def formatSimpleScore(score: Int) = {
    score match {
      case 0 => "0"
      case 1 => "15"
      case 2 => "30"
      case 3 => "40"
      case _ => "???"
    }
  }
}
