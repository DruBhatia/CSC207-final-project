package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class Ant extends GameCreature{

    private int speed = 10;
    private DonutView donutView;

    private Ant(Bitmap image, int x, int y, DonutView donutView) {
        super(image, x, y);
        this.donutView = donutView;
    }

    private void draw(Canvas canvas) {
        canvas.drawBitmap(image, this.getX(), this.getY(), null);
    }

    private void update(){
        //for now it just moves the ant in one direction will change to random later.
        this.setX(this.getX()+speed);
        if (this.getX() < 0) {
            this.setX(0);
            this.speed = -this.speed;
        } else if (this.getX() > donutView.getWidth() - image.getWidth()) {
            this.setX(donutView.getWidth() - image.getWidth());
            this.speed = -this.speed;
        }
    }
}
