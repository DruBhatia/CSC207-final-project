package com.example.final_game.Infrastructure;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.final_game.R;
import com.example.final_game.ui.login.MainActivity;

public class LeaderboardActivity extends AppCompatActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_leaderboard);

    Button sortByScore1 = findViewById(R.id.button1);
    Button sortByScore2 = findViewById(R.id.button4);
    Button sortByScore3 = findViewById(R.id.button6);
    Button sortByName1 = findViewById(R.id.button2);
    Button sortByName2 = findViewById(R.id.button5);
    Button sortByName3 = findViewById(R.id.button7);
    Button sortByMoves1 = findViewById(R.id.button3);
    Button sortByLevel1 = findViewById(R.id.button8);

    sortByName1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Cursor cur = MainActivity.getGameDb().getDataByName("GAME1STATS");
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
                stringBuffer.append("stat3: ").append(cur.getString(4)).append("\n\n");
              }
              showMessage("DATA FOUND", stringBuffer.toString());
            }
          }
        });

    sortByName2.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Cursor cur = MainActivity.getGameDb().getDataByName("GAME2STATS");
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
                stringBuffer.append("stat3: ").append(cur.getString(4)).append("\n\n");
              }
              showMessage("DATA FOUND", stringBuffer.toString());
            }
          }
        });

    sortByName3.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Cursor cur = MainActivity.getGameDb().getDataByName("GAME3STATS");
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
                stringBuffer.append("stat3: ").append(cur.getString(4)).append("\n\n");
              }
              showMessage("DATA FOUND", stringBuffer.toString());
            }
          }
        });

    sortByScore1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Cursor cur = MainActivity.getGameDb().getDataByStat1("GAME1STATS");
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
                stringBuffer.append("stat3: ").append(cur.getString(4)).append("\n\n");
              }
              showMessage("DATA FOUND", stringBuffer.toString());
            }
          }
        });

    sortByScore2.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Cursor cur = MainActivity.getGameDb().getDataByStat1("GAME2STATS");
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
                stringBuffer.append("stat3: ").append(cur.getString(4)).append("\n\n");
              }
              showMessage("DATA FOUND", stringBuffer.toString());
            }
          }
        });

    sortByScore3.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Cursor cur = MainActivity.getGameDb().getDataByStat1("GAME3STATS");
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
                stringBuffer.append("stat3: ").append(cur.getString(4)).append("\n\n");
              }
              showMessage("DATA FOUND", stringBuffer.toString());
            }
          }
        });

    sortByMoves1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Cursor cur = MainActivity.getGameDb().getDataByStat3("GAME1STATS");
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
                stringBuffer.append("stat3: ").append(cur.getString(4)).append("\n\n");
              }
              showMessage("DATA FOUND", stringBuffer.toString());
            }
          }
        });

    sortByLevel1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Cursor cur = MainActivity.getGameDb().getDataByStat3("GAME3STATS");
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
                stringBuffer.append("stat3: ").append(cur.getString(4)).append("\n\n");
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
