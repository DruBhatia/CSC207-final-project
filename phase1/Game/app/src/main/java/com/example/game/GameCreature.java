package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class GameCreature {

    protected Bitmap image;
    private final int width;
    private final int height;
    private int x;
    private int y;

    public GameCreature(Bitmap image, int x, int y){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
