package com.example.final_game.AntCrusher;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/** Creates the Donut. */
class Donut extends GameCreature {

  Donut(Bitmap image, int x, int y) {
    super(image, x, y);
  }
  /** Draws the donut on the canvas. */
  public void draw(Canvas canvas) {
    canvas.drawBitmap(image, this.getX(), this.getY(), null);
  }

  @Override
  public void setSpeedPos(int speed, int pos) {}

  @Override
  public void update() {}
}
