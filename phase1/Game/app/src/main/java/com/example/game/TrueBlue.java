package com.example.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

class TrueBlue {
  private int tbFrame, velocity, gravity, tbX, tbY;
  private GameView gv;
  Bitmap[] tb;
  private boolean state;
  Rect tbRect;

  TrueBlue(GameView gv) {
    tbFrame = 0; // the current frame for true blue
    velocity = 0;
    gravity = 3;
    this.gv = gv;
    state = false;
    tb = new Bitmap[3];
    tb[0] = BitmapFactory.decodeResource(gv.getResources(), R.drawable.trueblue_frame_0);
    tb[1] = BitmapFactory.decodeResource(gv.getResources(), R.drawable.trueblue_frame_1);
    tb[2] = BitmapFactory.decodeResource(gv.getResources(), R.drawable.trueblue_frame_2);
    tbX = gv.getScreenWidth() / 2 - tb[0].getWidth() / 2;
    tbY = gv.getScreenHeight() / 2 - tb[0].getHeight() / 2;
    tbRect = new Rect(tbX, tbY, tbX + tb[0].getWidth(), tbY + tb[0].getHeight());
  }

  void animateTB() {
    if (tbFrame == 0) {
      tbFrame = 1;
    } else if (tbFrame == 1) {
      tbFrame = 2;
    } else {
      tbFrame = 0;
    }
  }

  void drawTB(Canvas canvas) {
    canvas.drawBitmap(tb[tbFrame], null, tbRect, null);
  }

  void tbOnTouch(int action) {
    if (action == MotionEvent.ACTION_DOWN) { // if the Tap is detected on the screen
      velocity = -30; // increase true blue's upward velocity
      state = true;
    }
  }

  boolean getState() {
    return state;
  }

  void setState() {
    if (state) state = false;
    else state = true;
  }

  void tbFall() {
    if (tbY < gv.getScreenHeight() - tb[0].getHeight() || velocity < 0) {
      velocity += gravity;
      tbY += velocity;
      tbRect = new Rect(tbX, tbY, tbX + tb[0].getWidth(), tbY + tb[0].getHeight());
    }
  }

  int getTbX() {
    return tbX;
  }

  int getTbY() {
    return tbY;
  }

  boolean getIntersectTb(Rect TowerRect){
    return tbRect.intersect(TowerRect);
  }
}
