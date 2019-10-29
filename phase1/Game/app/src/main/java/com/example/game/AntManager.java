package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

class AntManager {

    ArrayList<Ant> ants;
    private int numAnts = 5;

    AntManager(){

        ants = new ArrayList<>();
        System.out.println(ants.size());
    }

    void createAnts(Bitmap image, DonutView donut, int speed){
        for (int i=0; i < numAnts;i++) {
            double randomX = Math.random();
            int randomNumberX = (int) (randomX * 500);
            double randomY= Math.random();
            int randomNumberY = (int) (randomY * 500);
            System.out.println("x: "+randomNumberX+" y: "+randomNumberY);
            Ant tempAnt = new Ant(image, 200 + randomNumberX,2500 + randomNumberY, donut, speed);
            ants.add(tempAnt);
        }
    }

    void draw(Canvas canvas){

        for (int i = 0; i < ants.size(); i++) {
            ants.get(i).draw(canvas);
        }
    }

    void update() {

        for (int i = 0; i < ants.size(); i++) {
            ants.get(i).update();
        }
    }
}
