package com.example.game;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MemoryView extends View {
  /** Array List of all cards displayed on the screen */
  List<PlayingCard> cardArray;
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
    cardArray.add(
        new PlayingCard(11, (ImageView) findViewById(R.id.iv_11), R.drawable.fv_image101));
    cardArray.add(
        new PlayingCard(12, (ImageView) findViewById(R.id.iv_12), R.drawable.fv_image102));
    cardArray.add(
        new PlayingCard(13, (ImageView) findViewById(R.id.iv_13), R.drawable.fv_image103));
    cardArray.add(
        new PlayingCard(14, (ImageView) findViewById(R.id.iv_14), R.drawable.fv_image104));
    cardArray.add(
        new PlayingCard(15, (ImageView) findViewById(R.id.iv_21), R.drawable.fv_image105));
    cardArray.add(
        new PlayingCard(16, (ImageView) findViewById(R.id.iv_22), R.drawable.fv_image106));
    cardArray.add(
        new PlayingCard(17, (ImageView) findViewById(R.id.iv_23), R.drawable.fv_image107));
    cardArray.add(
        new PlayingCard(18, (ImageView) findViewById(R.id.iv_24), R.drawable.fv_image108));
    cardArray.add(
        new PlayingCard(21, (ImageView) findViewById(R.id.iv_31), R.drawable.fv_image201));
    cardArray.add(
        new PlayingCard(22, (ImageView) findViewById(R.id.iv_32), R.drawable.fv_image202));
    cardArray.add(
        new PlayingCard(23, (ImageView) findViewById(R.id.iv_33), R.drawable.fv_image203));
    cardArray.add(
        new PlayingCard(24, (ImageView) findViewById(R.id.iv_34), R.drawable.fv_image204));
    cardArray.add(
        /**/
        new PlayingCard(25, (ImageView) findViewById(R.id.iv_41), R.drawable.fv_image205));
    cardArray.add(
        new PlayingCard(26, (ImageView) findViewById(R.id.iv_42), R.drawable.fv_image206));
    cardArray.add(
        new PlayingCard(27, (ImageView) findViewById(R.id.iv_43), R.drawable.fv_image207));
    cardArray.add(
        new PlayingCard(28, (ImageView) findViewById(R.id.iv_44), R.drawable.fv_image208));
    //Load the front view image resources on the cards
    for (PlayingCard card: cardArray) {
      card.setImage();
    }
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
                  // Set the image of card to the image view
                  card.setImage();
                  setSelection(card);
                }
              });
    }
  }

  private void setSelection(PlayingCard c) {
    //check the selection of two cards and store them temporarily
    if (cardNum == 1) {
      firstCard = c.getCardNum();
      if (firstCard > 20) {
        firstCard = firstCard - 10;
      }
      cardNum = 2;
      firstSelect = this.cardArray.indexOf(c);
      //Make this card unresponsive
      c.set_enable(false);

    } else {
      secondCard = c.getCardNum();
      if (secondCard > 20) {
        secondCard = secondCard - 10;
      }
      cardNum = 1;
      secondSelect = this.cardArray.indexOf(c);
      //Make all cards unresponsive
      for (PlayingCard playc : cardArray) {
        playc.set_enable(false);
      }
    }
  }

  private void compare() {
    //If card matches make them invisible
    if (firstCard == secondCard) {
      cardArray.get(firstSelect).setVisibility();
      cardArray.get(secondSelect).setVisibility();
      //Increase the points for correct match
      player.increasePointsEarned();
      player.setTextPoints();
    } else {
      //Load back the front images again if
      for (PlayingCard card: cardArray) {
        card.setImage();
      }
    }
    //Make all cards responsive again
    for (PlayingCard card: cardArray) {
      card.set_enable(true);
    }
  }
}
