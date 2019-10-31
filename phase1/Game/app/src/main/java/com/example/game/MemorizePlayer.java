package com.example.game;

import android.widget.Chronometer;
import android.widget.TextView;

/** A Player of Memorize Game */
public class MemorizePlayer {
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

  public MemorizePlayer(TextView tv1, TextView tv2,  Chronometer meter) {
    playerMoves = 15;
    this.textMoves = tv1;
    this.chronometer = meter;
    this.playerPoints = 0;
    this.textPoints = tv2;
  }

  void setTextMoves() {
    String new_text = "Moves Left:" + this.getMovesLeft();
    this.textMoves.setText(new_text);
  }

  void setTextPoints() {
    String new_text = "Score: " + this.getPlayerPoints();
    this.textPoints.setText(new_text);
  }

  Chronometer getChronometer() {
    return chronometer;
  }

  int getMovesLeft() {
    return playerMoves;
  }

  int getPlayerPoints() {
    return playerPoints;
  }

  void increasePlayerPoints() {
    this.playerPoints = this.playerPoints + 2;
  }

  void decreasePlayerPoints() {
    if (this.playerPoints != 0) {
      this.playerPoints--;
    }
  }

  void decreasePlayerMoves() {
    this.playerMoves--;
  }
}
