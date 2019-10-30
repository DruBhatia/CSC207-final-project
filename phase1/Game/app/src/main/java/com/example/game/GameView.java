package com.example.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;
import java.util.Random;


public class GameView extends View {
  //This will be the custom view class for Game3
  TrueBlue tb;
  Handler handler;
  Runnable runnable;
  final int delayNum = 30;
  Bitmap background;
  Bitmap topTower, bottomTower;
  Display display;
  Point point;
  int screenWidth, screenHeight; //Height and Width of device.
  Rect rect;
  int distance = 500; // distance between top and bottom CN Tower.
  int minTower, maxTower;
  int numOfTowers = 4;
  int distBetweenTowers;
  int[] cnX = new int[numOfTowers];
  int[] cnY = new int[numOfTowers];
  Random random;
  int towerVelocity = 7;


  public GameView(Context context) {
    super(context);
    handler = new Handler();
    runnable = new Runnable() {
      @Override
      public void run() {
        invalidate(); //This should call onDraw.
      }
    };
    background = BitmapFactory.decodeResource(getResources(), R.drawable.game3_background);
    topTower = BitmapFactory.decodeResource(getResources(), R.drawable.cn_tower_down);
    bottomTower = BitmapFactory.decodeResource(getResources(), R.drawable.cn_tower_up);
    display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
    point = new Point();
    display.getSize(point);
    screenWidth = point.x;
    screenHeight = point.y;
    rect = new Rect(0, 0, screenWidth, screenHeight);
    distBetweenTowers = screenWidth * 3 / 4;
    minTower = distance / 2;
    maxTower = screenHeight - minTower - distance;
    random = new Random();
    tb = new TrueBlue(this);
    for (int i = 0; i < numOfTowers; i++) {
      cnX[i] = screenWidth + i * distBetweenTowers;
      cnY[i] = minTower + random.nextInt(maxTower - minTower + 1);
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //This is where we will draw our view for Game3.
    canvas.drawBitmap(background, null, rect, null);

    // animate true blue
    tb.animateTB();


    // true blue falls
    if (tb.getState()) {
      tb.tbFall();
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
    //displays true blue in the center
    tb.drawTB(canvas);
    handler.postDelayed(runnable, delayNum);
  }
  // When you tap the screen
  @Override
  public boolean onTouchEvent(MotionEvent event) {
    int action = event.getAction();
    tb.tbOnTouch(action);
    return true;
  }

  public int getScreenWidth(){
    return screenWidth;
  }
  public int getScreenHeight(){
    return screenHeight;
  }
}
