package com.example.final_game.Memorize;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.final_game.R;

public class MemoryActivity extends AppCompatActivity {
  MemoryView game_view;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    String theme = getIntent().getExtras().get("Theme?").toString();
    int level = (int) getIntent().getExtras().get("Level?");
    if (theme.equals("Light")) {
      setContentView(R.layout.activity_memorygame);
      game_view = new MemoryView(this, "L", level);
    } else {
      setContentView(R.layout.activity_memorygame_dark);
      game_view = new MemoryView(this, "D", level);
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
