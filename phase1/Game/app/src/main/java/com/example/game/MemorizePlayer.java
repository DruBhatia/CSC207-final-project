package com.example.game;

import android.widget.Chronometer;
import android.widget.TextView;

/** A Player of Memorize Game */
public class MemorizePlayer {
  /** Total moves available to the Player */
  private int playerMoves;
  /** The Text on the screen which keeps track of the points earned by the player */
  private TextView textView;
  /** The stop watch which keeps track of the time spent by the player to complete the game */
  private Chronometer chronometer;

  public MemorizePlayer(TextView tv, Chronometer meter) {
    playerMoves = 15;
    this.textView = tv;
    this.chronometer = meter;
  }

  void setTextMoves() {
    String new_text = "Moves Left:" + this.getMovesLeft();
    this.textView.setText(new_text);
  }

  Chronometer getChronometer() {
    return chronometer;
  }

  int getMovesLeft() {
    return playerMoves;
  }

  void decreasePlayerMoves() {
    this.playerMoves--;
  }
}
