package com.example.final_game.AntCrusher;

import android.graphics.Bitmap;

public class RandomAnt extends Ant implements AntMove {

  /** Creates an RandomAnt a ant that moves in a zig-zag pattern. */
  RandomAnt(Bitmap image, int x, int y, int speed) {
    super(image, x, y, speed);
  }

  public void update() {
    int randomSpeed = (int) (Math.random() * getSpeed() * 2);
    this.setY(this.getY() - randomSpeed);
    int[] i = {-1, 1};
    this.setX(this.getX() + i[(int) Math.ceil(Math.random() - 0.5)] * randomSpeed);
    if (this.getX() < 150) this.setX(this.getX() + 50);
    else if (this.getX() > 700) this.setX(this.getX() - 50);
  }
}
