package com.example.final_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.TextView;

public class Memory3Activity extends Memory2Activity {

  MemoryView game_view;
  MemorizePlayer memorizePlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    memorizePlayer =
        new MemorizePlayer(
            (TextView) findViewById(R.id.text_moves),
            (TextView) findViewById(R.id.text_points),
            (Chronometer) findViewById(R.id.stopWatch));
    String theme = getIntent().getExtras().get("Theme???").toString();
    if (theme.equals("Light")) {
      setContentView(R.layout.activity_memorygame);
      game_view = new MemoryView(this, "L", memorizePlayer);
    } else if (theme.equals("Dark")) {
      setContentView(R.layout.activity_main2_dark);
      game_view = new MemoryView(this, "D", memorizePlayer);
    }
  }

  @Override
  void endGame(boolean check) {
    int playerMoves = memorizePlayer.getMovesLeft();
    int playerPoints = memorizePlayer.getPlayerPoints();
    boolean bool = game_view.checkVisibility();
    if (check) {
      CharSequence elapsedMillis = memorizePlayer.getChronometer().getText();
      memorizePlayer.getChronometer().stop();
      Intent intent1 = new Intent(Memory3Activity.this, Game2OverActivity.class);
      intent1.putExtra("points3", playerPoints);
      intent1.putExtra("Moves Left3", playerMoves);
      intent1.putExtra("time3", elapsedMillis);
      if (bool) {
        intent1.putExtra("Cards Left3", "NO");
      } else {
        intent1.putExtra("Cards Left3", "YES");
      }
      startActivity(intent1);
    }
  }
}
