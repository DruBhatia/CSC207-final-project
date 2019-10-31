package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class GameOverActivity extends AppCompatActivity {

    private Button rePlayGame;

    private TextView score;

    private String showScore;

    private Button mainMenu;

    private TextView time;

    private String showTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Reached here");
        setContentView(R.layout.activity_game_over);

        mainMenu = findViewById(R.id.all_games);

        showScore = getIntent().getExtras().get("Score").toString();
        showTime = getIntent().getExtras().get("Time").toString();

        rePlayGame = findViewById(R.id.play_again);

        score = findViewById(R.id.score_id);
        time = findViewById(R.id.time_id);

    rePlayGame.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent2 = new Intent(GameOverActivity.this, Main3Activity.class);
            startActivity(intent2);
        }
    });

    mainMenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent3 = new Intent(GameOverActivity.this, MainActivity.class);
            startActivity(intent3);
        }
    });

    score.setText("Score: " + showScore);
    time.setText("Time taken: "+ showTime + " s");
    }
}
