package com.example.final_game.AntCrusher;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

public class AntManagerFactory {
  private AntGameInterface antManager;
  //  private ArrayList<GameCreature> dataGame;

  void createCreature(String creature, Bitmap image, DonutView donut, int speed) {
    if (creature.equals("Ant")) {
      antManager = new AntManager();
      antManager.createAnts(image, donut, speed);
      //        dataGame = antGameInterface.getCreatures();
    }
  }

  void update() {

    //        for (int i = 0; i < dataGame.size(); i++) {
    //            dataGame.get(i).update();
    //        }
    antManager.update();
  }

  void removeCreature(GameCreature creature) {
    //      dataGame.remove(creature);
    antManager.remove(creature);
  }

  int size() {
    return antManager.size();
  }

  ArrayList<GameCreature> getCreatures() {
    return antManager.getCreatures();
  }

  public void draw(Canvas canvas) {
    antManager.draw(canvas);
  }
}
