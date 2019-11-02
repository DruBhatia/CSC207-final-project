package com.example.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

// A class to create CN Tower in game3.

class Tower {
  private Bitmap topTower, bottomTower;
  private int distance = 700; // distance between top and bottom CN Tower.
  private int minTower, maxTower;
  private int numOfTowers = 4;
  private int distBetweenTowers;
  private int[] cnX = new int[numOfTowers];
  private int[] cnY = new int[numOfTowers];
  private Random random;
  private GameView gv;
  private Rect topTowerRect;
  private Rect bottomTowerRect;

  Tower(GameView gv) {
    this.gv = gv;
    topTower = BitmapFactory.decodeResource(gv.getResources(), R.drawable.cn_tower_down);
    bottomTower = BitmapFactory.decodeResource(gv.getResources(), R.drawable.cn_tower_up);
    topTowerRect =
        new Rect(
            cnX[0],
            cnY[0] - topTower.getHeight(),
            cnX[0] + topTower.getWidth(),
            cnY[0] - topTower.getHeight() + topTower.getHeight());
    bottomTowerRect =
        new Rect(
            cnX[0],
            cnY[0] + distance,
            cnX[0] + bottomTower.getWidth(),
            cnY[0] + distance + bottomTower.getHeight());
  }

  void moveTower() {
    // Makes numOfTowers and makes them move across the display

    distBetweenTowers = gv.getScreenWidth() * 3 / 4;
    minTower = distance / 2;
    maxTower = gv.getScreenHeight() - minTower - distance;
    random = new Random();

    for (int i = 0; i < numOfTowers; i++) {
      cnX[i] = gv.getScreenWidth() + i * distBetweenTowers;
      cnY[i] = minTower + random.nextInt(maxTower - minTower + 1);
    }
  }

  void drawTower(Canvas canvas) {
    // used the numOfTowers and creates endless number of CN towers occurring at random.

    int towerVelocity = 7;
    for (int i = 0; i < numOfTowers; i++) {
      cnX[i] -= towerVelocity;
      if (cnX[i] < -topTower.getWidth()) {
        cnX[i] += numOfTowers * distBetweenTowers;
        cnY[i] = minTower + random.nextInt(maxTower - minTower + 1);
      }
      Paint p = new Paint();
      p.setARGB(128, 255, 255, 255);
      topTowerRect =
          new Rect(
              cnX[i],
              cnY[i] - topTower.getHeight(),
              cnX[i] + topTower.getWidth(),
              cnY[i] - topTower.getHeight() + topTower.getHeight());
      bottomTowerRect =
          new Rect(
              cnX[i],
              cnY[i] + distance,
              cnX[i] + bottomTower.getWidth(),
              cnY[i] + distance + bottomTower.getHeight());
      canvas.drawBitmap(topTower, null, topTowerRect, null);
      canvas.drawBitmap(bottomTower, null, bottomTowerRect, null);
      canvas.drawRect(topTowerRect, p);
      canvas.drawRect(bottomTowerRect, p);
      Rect tb = gv.tb.getTbRect();
      if (getIntersectTb(bottomTowerRect, tb) || getIntersectTb(topTowerRect, tb)) {
        gv.gameOver();
      }
    }
  }

  int getNumOfTowers() {
    return numOfTowers;
  }

  int getcnX(int i) {
    return cnX[i];
  }

  int getcnY(int i) {
    return cnY[i];
  }

  int getWidth() {
    return topTower.getWidth();
  }

  int getHeight() {
    return topTower.getHeight();
  }

  public Rect getTopTowerRect() {
    return topTowerRect;
  }

  public Rect getBottomTowerRect() {
    return bottomTowerRect;
  }

  private boolean getIntersectTb(Rect TowerRect, Rect tbRect) {
    return tbRect.intersect(TowerRect);
  }
}
