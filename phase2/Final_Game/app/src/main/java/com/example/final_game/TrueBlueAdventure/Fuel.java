package com.example.final_game.TrueBlueAdventure;

import com.example.final_game.R;

class Fuel extends Pickup{
    public Fuel(TrueBlueView gv){
        super(gv,R.drawable.fuel);
    }

    @Override
    public void pickupAction() {
        return;
    }
}
