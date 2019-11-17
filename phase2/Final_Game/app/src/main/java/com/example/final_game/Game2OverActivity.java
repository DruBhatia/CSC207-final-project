package com.example.final_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Game2OverActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game2_over);
    String showMoves2 = getIntent().getExtras().get("Moves Left2").toString();
    String showMoves3 = getIntent().getExtras().get("Moves Left3").toString();
    String cardsLeft1 = getIntent().getExtras().get("Cards Left1").toString();
    String cardsLeft2 = getIntent().getExtras().get("Cards Left2").toString();
    String cardsLeft3 = getIntent().getExtras().get("Cards Left3").toString();
    String game_time1 = getIntent().getExtras().get("time1").toString();
    String score1 = getIntent().getExtras().get("points1").toString();
    String game_time2 = getIntent().getExtras().get("time2").toString();
    String score2 = getIntent().getExtras().get("points2").toString();
    String game_time3 = getIntent().getExtras().get("time3").toString();
    String score3 = getIntent().getExtras().get("points3").toString();

    Button mainMenu = findViewById(R.id.main);
    Button restart = findViewById(R.id.playAgain);
    TextView gameStatus1 = findViewById(R.id.status1);
    TextView gameTime1 = findViewById(R.id.time1);
    TextView finalScore1 = findViewById(R.id.score1);
    TextView movesLeft2 = findViewById(R.id.moves_left2);
    TextView gameStatus2 = findViewById(R.id.status2);
    TextView gameTime2 = findViewById(R.id.time2);
    TextView finalScore2 = findViewById(R.id.score2);
    TextView movesLeft3 = findViewById(R.id.moves_left3);
    TextView gameStatus3 = findViewById(R.id.status3);
    TextView gameTime3 = findViewById(R.id.time3);
    TextView finalScore3 = findViewById(R.id.score3);
    restart.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent1 = new Intent(Game2OverActivity.this, MemoryBegin.class);
            startActivity(intent1);
          }
        });

    mainMenu.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent3 = new Intent(Game2OverActivity.this, Main1Activity.class);
            startActivity(intent3);
          }
        });
    if ((cardsLeft2.equals("NO"))) {
      gameStatus2.setText("YOU WON!!");
    } else if (cardsLeft2.equals("YES") && showMoves2.equals("0")) {
      gameStatus2.setText("YOU LOST :(");
    }
    if ((cardsLeft3.equals("NO"))) {
      gameStatus3.setText("YOU WON!!");
    } else if (cardsLeft3.equals("YES") && showMoves3.equals("0")) {
      gameStatus3.setText("YOU LOST :(");
    }
    if ((cardsLeft1.equals("NO"))) {
      gameStatus1.setText("YOU WON!!");
    } else {
      gameStatus1.setText("YOU LOST :(");
    }
    gameTime1.setText("TIME: " + game_time1 + "s");
    finalScore1.setText("FINAL SCORE: " + score1);
    movesLeft2.setText("MOVES LEFT: " + showMoves2);
    gameTime2.setText("TIME: " + game_time2 + "s");
    finalScore2.setText("FINAL SCORE: " + score2);
    movesLeft3.setText("MOVES LEFT: " + showMoves3);
    gameTime3.setText("TIME LEFT: " + game_time3 + "s");
    finalScore3.setText("FINAL SCORE: " + score3);
  }
}
