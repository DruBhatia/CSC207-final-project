package com.example.final_game.AntCrusher;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class Ant extends GameCreature implements AntMove {

  /** speed of the ant. */
  private int speed;

  /** Creates an Ant. */
  Ant(Bitmap image, int x, int y, int speed) {
    super(image, x, y);
    this.speed = speed;
  }

  /** Draws the ant on the canvas. */
  public void draw(Canvas canvas) {
    canvas.drawBitmap(image, this.getX(), this.getY(), null);
  }

  /** Updates the position of the ant. */
  public void update() {
    int randomSpeed = (int) (Math.random() * speed * 2);
    this.setY(this.getY() - randomSpeed);
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeedPos(int speed, int y) {
    this.setSpeed(speed);
    this.setY(y);
  }
}
