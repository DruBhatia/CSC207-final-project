package com.example.final_game.TrueBlueAdventure;

class PickupManager {

    /** PickUpManager's gameview*/
    TrueBlueView gv;
    PickupManager(TrueBlueView trueBlueView) {
        gv = trueBlueView;
    }

    /** Creating the fuel*/
    void createFuel(Bitmap image, DonutView donut, int speed) {

    }
    /** Drawing the ants on the canvas.*/
    void draw(Canvas canvas) {

        for (int i = 0; i < ants.size(); i++) {
            ants.get(i).draw(canvas);
        }
    }

    /** Updates the position of every ant in the arraylist ants. */
    void update() {

        for (int i = 0; i < ants.size(); i++) {
            ants.get(i).update();
        }
    }
}


