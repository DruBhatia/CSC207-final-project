package com.example.final_game.TrueBlueAdventure;

import com.example.final_game.R;

/** A fuel pickup item**/
class FuelUp extends Pickup {
  FuelUp(TrueBlueView gv) {
    super(gv, R.drawable.fuel, 3300, -1100);
  }

  /**Implements pickupAction(On pickup increase fuel amount) */
  @Override
  public void pickupAction() {
    getGv().increaseFuel();
  }
}
