package com.example.final_game.TrueBlueAdventure;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.example.final_game.R;

import java.util.Random;

public abstract class Pickup {
    /**
     *pX: pickups's x coordinate pY: pickups's y coordinate
     */
    private int pX, pY;
    /** The gameview pickup is displayed in **/
    private TrueBlueView gv;
    /** a Btmap of pickup **/
    private Bitmap pickupBM;
    /** the rect representation for fuel **/
    private Rect pRect;
    /** status if pickup has been collected **/
    private boolean collected;

    Pickup(TrueBlueView gv, int pickupBM) {
        this.gv = gv;
        this.pickupBM = BitmapFactory.decodeResource(gv.getResources(), pickupBM);
        pX = 1400;
        pY = gv.getScreenHeight() / 2 - this.pickupBM.getHeight() / 2 + getRandomNumberInRange(-300, 300);;
        pRect = new Rect(pX, pY, pX + 70, pY + 70);
        collected = false;
    }

    void drawPickup(Canvas canvas) {
        Rect tb = gv.tb.getTbRect();
        canvas.drawBitmap(pickupBM, null, pRect, null);
        if (getIntersectTb(pRect, tb)) {
            pickupAction();
            collected = true;
        }
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    void move() {
        if (pX < (-400)) {
            pX = 1400;
            pY = gv.getScreenHeight() / 2 - pickupBM.getHeight() / 2 + getRandomNumberInRange(-300, 300);
            collected = false;
        }
        pX -= 10;
        pY += getRandomNumberInRange(-100,100);
        pRect = new Rect(pX, pY, pX + 70, pY + 70);
    }

    public boolean getIntersectTb(Rect pRect, Rect tbRect) {
        return tbRect.intersect(pRect);
    }

    public boolean getCollected() {
        return collected;
    }

    public abstract void pickupAction();

    public TrueBlueView getGv(){
        return gv;
    }
}
