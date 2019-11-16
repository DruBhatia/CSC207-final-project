package com.example.final_game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressLint("ViewConstructor")
public class MemoryView extends View {
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
  /** The back image of all the cards */
  int cardBackView;
  AppCompatActivity cntxt;

  /**
   * Constructor initializes a new player, a layout of playable, shuffled cards, sets off a timer,
   * and adds clickable functionality to the cards in the layout.
   */
  MemoryView(AppCompatActivity context, String theme, MemorizePlayer plyr) {
    super(context);
    cntxt = context;
    player = plyr;
    this.initializeCardArray(context);
    if (theme.equals("L")) {
      initializeImages("L");
      cardBackView = R.drawable.bv_00;
    } else if (theme.equals("D")) {
      initializeImages("D");
      cardBackView = R.drawable.bv_01;
    }
    show();
    player.getChronometer().setBase(SystemClock.elapsedRealtime());
    player.getChronometer().start();
    setOnClick();
  }

  void initializeCardArray(AppCompatActivity context) {
    cardArray = new ArrayList<>();
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_11)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_12)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_13)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_14)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_21)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_22)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_23)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_24)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_31)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_32)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_33)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_34)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_41)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_42)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_43)));
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_44)));
  }

  /** Initialize + shuffle an array of card placeholders corresponding to respective card images. */
  void initializeImages(String theme) {
    imageArray = new ArrayList<>();
    if (theme.equals("L")) {
      int[] arr1 = new int[] {101, R.drawable.fv_image101};
      imageArray.add(arr1);
      int[] arr2 = new int[] {102, R.drawable.fv_image102};
      imageArray.add(arr2);
      int[] arr3 = new int[] {103, R.drawable.fv_image103};
      imageArray.add(arr3);
      int[] arr4 = new int[] {104, R.drawable.fv_image104};
      imageArray.add(arr4);
      int[] arr5 = new int[] {105, R.drawable.fv_image105};
      imageArray.add(arr5);
      int[] arr6 = new int[] {106, R.drawable.fv_image106};
      imageArray.add(arr6);
      int[] arr7 = new int[] {107, R.drawable.fv_image107};
      imageArray.add(arr7);
      int[] arr8 = new int[] {108, R.drawable.fv_image108};
      imageArray.add(arr8);
      int[] arr9 = new int[] {201, R.drawable.fv_image101};
      imageArray.add(arr9);
      int[] arr10 = new int[] {202, R.drawable.fv_image102};
      imageArray.add(arr10);
      int[] arr11 = new int[] {203, R.drawable.fv_image103};
      imageArray.add(arr11);
      int[] arr12 = new int[] {204, R.drawable.fv_image104};
      imageArray.add(arr12);
      int[] arr13 = new int[] {205, R.drawable.fv_image105};
      imageArray.add(arr13);
      int[] arr14 = new int[] {206, R.drawable.fv_image106};
      imageArray.add(arr14);
      int[] arr15 = new int[] {207, R.drawable.fv_image107};
      imageArray.add(arr15);
      int[] arr16 = new int[] {208, R.drawable.fv_image108};
      imageArray.add(arr16);
    } else {
      int[] arr1 = new int[] {101, R.drawable.fv_image1d1};
      imageArray.add(arr1);
      int[] arr2 = new int[] {102, R.drawable.fv_image1d2};
      imageArray.add(arr2);
      int[] arr3 = new int[] {103, R.drawable.fv_image1d3};
      imageArray.add(arr3);
      int[] arr4 = new int[] {104, R.drawable.fv_image1d4};
      imageArray.add(arr4);
      int[] arr5 = new int[] {105, R.drawable.fv_image1d5};
      imageArray.add(arr5);
      int[] arr6 = new int[] {106, R.drawable.fv_image1d6};
      imageArray.add(arr6);
      int[] arr7 = new int[] {107, R.drawable.fv_image1d7};
      imageArray.add(arr7);
      int[] arr8 = new int[] {108, R.drawable.fv_image1d8};
      imageArray.add(arr8);
      int[] arr9 = new int[] {201, R.drawable.fv_image1d1};
      imageArray.add(arr9);
      int[] arr10 = new int[] {202, R.drawable.fv_image1d2};
      imageArray.add(arr10);
      int[] arr11 = new int[] {203, R.drawable.fv_image1d3};
      imageArray.add(arr11);
      int[] arr12 = new int[] {204, R.drawable.fv_image1d4};
      imageArray.add(arr12);
      int[] arr13 = new int[] {205, R.drawable.fv_image1d5};
      imageArray.add(arr13);
      int[] arr14 = new int[] {206, R.drawable.fv_image1d6};
      imageArray.add(arr14);
      int[] arr15 = new int[] {207, R.drawable.fv_image1d7};
      imageArray.add(arr15);
      int[] arr16 = new int[] {208, R.drawable.fv_image1d8};
      imageArray.add(arr16);
    }
    Collections.shuffle(imageArray);
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

  /** Show the cards to the player for a few seconds, then flip them over and make them playable. */
  void show() {
    for (PlayingCard playCard : cardArray) {
      playCard.set_enable(false);
    }
    for (PlayingCard playCard : cardArray) {
      int image = imageArray.get(cardArray.indexOf(playCard))[1];
      playCard.setImage(image);
    }
    Handler handler = new Handler();
    handler.postDelayed(
        new Runnable() {
          @Override
          public void run() {
            for (PlayingCard playCard : cardArray) {
              playCard.setImage(cardBackView);
            }
            for (PlayingCard playCard : cardArray) {
              playCard.set_enable(true);
            }
          }
        },
        2500);
  }

  /**
   * Temporarily stores selected cards and makes them unresponsive until all selections have been
   * made so a comparison can be performed.
   */
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

  /**
   * Compare selected cards to see if they match and adjust player's points and the selected cards'
   * visibility in the layout accordingly.
   */
  private void compare() {
    // If card matches make them invisible
    if (firstCard == secondCard) {
      cardArray.get(firstSelect).setVisibility();
      cardArray.get(secondSelect).setVisibility();
      // Increase the points by 2 for correct match
      player.increasePlayerPoints();
      player.setTextPoints();
    } else {
      // Decrease the points by 1 for incorrect match
      player.decreasePlayerPoints();
      player.setTextPoints();
      // Load back the front images again if
      for (PlayingCard card : cardArray) {
        card.setImage(cardBackView);
      }
    }
    player.decreasePlayerMoves();
    player.setTextMoves();
    // Make all cards responsive again
    for (PlayingCard card : cardArray) {
      card.set_enable(true);
    }
    endGame(checkEnd());
  }

  /** Return whether or not all cards on screen are invisible. */
  boolean checkVisibility() {
    for (PlayingCard item : cardArray) {
      if (item.getVisibility() != View.INVISIBLE) {
        return false;
      }
    }
    return true;
  }

  /** Check if end-game conditions have been met. */
  protected boolean checkEnd() {
    return player.getMovesLeft() == 0 || checkVisibility();
  }

  /**
   * End game if all end-game conditions have been met, track player stats, and navigate to
   * game-over screen.
   */
  protected void endGame(boolean check) {
    int playerMoves = player.getMovesLeft();
    int playerPoints = player.getPlayerPoints();
    boolean bool = checkVisibility();
    if (check) {
      CharSequence elapsedMillis = player.getChronometer().getText();
      player.getChronometer().stop();
      Intent intent = new Intent(getContext(), Game2OverActivity.class);
      intent.putExtra("Moves Left", playerMoves);
      intent.putExtra("time", elapsedMillis);
      intent.putExtra("points", playerPoints);
      if (bool) {
        intent.putExtra("Cards Left To Match?", "NO");
      } else {
        intent.putExtra("Cards Left To Match?", "YES");
      }
      getContext().startActivity(intent);
    }
  }
}
