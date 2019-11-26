package com.example.final_game.TrueBlueAdventure;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.final_game.R;

public class Powerup {
    /**
     *fX: fuel's x coordinate fY: fuel's y coordinate
     */
    private int pX, pY;
    /** The gameview fuel is displayed in * */
    private TrueBlueView gv;
    /** a Btmap of fuel* */
    private Bitmap powerupBM;
    /** the rec representation for fuel * */
    private Rect pRect;

    Powerup(TrueBlueView gv) {
        this.gv = gv;
        powerupBM = BitmapFactory.decodeResource(gv.getResources(), R.drawable.powerup);
        pX = gv.getScreenWidth() / 2 - powerupBM.getWidth() / 2;
        pY = gv.getScreenHeight() / 2 - powerupBM.getHeight() / 2;
        pRect = new Rect(pX, pY, pX + 5, pY + powerupBM.getHeight());
    }
}
