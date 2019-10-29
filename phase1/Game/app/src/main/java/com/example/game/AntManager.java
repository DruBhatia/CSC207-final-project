package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

class AntManager {

    ArrayList<Ant> ants;
    private int numAnts;

    AntManager(){

        ants = new ArrayList<>();
        System.out.println(ants.size());
//        this.numAnts = numAnts;
    }

    void createAnts(Bitmap image, DonutView donut){
//        for (int i=0; i < numAnts;i++) {
//            Ant tempAnt = new Ant(image,400,600, donut);
//            ants.add(i, tempAnt);
//        }

        ants.add(new Ant(image,400,1200, donut));

        ants.add(new Ant(image,100,1200, donut));


    }

    void draw(Canvas canvas){
        for (int i = 0; i < numAnts; i++) {
            ants.get(i).draw(canvas);
        }

        for (int i = 0; i < ants.size(); i++) {
            ants.get(i).draw(canvas);
        }
    }

//    void update() {
//        for (int i = 0; i < numAnts; i++) {
//            ants.get(i).update();
//        }
//    }
    void update() {

        for (int i = 0; i < ants.size(); i++) {
            ants.get(i).update();
        }
    }
}
