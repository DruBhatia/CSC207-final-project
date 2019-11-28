package com.example.final_game.TrueBlueAdventure;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.Random;

import com.example.final_game.R;

public class Powerup {
    /**
     *fX: fuel's x coordinate fY: fuel's y coordinate
     */
    private int pX, pY;
    /** The gameview fuel is displayed in **/
    private TrueBlueView gv;
    /** a Btmap of fuel **/
    private Bitmap powerupBM;
    /** the rect representation for fuel **/
    private Rect pRect;
    /** status if powerup has been collected **/
    private boolean collected;

    Powerup(TrueBlueView gv) {
        this.gv = gv;
        powerupBM = BitmapFactory.decodeResource(gv.getResources(), R.drawable.powerup);
        pX = 1400;
        pY = gv.getScreenHeight() / 2 - powerupBM.getHeight() / 2 + getRandomNumberInRange(-300, 300);;
        pRect = new Rect(pX, pY, pX + 70, pY + 70);
        collected = false;
    }

    void drawPowerup(Canvas canvas) {
        Rect tb = gv.tb.getTbRect();
        canvas.drawBitmap(powerupBM, null, pRect, null);
        if (getIntersectTb(pRect, tb)) {
            gv.increaseScore();
            collected = true;
        }
    }

    /** Returns a random integer x such that (min <= x <= max) **/
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /** move method for powerup. **/
    void move() {
        if (pX < (-400)) {
            pX = 1400;
            pY = gv.getScreenHeight() / 2 - powerupBM.getHeight() / 2 + getRandomNumberInRange(-300, 300);
            collected = false;
        }
        pX -= 10;
        pY += getRandomNumberInRange(-70,70);
        pRect = new Rect(pX, pY, pX + 70, pY + 70);
    }

    /** return true if TrueBlue intersects with the powerup and false otherwise **/
    public boolean getIntersectTb(Rect pRect, Rect tbRect) {
        return tbRect.intersect(pRect);
    }

    public boolean getCollected() {
        return collected;
    }
}
