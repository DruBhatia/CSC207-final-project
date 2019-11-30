package com.example.final_game.TrueBlueAdventure;

import com.example.final_game.R;

class FuelUp extends Pickup {
  FuelUp(TrueBlueView gv) {
    super(gv, R.drawable.fuel, 3000, -1000);
  }

  @Override
  public void pickupAction() {
    getGv().increaseFuel();
  }
}
