package com.example.final_game.TrueBlueAdventure;

import com.example.final_game.R;

class FuelUp extends Pickup{
    public FuelUp(TrueBlueView gv){
        super(gv,R.drawable.fuel);
    }

    @Override
    public void pickupAction() {
        getGv().increaseFuel();
    }
}
