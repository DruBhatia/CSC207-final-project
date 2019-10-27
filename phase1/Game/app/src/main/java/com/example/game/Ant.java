package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Ant extends GameCreature{

    private final int speed = 10;
    private DonutView donutView;

    public Ant(Bitmap image, int x, int y, DonutView donutView) {
        super(image, x, y);
        this.donutView = donutView;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, this.getX(), this.getY(), null);
    }

    public void update(){
        //for now it just moves the ant in one direction will change to random later.
        this.setX(this.getX()+speed);
        this.setY(this.getY()+speed);
    }
}
