package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class Ant extends GameCreature{

    private int speed;
    private DonutView donutView;
    static int numAntsOffReached = 0;

    Ant(Bitmap image, int x, int y, DonutView donutView, int speed) {
        super(image, x, y);
        this.donutView = donutView;
        this.speed = speed;
    }

    void draw(Canvas canvas) {
        canvas.drawBitmap(image, this.getX(), this.getY(), null);
    }

    void update(){
        //for now it just moves the ant in one direction will change to random later.
        int randomSpeed = (int) (Math.random() * speed * 2);
        this.setY(this.getY() - randomSpeed);
        if (this.getY() < 500) {
            this.setY(3000);
            this.speed += 1;
            numAntsOffReached++;
            donutView.decreaseLife();
        }
    }
}
