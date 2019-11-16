package com.example.final_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Memory1Activity extends AppCompatActivity {
  MemoryView game_view;
  MemorizePlayer memorizePlayer;
  String theme;

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
    memorizePlayer.setVisibility(2);
    theme = getIntent().getExtras().get("Theme?").toString();
    if (theme.equals("Light")) {
      setContentView(R.layout.activity_memorygame);
      game_view = new MemoryView(this, "L", memorizePlayer);
    } else if (theme.equals("Dark")) {
      setContentView(R.layout.activity_main2_dark);
      game_view = new MemoryView(this, "D", memorizePlayer);
    }
  }

  /** Check if end-game conditions have been met. */
  boolean checkEnd() {
    return game_view.checkVisibility();
  }

  /**
   * End game if all end-game conditions have been met, track player stats, and navigate to
   * game-over screen.
   */
  void endGame(boolean check) {
    int playerPoints = memorizePlayer.getPlayerPoints();
    boolean bool = game_view.checkVisibility();
    if (check) {
      memorizePlayer.getChronometer().stop();
      Intent intent1 = new Intent(Memory1Activity.this, Game2OverActivity.class);
      Intent intent2 = new Intent(Memory1Activity.this, Memory2Activity.class);
      intent1.putExtra("points1", playerPoints);
      if (bool) {
        intent1.putExtra("Cards Left1", "NO");
      } else {
        intent1.putExtra("Cards Left1", "YES");
      }
      if (theme.equals("Light")) {
        intent2.putExtra("Theme??", "Light");
      } else if (theme.equals("Dark")) {
        intent2.putExtra("Theme??", "Dark");
      }
      startActivity(intent2);
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
  }
}
