package com.example.final_game.AntCrusher;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/** Creates the Donut. */
class Donut extends GameCreature {

  Donut(Bitmap image, int x, int y, DonutView donutView) {
    super(image, x, y);
  }
  /** Draws the donut on the canvas.*/
  void draw(Canvas canvas) {
    canvas.drawBitmap(image, this.getX(), this.getY(), null);
  }
}
