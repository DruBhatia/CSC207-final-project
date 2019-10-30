package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

public class Game2OverActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game2_over);
    int showMoves = (int) Objects.requireNonNull(getIntent().getExtras()).get("Moves Left");
    boolean cardsLeft =
        (boolean) Objects.requireNonNull(getIntent().getExtras()).get("Cards Left to Match");

    Button mainMenu = findViewById(R.id.main);
    Button restart = findViewById(R.id.playAgain);
    TextView gameStatus = findViewById(R.id.status);
    TextView movesLeft = findViewById(R.id.moves_left);

      restart.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent1 = new Intent(Game2OverActivity.this, MemoryBegin.class);
              startActivity(intent1);
          }
      });

      mainMenu.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent3 = new Intent(Game2OverActivity.this, MainActivity.class);
              startActivity(intent3);
          }
      });
      if (cardsLeft && showMoves >= 0) {
          gameStatus.setText("YOU WON");
      }
      else if (!cardsLeft && showMoves == 0) {
          gameStatus.setText("YOU LOST :(");
      }

          movesLeft.setText("Moves Left: " + showMoves);




  }
}
