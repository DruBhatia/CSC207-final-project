package com.example.final_game.AntCrusher;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;
/** Creates the ants . */
class AntManager implements AntGameInterface {

  /** Arraylist of ants to be generated. */
  private ArrayList<GameCreature> ants;

  AntManager() {

    ants = new ArrayList<>();
  }
  /** Creating the arraylist ants. */
  public void createAnts(Bitmap image, DonutView donut, int speed) {
    int numAnts = 5;
    for (int i = 0; i < numAnts; i++) {
      double randomX = Math.random();
      int randomNumberX = (int) (randomX * 500);
      double randomY = Math.random();
      int randomNumberY = (int) (randomY * 500);
      System.out.println("x: " + randomNumberX + " y: " + randomNumberY);
      Ant tempAnt = new Ant(image, 200 + randomNumberX, 2800 + randomNumberY, speed);
      if (i % 3 == 0) {
        RandomAnt randomAnt =
            new RandomAnt(image, 200 + randomNumberX, 2400 + randomNumberY, speed);
        ants.add(randomAnt);
      }
      ants.add(tempAnt);
    }
  }
  /** Drawing the ants on the canvas. */
  public void draw(Canvas canvas) {

    for (int i = 0; i < ants.size(); i++) {
      ants.get(i).draw(canvas);
    }
  }

  /** Updates the position of every ant in the arraylist ants. */
  public void update() {

    for (int i = 0; i < ants.size(); i++) {
      ants.get(i).update();
    }
  }

  public int size() {
    return ants.size();
  }

  public ArrayList<GameCreature> getCreatures() {
    return ants;
  }

  public void remove(GameCreature creature) {
    ants.remove(creature);
  }
}
