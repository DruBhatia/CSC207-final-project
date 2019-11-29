package com.example.final_game.AntCrusher;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/** Super class for all creatures and items created.*/
public abstract class GameCreature {

  Bitmap image;
  private final int width;
  private final int height;
  private int x;
  private int y;
  private int speed;

  GameCreature(Bitmap image, int x, int y) {
    this.image = image;
    this.x = x;
    this.y = y;
    this.width = image.getWidth();
    this.height = image.getHeight();
  }
  /** Getter for width of creature.*/
  int getWidth() {
    return width;
  }
  /** Getter for height of creature.*/
  int getHeight() {
    return height;
  }
  /** Setter for X coordinate of creature.*/
  public void setX(int x) {
    this.x = x;
  }
  /** Setter for Y coordinate of creature.*/
  void setY(int y) {
    this.y = y;
  }
  /** Getter for X coordinate of creature.*/
  int getX() {
    return x;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getSpeed() {
    return speed;
  }

  /** Getter for Y coordinate of creature.*/
  int getY() {
    return y;
  }

  abstract public void update();
  abstract public void draw(Canvas canvas);
  abstract public void setSpeedPos(int speed, int pos);
}
