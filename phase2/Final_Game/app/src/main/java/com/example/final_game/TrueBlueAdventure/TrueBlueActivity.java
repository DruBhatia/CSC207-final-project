package com.example.final_game.TrueBlueAdventure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.final_game.R;

public class TrueBlueActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_trueblue);
  }

  public void begin(View view) {
    Intent intent = new Intent(this, Begin.class);
    startActivity(intent);
    finish();
  }
}
