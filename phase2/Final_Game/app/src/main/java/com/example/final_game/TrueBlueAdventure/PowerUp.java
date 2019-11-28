package com.example.final_game.TrueBlueAdventure;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.Random;

import com.example.final_game.R;

class PowerUp extends Pickup{
    public PowerUp(TrueBlueView gv){
        super(gv,R.drawable.powerup);
    }

    @Override
    public void pickupAction() {
        getGv().increaseScore();
    }
}
