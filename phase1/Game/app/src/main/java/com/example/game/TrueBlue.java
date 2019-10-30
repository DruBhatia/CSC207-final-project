package com.example.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class TrueBlue {
  public int tbFrame, velocity, gravity, tbX, tbY;
  private GameView gv;
  public Bitmap[] tb;
  private boolean state;

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
  }

  protected void animateTB() {
    if (tbFrame == 0) {
      tbFrame = 1;
    } else if (tbFrame == 1) {
      tbFrame = 2;
    } else {
      tbFrame = 0;
    }
  }

  protected void drawTB(Canvas canvas) {
    canvas.drawBitmap(tb[tbFrame], tbX, tbY, null);
  }

  protected void tbOnTouch(int action) {
    if (action == MotionEvent.ACTION_DOWN) { // if the Tap is detected on the screen
      velocity = -30; // increase true blue's upward velocity
      state = true;
    }
  }

  protected boolean getState() {
    return state;
  }

  void tbFall() {
    if (tbY < gv.getScreenHeight()- tb[0].getHeight()) {
      velocity += gravity;
      tbY += velocity;
    }
  }
}
