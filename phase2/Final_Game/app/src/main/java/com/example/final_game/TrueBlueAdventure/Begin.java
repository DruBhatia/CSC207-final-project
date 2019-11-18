package com.example.final_game.TrueBlueAdventure;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.example.final_game.TrueBlueAdventure.GameView;

public class Begin extends Activity {

  GameView gameView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    gameView = new GameView(this);
    setContentView(gameView);
  }
}
