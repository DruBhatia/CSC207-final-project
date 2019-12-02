package com.example.final_game.TrueBlueAdventure;

import android.graphics.Canvas;

/** Factory for the creation of different PickUp objects **/
public class PickupFactory {
    private Pickup pickup;
    private TrueBlueView gv;

    /** Creates a PickUp object **/
    PickupFactory(String type, TrueBlueView view) {
        if (type.equals("powerup")) {
            this.gv = view;
            this.pickup = new PowerUp(view);
        }
        else if (type.equals("fuel")) {
            this.gv = view;
            this.pickup = new FuelUp(view);
        }
    }

    /** Calls the draw method of the PickUp **/
    void drawPickup(Canvas canvas) {
        pickup.drawPickup(canvas);
    }

    /** Calls the move method of the PickUp **/
    void move() {
        pickup.move();
    }

    /** Calls the getCollected method of the PickUp **/
    boolean getCollected() {
        return pickup.getCollected();
    }

}
