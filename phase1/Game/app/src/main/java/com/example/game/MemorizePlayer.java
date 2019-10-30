package com.example.game;

import android.widget.TextView;

/**A Player of Memorize Game */
public class MemorizePlayer {
    /** Total moves available to the Player*/
    private int playerMoves;
    /** The Text on the screen which keeps track if the points earned by the player*/
    private TextView textView;

    public MemorizePlayer(TextView tv) {
        playerMoves = 15;
        this.textView = tv;
    }

    void setTextMoves() {
        String new_text =  "Moves Left:" + this.getMovesLeft();
        this.textView.setText(new_text);
    }

    int getMovesLeft() {
        return playerMoves;
    }

    void decreasePlayerMoves() {
        this.playerMoves--;
    }

}
