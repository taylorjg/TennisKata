package jt.katas.tennis

/**
 * Created by Jonathan Taylor on 05/01/2014.
 */
class Game(val player1: Player, val player2: Player) {

  private val scores = scala.collection.mutable.ListMap(player1 -> 0, player2 -> 0)

  def pointScoredBy(player: Player) = {
    val oldScore = scores(player)
    val newScore = oldScore + 1
    scores(player) = newScore
  }

  def scoreFor(player: Player) = {
    scores(player)
  }
}
