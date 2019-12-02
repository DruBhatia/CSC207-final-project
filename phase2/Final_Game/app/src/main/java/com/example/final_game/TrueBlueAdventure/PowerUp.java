package com.example.final_game.TrueBlueAdventure;

import com.example.final_game.R;

/**A powerup pickup item**/
class PowerUp extends Pickup {
  public PowerUp(TrueBlueView gv) {
    super(gv, R.drawable.powerup, 1500, -500);
  }


  /**Implements pickupAction(On pickup increase score) */
  @Override
  public void pickupAction() {
    getGv().increaseScore();
  }
}
