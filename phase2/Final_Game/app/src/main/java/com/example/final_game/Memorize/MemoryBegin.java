package com.example.final_game.Memorize;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;

import com.example.final_game.Infrastructure.Main1Activity;
import com.example.final_game.R;

public class MemoryBegin extends Main1Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_memorybegin);
    ImageButton playMemory = findViewById(R.id.imageButton);
    ImageButton playMemoryDark = findViewById(R.id.imageButton2);
    Button HighScore = findViewById(R.id.highScore);

    playMemory.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent1 = new Intent(MemoryBegin.this, MemoryActivity.class);
            intent1.putExtra("Theme?", "Light");
            intent1.putExtra("Level?", 1);
            startActivity(intent1);
          }
        });

    playMemoryDark.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent2 = new Intent(MemoryBegin.this, MemoryActivity.class);
            intent2.putExtra("Theme?", "Dark");
              intent2.putExtra("Level?", 1);
            startActivity(intent2);
          }
        });

    HighScore.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Cursor cur = gameDb.getAllData("GAME1STATS");
            if (cur.getCount() == 0) {
              System.out.println("Error no data found");
              showMessage("ERROR", "NOTHING FOUND IN DATABASE");
            } else {
              StringBuilder stringBuffer = new StringBuilder();
              while (cur.moveToNext()) {
                stringBuffer.append("id: ").append(cur.getString(0)).append("\n");
                stringBuffer.append("name: ").append(cur.getString(1)).append("\n");
                stringBuffer.append("score: ").append(cur.getString(2)).append("\n");
                stringBuffer.append("time: ").append(cur.getString(3)).append("\n");
                stringBuffer.append("Moves Left: ").append(cur.getString(4)).append("\n\n");
              }
              showMessage("DATA FOUND", stringBuffer.toString());
            }
          }
        });
  }

  public void showMessage(String message, String data) {
    AlertDialog.Builder alert = new AlertDialog.Builder(this);
    alert.setCancelable(true);
    alert.setTitle(message);
    alert.setMessage(data);
    alert.show();
  }
}
