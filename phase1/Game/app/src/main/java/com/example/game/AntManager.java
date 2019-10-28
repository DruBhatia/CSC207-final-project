package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

class AntManager {

    private ArrayList<Ant> ants;
    private int numAnts;

    AntManager(int numAnts){

        ants = new ArrayList<>();
        this.numAnts = numAnts;
    }

    void createAnts(Bitmap image, DonutView donut){
        for (int i=0; i < numAnts;i++) {
            Ant tempAnt = new Ant(image,400,600, donut);
            ants.add(i, tempAnt);
        }
    }

    void draw(Canvas canvas){
        for (int i = 0; i < numAnts; i++) {
            ants.get(i).draw(canvas);
        }
    }

    void update() {
        for (int i = 0; i < numAnts; i++) {
            ants.get(i).update();
        }
    }
}
