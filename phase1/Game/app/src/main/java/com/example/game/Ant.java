package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class Ant extends GameCreature{

    private int speed = 10;
    private DonutView donutView;

    Ant(Bitmap image, int x, int y, DonutView donutView) {
        super(image, x, y);
        this.donutView = donutView;
    }

    void draw(Canvas canvas) {
        canvas.drawBitmap(image, this.getX(), this.getY(), null);
    }

    void update(){
        //for now it just moves the ant in one direction will change to random later.
        this.setY(this.getY()+speed);
        if (this.getY() < 0) {
            this.setY(0);
            this.speed = -this.speed;
        } else if (this.getY() > donutView.getHeight() - image.getHeight()) {
            this.setY(donutView.getHeight() - image.getHeight());
            this.speed = -this.speed;
        }
    }
}
