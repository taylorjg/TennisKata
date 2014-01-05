package jt.katas.tennis

/**
 * Created by Jonathan Taylor on 05/01/2014.
 */
class Game(val player1: Player, val player2: Player) {

  private val scores = scala.collection.mutable.Map(player1 -> 0, player2 -> 0)

  def player1Score = scores(player1)
  def player2Score = scores(player2)

  def pointScored(player: Player) = {
    scores(player) = scores(player) + 1
  }

  def pointsScored(players: Player*): Unit = {
    pointsScored(players.toList)
  }

  def pointsScored(players: List[Player]): Unit = {
    players foreach pointScored
  }

  def scoreFor(player: Player) = {
    scores(player)
  }

  def winner = {
    (player1Score, player2Score) match {
      case (s1, s2) if s1 >= 4 && s1 - s2 >= 2 => Some(player1)
      case (s1, s2) if s2 >= 4 && s2 - s1 >= 2 => Some(player2)
      case _ => None
    }
  }

  def deuce = {
    (player1Score, player2Score) match {
      case (s1, s2) if s1 >= 3 && s2 >= 3 && s1 == s2 => true
      case _ => false
    }
  }

  def advantage = {
    (player1Score, player2Score) match {
      case (s1, s2) if s1 >= 3 && s2 >= 3 && s1 == s2 + 1 => Some(player1)
      case (s1, s2) if s1 >= 3 && s2 >= 3 && s2 == s1 + 1 => Some(player2)
      case _ => None
    }
  }
}
