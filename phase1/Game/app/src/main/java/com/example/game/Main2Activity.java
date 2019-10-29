package com.example.game;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
  /** Array List of all cards displayed on the screen */
  List<PlayingCard> cardArray;
  /** Array List of all card images displayed on the screen */
  List<int[]> imageArray;
  /** Player of the Game */
  MemorizePlayer player;
  /** First and Second selected indexes of the cardArray */
  int firstSelect, secondSelect;
  /** Denotes which number of the card selected */
  int firstCard, secondCard;
  /** Denotes which card is being selected (Whether its the first card selection or second) */
  int cardNum = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_memorygame);

    player = new MemorizePlayer((TextView) findViewById(R.id.textView1));
    cardArray = new ArrayList<>();
    imageArray = new ArrayList<>();
    cardArray.add(new PlayingCard(11, (ImageView) findViewById(R.id.iv_11)));
    int[] arr1 = new int[] {101, R.drawable.fv_image101};
    imageArray.add(arr1);
    cardArray.add(new PlayingCard(12, (ImageView) findViewById(R.id.iv_12)));
    int[] arr2 = new int[] {102, R.drawable.fv_image102};
    imageArray.add(arr2);
    cardArray.add(new PlayingCard(13, (ImageView) findViewById(R.id.iv_13)));
    int[] arr3 = new int[] {103, R.drawable.fv_image103};
    imageArray.add(arr3);
    cardArray.add(new PlayingCard(14, (ImageView) findViewById(R.id.iv_14)));
    int[] arr4 = new int[] {104, R.drawable.fv_image104};
    imageArray.add(arr4);
    cardArray.add(new PlayingCard(15, (ImageView) findViewById(R.id.iv_21)));
    int[] arr5 = new int[] {105, R.drawable.fv_image105};
    imageArray.add(arr5);
    cardArray.add(new PlayingCard(16, (ImageView) findViewById(R.id.iv_22)));
    int[] arr6 = new int[] {106, R.drawable.fv_image106};
    imageArray.add(arr6);
    cardArray.add(new PlayingCard(17, (ImageView) findViewById(R.id.iv_23)));
    int[] arr7 = new int[] {107, R.drawable.fv_image107};
    imageArray.add(arr7);
    cardArray.add(new PlayingCard(18, (ImageView) findViewById(R.id.iv_24)));
    int[] arr8 = new int[] {108, R.drawable.fv_image108};
    imageArray.add(arr8);
    cardArray.add(new PlayingCard(21, (ImageView) findViewById(R.id.iv_31)));
    int[] arr9 = new int[] {201, R.drawable.fv_image201};
    imageArray.add(arr9);
    cardArray.add(new PlayingCard(22, (ImageView) findViewById(R.id.iv_32)));
    int[] arr10 = new int[] {202, R.drawable.fv_image202};
    imageArray.add(arr10);
    cardArray.add(new PlayingCard(23, (ImageView) findViewById(R.id.iv_33)));
    int[] arr11 = new int[] {203, R.drawable.fv_image203};
    imageArray.add(arr11);
    cardArray.add(new PlayingCard(24, (ImageView) findViewById(R.id.iv_34)));
    int[] arr12 = new int[] {204, R.drawable.fv_image204};
    imageArray.add(arr12);
    cardArray.add(new PlayingCard(25, (ImageView) findViewById(R.id.iv_41)));
    int[] arr13 = new int[] {205, R.drawable.fv_image205};
    imageArray.add(arr13);
    cardArray.add(new PlayingCard(26, (ImageView) findViewById(R.id.iv_42)));
    int[] arr14 = new int[] {206, R.drawable.fv_image206};
    imageArray.add(arr14);
    cardArray.add(new PlayingCard(27, (ImageView) findViewById(R.id.iv_43)));
    int[] arr15 = new int[] {207, R.drawable.fv_image207};
    imageArray.add(arr15);
    cardArray.add(new PlayingCard(28, (ImageView) findViewById(R.id.iv_44)));
    int[] arr16 = new int[] {208, R.drawable.fv_image208};
    imageArray.add(arr16);

    Collections.shuffle(imageArray);
    this.setOnClick();
  }
  /** Set an on click listener on the image view of all the cards in cardArray */
  // https://developer.android.com/reference/android/view/View.OnClickListener used to learn.
  void setOnClick() {
    for (final PlayingCard card : cardArray) {
      card.getImageview()
          .setOnClickListener(
              new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  setSelection(card);
                }
              });
    }
  }

  private void setSelection(PlayingCard c) {
    // Set the image of card to the image view
    int image = imageArray.get(cardArray.indexOf(c))[1];
    c.setImage(image);
    // check the selection of two cards and store them temporarily
    if (cardNum == 1) {
      firstCard = imageArray.get(cardArray.indexOf(c))[0];
      if (firstCard > 200) {
        firstCard = firstCard - 100;
      }
      cardNum = 2;
      firstSelect = this.cardArray.indexOf(c);
      // Make this card unresponsive
      c.set_enable(false);

    } else {
      secondCard = imageArray.get(cardArray.indexOf(c))[0];
      if (secondCard > 200) {
        secondCard = secondCard - 100;
      }
      cardNum = 1;
      secondSelect = this.cardArray.indexOf(c);
      // Make all cards unresponsive
      for (PlayingCard playCard : cardArray) {
        playCard.set_enable(false);
      }
      // https://developer.android.com/reference/android/os/Handler.html &
      // https://stackoverflow.com/questions/15136199/when-to-use-handler-post-when-to-new-thread
      // After selecting the two cards delay the game by 100 milliseconds to check whether the two
      // cards match or not and proceed ahead.
      Handler handler = new Handler();
      handler.postDelayed(
          new Runnable() {
            @Override
            public void run() {
              compare();
            }
          },
          400);
    }
  }

  private void compare() {
    // If card matches make them invisible
    if (firstCard == secondCard) {
      cardArray.get(firstSelect).setVisibility();
      cardArray.get(secondSelect).setVisibility();
      // Increase the points for correct match
      player.increasePointsEarned();
      player.setTextPoints();
    } else {
      // Load back the front images again if
      for (PlayingCard card : cardArray) {
        card.setImage(R.drawable.bv_00);
      }
    }
    // Make all cards responsive again
    for (PlayingCard card : cardArray) {
      card.set_enable(true);
    }
    endGame(checkEnd());
  }

  private boolean checkEnd() {
    for (PlayingCard item : cardArray) {
      if (item.getVisibility() != View.INVISIBLE) {
        return false;
      }
    }
    return true;
  }

  private void endGame(boolean check) {
    int playerPoints = player.getPointsEarned();
    if (check) {
      // Display a message indicating the game has ended, the total points of participating players,
      // and an option to return to the game menu or home screen.
        AlertDialog.Builder alertDialogBuild = new AlertDialog.Builder(Main2Activity.this);
        alertDialogBuild.setMessage("Game Over: " + playerPoints);
        alertDialogBuild.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuild.create();
        alertDialog.show();
    }
  }

}
