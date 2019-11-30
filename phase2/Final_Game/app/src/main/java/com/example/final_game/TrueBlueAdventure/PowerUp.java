package com.example.final_game.TrueBlueAdventure;

import com.example.final_game.R;

class PowerUp extends Pickup {
  PowerUp(TrueBlueView gv) {
    super(gv, R.drawable.powerup, 1400, -400);
  }

  @Override
  public void pickupAction() {
    getGv().increaseScore();
  }
}
