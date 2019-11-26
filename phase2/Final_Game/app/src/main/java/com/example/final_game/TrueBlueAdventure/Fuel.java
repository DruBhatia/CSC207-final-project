package com.example.final_game.TrueBlueAdventure;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.final_game.R;

class Fuel {
    /**
     *fX: fuel's x coordinate fY: fuel's y coordinate
     */
    private int fX, fY;
    /** The gameview fuel is displayed in * */
    private TrueBlueView gv;
    /** a Btmap of fuel* */
    private Bitmap fuelBM;
    /** the rec representation for fuel * */
    private Rect fRect;

    Fuel(TrueBlueView gv) {
        this.gv = gv;
        fuelBM = BitmapFactory.decodeResource(gv.getResources(), R.drawable.fuel);
        fX = gv.getScreenWidth() / 2 - fuelBM.getWidth() / 2;
        fY = gv.getScreenHeight() / 2 - fuelBM.getHeight() / 2;
        fRect = new Rect(fX, fY, fX + fuelBM.getWidth(), fY + fuelBM.getHeight());
    }

    /** draw's fuel * */
    void drawFuel(Canvas canvas) {
        canvas.drawBitmap(fuelBM, null, fRect, null);
    }

    /** draws fuels's invisible rectangle* */
    void drawFuel(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.TRANSPARENT);
        canvas.drawRect(fRect, p);
    }

}
