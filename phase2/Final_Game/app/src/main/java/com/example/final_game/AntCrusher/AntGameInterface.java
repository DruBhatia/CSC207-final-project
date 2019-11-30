package com.example.final_game.AntCrusher;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

interface AntGameInterface { // imlpemented by ant manager.
  void createAnts(Bitmap image, DonutView donut, int speed);

  void draw(Canvas canvas);

  void update();

  int size();

  void remove(GameCreature creature);

  ArrayList<GameCreature> getCreatures();
}
