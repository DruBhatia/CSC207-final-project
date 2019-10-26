package com.example.game;


import android.widget.TextView;

/**A Player of Memorize Game */
public class MemorizePlayer {
    /** Total points earned by the Player*/
    private int pointsEarned;
    /** The Text on the screen which keeps track if the points earned by the player*/
    private TextView textView;

    public MemorizePlayer(TextView tv) {
        pointsEarned = 0;
        this.textView = tv;
    }

    public void setTextView(TextView new_tv) {
        this.textView = new_tv;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void increasePointsEarned() {
        this.pointsEarned++;
    }

}
