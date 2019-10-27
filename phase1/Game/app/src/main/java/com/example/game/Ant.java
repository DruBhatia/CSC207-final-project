package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Paint;

public class Ant {
    private int x;
    private int y;
    private int speed = 10;
    private Bitmap image;
    private Paint p = new Paint();

    public Ant(Bitmap image){
        this.image = image;

    }

}
