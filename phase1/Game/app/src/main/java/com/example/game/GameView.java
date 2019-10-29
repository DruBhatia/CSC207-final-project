package com.example.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.os.Handler;

class GameView extends View {
  //This will be the custom view class for Game3

  Handler handler;
  Runnable runnable;
  final int delayNum = 30;
  Bitmap background;
  Display display;
  Point point;
  int screenWidth, screenHeight; //Height and Width of device.
  Rect rect;


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
    display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
    point = new Point();
    display.getSize(point);
    screenWidth = point.x;
    screenHeight = point.y;
    rect = new Rect(0, 0, screenWidth, screenHeight);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //This is where we will draw our view for Game3.
    canvas.drawBitmap(background, null, rect, null);
    handler.postDelayed(runnable, delayNum);
  }
}