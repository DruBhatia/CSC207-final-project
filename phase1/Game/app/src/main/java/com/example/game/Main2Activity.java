package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Main2Activity extends AppCompatActivity {
  MemoryView game_view;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_memorygame);
    game_view = new MemoryView(this);

  }
  private void endGame(boolean check) {
    if (check) {
      // Display a message indicating the game has ended, the total points of participating players,
      // and an option to return to the game menu or home screen.
      AlertDialog.Builder alertDialogBuild = new AlertDialog.Builder(Main2Activity.this);
      if (game_view.checkVisibility() && game_view.player.getMovesLeft() >= 0) {
        alertDialogBuild.setMessage("Game Over: YOU WON!!");
      }
      else if (!game_view.checkVisibility() && game_view.player.getMovesLeft() == 0) {
        alertDialogBuild.setMessage("Game Over: YOU LOSE!!");
      }
      alertDialogBuild.setCancelable(false);
      alertDialogBuild
          .setPositiveButton(
              "Restart",
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                  startActivity(intent);
                  finish();
                }
              })
          .setNegativeButton(
              "MAIN MENU",
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                  startActivity(intent);
                  finish();
                }
              });
      AlertDialog alertDialog = alertDialogBuild.create();
      alertDialog.show();
    }
  }
}
