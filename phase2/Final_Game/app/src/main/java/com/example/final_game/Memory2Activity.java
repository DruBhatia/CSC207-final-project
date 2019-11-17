package com.example.final_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Memory2Activity extends Memory1Activity {
  MemoryView game_view;
  String theme;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    theme = getIntent().getExtras().get("Theme??").toString();
    if (theme.equals("Light")) {
      setContentView(R.layout.activity_memorygame);
      game_view = new MemoryView(this, "L", 2);
    } else if (theme.equals("Dark")) {
      setContentView(R.layout.activity_main2_dark);
      game_view = new MemoryView(this, "D", 2);
    }
  }


  boolean checkEnd() {
    return game_view.player.getMovesLeft() == 0 || game_view.checkVisibility();
  }

  void endGame(boolean check) {
    int playerMoves = game_view.player.getMovesLeft();
    int playerPoints = game_view.player.getPlayerPoints();
    boolean bool = game_view.checkVisibility();
    if (check) {
      CharSequence elapsedMillis = game_view.player.getChronometer().getText();
      game_view.player.getChronometer().stop();
      Intent intent1 = new Intent(Memory2Activity.this, Game2OverActivity.class);
      Intent intent2 = new Intent(Memory2Activity.this, Memory3Activity.class);
      intent1.putExtra("points2", playerPoints);
      intent1.putExtra("Moves Left2", playerMoves);
      intent1.putExtra("time2", elapsedMillis);
      if (bool) {
        intent1.putExtra("Cards Left2", "NO");
      } else {
        intent1.putExtra("Cards Left2", "YES");
      }
      if (theme.equals("Light")) {
        intent2.putExtra("Theme???", "Light");
      } else if (theme.equals("Dark")) {
        intent2.putExtra("Theme???", "Dark");
      }
      startActivity(intent2);
    }
  }
}
