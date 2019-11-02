package com.example.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;

public class GameView extends View {
  // This will be the custom view class for Game3
  TrueBlue tb; // TrueBlue class
  Tower cn; // Tower class
  Handler handler;
  Runnable runnable;
  final int delayNum = 30;
  Bitmap background;
  Display display;
  Point point;
  int screenWidth, screenHeight; // Height and Width of device.
  Rect rect;
  /** The score paint to display the score. */
  private Paint scorePaint = new Paint();
  /** The score variable that keeps track of current score */
  private int score = 0;


  public GameView(Context context) {
    super(context);
    handler = new Handler();
    runnable =
            new Runnable() {
              @Override
              public void run() {
                invalidate(); // This should call onDraw.
              }
            };
    background = BitmapFactory.decodeResource(getResources(), R.drawable.game3_background);
    display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
    point = new Point();
    display.getSize(point);
    screenWidth = point.x;
    screenHeight = point.y;
    rect = new Rect(0, 0, screenWidth, screenHeight);
    cn = new Tower(this); // created CN Tower
    cn.moveTower(); // moves CN Tower
    tb = new TrueBlue(this); // creates TrueBlue
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    // This is where we will draw our view for Game3.
    canvas.drawBitmap(background, null, rect, null);
    scorePaint.setColor(-16776961);
    scorePaint.setTextSize(80);
    scorePaint.setUnderlineText(true);
    canvas.drawText("Score : " + score, 20, 60, scorePaint);
    tb.drawTBRect(canvas);
    // animate true blue
    tb.animateTB();

    // true blue falls
    if (tb.getState()) {
      tb.tbFall();
      cn.drawTower(canvas); // Endless number of CN Tower is created.
    }
    // displays true blue in the center
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

  public int getScreenWidth() {
    return screenWidth;
  }

  public int getScreenHeight() {
    return screenHeight;
  }

  public void gameOver(){
    tb.setState();
    Intent intent = new Intent(getContext(), Game3OverActivity.class);
    getContext().startActivity(intent);
  }

}
