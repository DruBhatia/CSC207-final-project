package com.example.game;


/**A Player of Memorize Game */
public class MemorizePlayer {
    /** Total points earned by the Player*/
    private int pointsEarned;

    public MemorizePlayer() {
        pointsEarned = 0;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void increasePointsEarned() {
        this.pointsEarned++;
    }

}
