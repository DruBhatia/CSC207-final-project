package com.example.game;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MemoryView extends View {
  /** Array List of all cards displayed on the screen */
  List<PlayingCard> cardArray;
  /** Array List of all card images displayed on the screen */
  List<Integer> imageArray;
  /** Player of the Game */
  MemorizePlayer player;
  /** First and Second selected indexes of the cardArray */
  int firstSelect, secondSelect;
  /** Denotes which number of the card selected */
  int firstCard, secondCard;
  /** Denotes which card is being selected (Whether its the first card selection or second) */
  int cardNum = 1;

  MemoryView(Context context) {
    super(context);
    player = new MemorizePlayer((TextView) findViewById(R.id.textView1));
    cardArray = new ArrayList<>();
    imageArray = new ArrayList<>();
    cardArray.add(new PlayingCard(101, (ImageView) findViewById(R.id.iv_11)));
    imageArray.add(R.drawable.fv_image101);
    cardArray.add(new PlayingCard(102, (ImageView) findViewById(R.id.iv_12)));
    imageArray.add(R.drawable.fv_image102);
    cardArray.add(new PlayingCard(103, (ImageView) findViewById(R.id.iv_13)));
    imageArray.add(R.drawable.fv_image103);
    cardArray.add(new PlayingCard(14, (ImageView) findViewById(R.id.iv_14)));
    imageArray.add(R.drawable.fv_image104);
    cardArray.add(new PlayingCard(15, (ImageView) findViewById(R.id.iv_21)));
    imageArray.add(R.drawable.fv_image105);
    cardArray.add(new PlayingCard(16, (ImageView) findViewById(R.id.iv_22)));
    imageArray.add(R.drawable.fv_image106);
    cardArray.add(new PlayingCard(17, (ImageView) findViewById(R.id.iv_23)));
    imageArray.add(R.drawable.fv_image107);
    cardArray.add(new PlayingCard(18, (ImageView) findViewById(R.id.iv_24)));
    imageArray.add(R.drawable.fv_image108);
    cardArray.add(new PlayingCard(21, (ImageView) findViewById(R.id.iv_31)));
    imageArray.add(R.drawable.fv_image201);
    cardArray.add(new PlayingCard(22, (ImageView) findViewById(R.id.iv_32)));
    imageArray.add(R.drawable.fv_image202);
    cardArray.add(new PlayingCard(23, (ImageView) findViewById(R.id.iv_33)));
    imageArray.add(R.drawable.fv_image203);
    cardArray.add(new PlayingCard(24, (ImageView) findViewById(R.id.iv_34)));
    imageArray.add(R.drawable.fv_image204);
    cardArray.add(new PlayingCard(25, (ImageView) findViewById(R.id.iv_41)));
    imageArray.add(R.drawable.fv_image205);
    cardArray.add(new PlayingCard(26, (ImageView) findViewById(R.id.iv_42)));
    imageArray.add(R.drawable.fv_image206);
    cardArray.add(new PlayingCard(27, (ImageView) findViewById(R.id.iv_43)));
    imageArray.add(R.drawable.fv_image207);
    cardArray.add(new PlayingCard(28, (ImageView) findViewById(R.id.iv_44)));
    imageArray.add(R.drawable.fv_image208);


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
      int image = imageArray.get(cardArray.indexOf(c));
    c.setImage(image);
    // check the selection of two cards and store them temporarily
    if (cardNum == 1) {
      firstCard = c.getCardNum();
      if (firstCard > 20) {
        firstCard = firstCard - 10;
      }
      cardNum = 2;
      firstSelect = this.cardArray.indexOf(c);
      // Make this card unresponsive
      c.set_enable(false);

    } else {
      secondCard = c.getCardNum();
      if (secondCard > 20) {
        secondCard = secondCard - 10;
      }
      cardNum = 1;
      secondSelect = this.cardArray.indexOf(c);
      // Make all cards unresponsive
      for (PlayingCard playCard : cardArray) {
        playCard.set_enable(false);
      }
      // https://developer.android.com/reference/android/os/Handler.html &
      // https://stackoverflow.com/questions/15136199/when-to-use-handler-post-when-to-new-thread
      // After selecting the two cards delay the game by 1000 millisecond to check whether the two
      // cards match or not and proceed ahead.
      Handler handler = new Handler();
      handler.postDelayed(
          new Runnable() {
            @Override
            public void run() {
              compare();
            }
          },
          1000);
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
  }
}
