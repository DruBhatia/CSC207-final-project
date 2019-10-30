package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;

public class Game2OverActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game2_over);
    int showMoves = (int) Objects.requireNonNull(getIntent().getExtras()).get("Moves Left");
    boolean cardsLeft =
        (boolean) Objects.requireNonNull(getIntent().getExtras()).get("Cards Left to Match");

  }
}
