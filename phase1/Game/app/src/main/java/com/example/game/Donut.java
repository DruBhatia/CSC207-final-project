package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class Donut extends GameCreature{

    private int speed = 10;

    Donut(Bitmap image, int x, int y, DonutView donutView) {
        super(image, x, y);
    }

    void draw(Canvas canvas) {
        canvas.drawBitmap(image, this.getX(), this.getY(), null);
    }


}
