package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main4);
  }

  public void begin(View view) {
    Intent intent = new Intent(this, Begin.class);
    startActivity(intent);
    finish();
  }
}
