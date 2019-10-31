package com.example.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.Random;

class Tower {
    private Bitmap topTower, bottomTower;
    private int distance = 500; // distance between top and bottom CN Tower.
    private int minTower, maxTower;
    private int numOfTowers = 4;
    private int distBetweenTowers;
    private int[] cnX = new int[numOfTowers];
    private int[] cnY = new int[numOfTowers];
    private Random random;
    private GameView gv;

    Tower (GameView gv){
        this.gv = gv;
        topTower = BitmapFactory.decodeResource(gv.getResources(), R.drawable.cn_tower_down);
        bottomTower = BitmapFactory.decodeResource(gv.getResources(), R.drawable.cn_tower_up);
    }

    void moveTower () {

        distBetweenTowers = gv.getScreenWidth() * 3 / 4;
        minTower = distance / 2;
        maxTower = gv.getScreenHeight() - minTower - distance;
        random = new Random();

        for (int i = 0; i < numOfTowers; i++) {
            cnX[i] = gv.getScreenWidth() + i * distBetweenTowers;
            cnY[i] = minTower + random.nextInt(maxTower - minTower + 1);
        }
    }

    void drawTower (Canvas canvas) {
        int towerVelocity = 7;
        for (int i = 0; i < numOfTowers; i++) {
            cnX[i] -= towerVelocity;
            if (cnX[i] < -topTower.getWidth()) {
                cnX[i] += numOfTowers * distBetweenTowers;
                cnY[i] = minTower + random.nextInt(maxTower - minTower + 1);
            }
            canvas.drawBitmap(topTower, cnX[i], cnY[i] - topTower.getHeight(), null);
            canvas.drawBitmap(bottomTower, cnX[i], cnY[i] + distance, null);
        }
    }
}
