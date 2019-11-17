package com.example.final_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/** Views the Game over Page, once game is completed. */
public class GameOverActivity extends Main1Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_game_over);

    Button mainMenu = findViewById(R.id.all_games);

    String showScore = getIntent().getExtras().get("Score").toString();
    String showTime = getIntent().getExtras().get("Time").toString();

    Button rePlayGame = findViewById(R.id.play_again);

    TextView score = findViewById(R.id.score_id);
    TextView time = findViewById(R.id.time_id);

    rePlayGame.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent2 = new Intent(GameOverActivity.this, Main3Activity.class);
            startActivity(intent2);
          }
        });

    mainMenu.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent3 = new Intent(GameOverActivity.this, Main1Activity.class);
            startActivity(intent3);
          }
        });

    score.setText("Score: " + showScore);
    time.setText("Time taken: " + showTime + " s");
    gameDb.insertData("GAME2STATS", username, showScore, showTime, "nothing");
  }
}
