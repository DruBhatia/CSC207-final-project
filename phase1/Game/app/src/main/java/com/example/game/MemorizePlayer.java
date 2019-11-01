package com.example.game;

import android.widget.Chronometer;
import android.widget.TextView;

/** A Player of Memorize Game */
class MemorizePlayer {
  /** Total moves available to the Player */
  private int playerMoves;
  /** Points earned by the Player */
  private int playerPoints;
  /** The Text on the screen which keeps track of the moves left */
  private TextView textMoves;
  /** The Text on the screen which keeps track of the points earned by the player */
  private TextView textPoints;
  /** The stop watch which keeps track of the time spent by the player to complete the game */
  private Chronometer chronometer;

  /**
   * Construct a new player of the Memorize! game, allots the number of moves they are allowed to
   * make, sets their timer, and initializes how many points they start off with.
   */
  MemorizePlayer(TextView tv1, TextView tv2, Chronometer meter) {
    playerMoves = 15;
    this.textMoves = tv1;
    this.chronometer = meter;
    this.playerPoints = 0;
    this.textPoints = tv2;
  }

  /**
   * Update the corresponding text box in the layout after a match is attempted to reflect how many
   * moves the player has left.
   */
  void setTextMoves() {
    String new_text = "Moves Left:" + this.getMovesLeft();
    this.textMoves.setText(new_text);
  }

  /**
   * Update the corresponding text box in the layout after a match is attempted to reflect how many
   * points the player has.
   */
  void setTextPoints() {
    String new_text = "Score: " + this.getPlayerPoints();
    this.textPoints.setText(new_text);
  }

  /** Returns this player's timer. */
  Chronometer getChronometer() {
    return chronometer;
  }

  /** Returns how many moves this player has left. */
  int getMovesLeft() {
    return playerMoves;
  }

  /** Returns this player's point tally. */
  int getPlayerPoints() {
    return playerPoints;
  }

  /** Increase this player's points. */
  void increasePlayerPoints() {
    this.playerPoints = this.playerPoints + 2;
  }

  /** If this player has any points, decrease them. */
  void decreasePlayerPoints() {
    if (this.playerPoints != 0) {
      this.playerPoints--;
    }
  }

  /** Decrease how many remaining moves this player has. */
  void decreasePlayerMoves() {
    this.playerMoves--;
  }
}
