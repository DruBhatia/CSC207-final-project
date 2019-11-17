package com.example.final_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MemoryBegin extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_memorybegin);
    ImageButton playMemory = findViewById(R.id.imageButton);
    ImageButton playMemoryDark = findViewById(R.id.imageButton2);
    Button HighScore = findViewById(R.id.highScore);

    playMemory.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent2 = new Intent(MemoryBegin.this, Memory1Activity.class);
            intent2.putExtra("Theme?", "Light");
            startActivity(intent2);
          }
        });

    playMemoryDark.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent3 = new Intent(MemoryBegin.this, Memory1Activity.class);
            intent3.putExtra("Theme?", "Dark");
            startActivity(intent3);
          }
        });
  }
}
