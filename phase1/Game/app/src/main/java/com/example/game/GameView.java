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

  Handler handler;
  Runnable runnable;
  final int delayNum = 30;
  Bitmap background;
  Bitmap topTower, bottomTower;
  Display display;
  Point point;
  int screenWidth, screenHeight; //Height and Width of device.
  Rect rect;
  Bitmap[] tb;  //all the frames of trueblue
  int tbFrame = 0; // the current frame for true blue
  int velocity = 0;
  int gravity = 3;
  int tbX, tbY; // the x and y position of true blue
  int distance = 500; // distance between top and bottom CN Tower.
  int minTower, maxTower;
  int numOfTowers = 4;
  int distBetweenTowers;
  int[] cnX = new int[numOfTowers];
  int[] cnY = new int[numOfTowers];
  boolean state = false;
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
    tb = new Bitmap[3];
    tb[0] = BitmapFactory.decodeResource(getResources(), R.drawable.trueblue_frame_0);
    tb[1] = BitmapFactory.decodeResource(getResources(), R.drawable.trueblue_frame_1);
    tb[2] = BitmapFactory.decodeResource(getResources(), R.drawable.trueblue_frame_2);
    tbX = screenWidth/2 - tb[0].getWidth()/2;
    tbY = screenHeight/2 - tb[0].getHeight()/2;
    distBetweenTowers = screenWidth * 3 / 4;
    minTower = distance / 2;
    maxTower = screenHeight - minTower - distance;
    random = new Random();
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
    if(tbFrame == 0){
      tbFrame = 1;
    }
    else if(tbFrame == 1){
      tbFrame = 2;
    }
    else{
      tbFrame = 0;
    }
    // true blue falls
    if (state) {
      if (tbY < screenHeight - tb[0].getHeight()) {
        velocity += gravity;
        tbY += velocity;
      }
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
    canvas.drawBitmap(tb[tbFrame], tbX,tbY,null);
    handler.postDelayed(runnable, delayNum);
  }
  // When you tap the screen
  @Override
  public boolean onTouchEvent(MotionEvent event) {
    int action = event.getAction();
    if (action == MotionEvent.ACTION_DOWN){  // if the Tap is detected on the screen
      velocity = -30; // increase true blue's upward velocity
      state = true;
    }
    return true;
  }
}