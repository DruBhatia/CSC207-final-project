package com.example.final_game.AntCrusher.AntPresenter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

//import com.example.final_game.AntCrusher.AntPresenter.AntGameInterface;
import com.example.final_game.AntCrusher.AntModel.GameCreature;
import com.example.final_game.AntCrusher.AntView.DonutView;

import java.util.ArrayList;

/** Factory for the creation of game creatures. */
public class AntManagerFactory {
  private AntGameInterface antManager;
  //  private ArrayList<GameCreature> dataGame;
  /** Creating the creatures.*/
  public void createCreature(String creature, Bitmap image, DonutView donut, int speed) {
    if (creature.equals("Ant")) {
      antManager = new AntManager();
      antManager.createAnts(image, donut, speed);
      //        dataGame = antGameInterface.getCreatures();
    }
  }
  /** Updating the position of the creatures. */
  void update() {

    //        for (int i = 0; i < dataGame.size(); i++) {
    //            dataGame.get(i).update();
    //        }
    antManager.update();
  }
  /** Removes the creature. */
  void removeCreature(GameCreature creature) {
    //      dataGame.remove(creature);
    antManager.remove(creature);
  }
  /** Returns number of creatures displayed on screen. */
  int size() {
    return antManager.size();
  }
  /** Getter for the creatures. */
  ArrayList<GameCreature> getCreatures() {
    return antManager.getCreatures();
  }
  /** Draws the creatures on screen. */
  public void draw(Canvas canvas) {
    antManager.draw(canvas);
  }
}
