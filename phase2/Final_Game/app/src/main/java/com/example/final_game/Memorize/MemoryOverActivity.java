package com.example.final_game.Memorize;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.final_game.Infrastructure.Main1Activity;
import com.example.final_game.R;

import static com.example.final_game.Memorize.MemoryView.CARDS_LEFT2;
import static com.example.final_game.Memorize.MemoryView.CARDS_LEFT3;
import static com.example.final_game.Memorize.MemoryView.MOVES_LEFT2;
import static com.example.final_game.Memorize.MemoryView.MOVES_LEFT3;
import static com.example.final_game.Memorize.MemoryView.POINTS1;
import static com.example.final_game.Memorize.MemoryView.POINTS2;
import static com.example.final_game.Memorize.MemoryView.POINTS3;
import static com.example.final_game.Memorize.MemoryView.SHARED_PREFS;
import static com.example.final_game.Memorize.MemoryView.TIME1;
import static com.example.final_game.Memorize.MemoryView.TIME2;
import static com.example.final_game.Memorize.MemoryView.TIME3;

public class MemoryOverActivity extends Main1Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game2_over);
    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
    String showMoves2 = sharedPreferences.getString(MOVES_LEFT2, "15");
    String showMoves3 = sharedPreferences.getString(MOVES_LEFT3, "15");
    String cardsLeft2 = sharedPreferences.getString(CARDS_LEFT2, "YES");
    String cardsLeft3 = sharedPreferences.getString(CARDS_LEFT3, "YES");
    String game_time1 = sharedPreferences.getString(TIME1, "00:00");
    String score1 = sharedPreferences.getString(POINTS1, "0");
    String game_time2 = sharedPreferences.getString(TIME2, "00:00");
    String score2 = sharedPreferences.getString(POINTS2, "0");
    String game_time3 = sharedPreferences.getString(TIME3, "01:00");
    String score3 = sharedPreferences.getString(POINTS3, "0");

    Button mainMenu = findViewById(R.id.main);
    Button restart = findViewById(R.id.playAgain);
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
            Intent intent1 = new Intent(MemoryOverActivity.this, MemoryBegin.class);
            startActivity(intent1);
          }
        });

    mainMenu.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent3 = new Intent(MemoryOverActivity.this, Main1Activity.class);
            startActivity(intent3);
          }
        });
    if ((cardsLeft2.equals("NO"))) {
      gameStatus2.setText("YOU WON!!");
    } else {
      gameStatus2.setText("YOU LOST :(");
    }
    if ((cardsLeft3.equals("NO"))) {
      gameStatus3.setText("YOU WON!!");
    } else {
      gameStatus3.setText("YOU LOST :(");
    }
    gameTime1.setText("TIME:" + game_time1 + "s");
    finalScore1.setText("FINAL SCORE:" + score1);
    movesLeft2.setText("MOVES LEFT:" + showMoves2);
    gameTime2.setText("TIME:" + game_time2 + "s");
    finalScore2.setText("FINAL SCORE:" + score2);
    movesLeft3.setText("MOVES LEFT:" + showMoves3);
    gameTime3.setText("TIME LEFT:" + game_time3 + "s");
    finalScore3.setText("FINAL SCORE:" + score3);
    gameDb.insertData("GAME1STATS", username, score3, game_time3, showMoves3);
  }
}
