package com.example.game;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MemoryView extends View {
  /**Array List of all cards displayed on the screen*/
  List<PlayingCard> cardArray;
  /** Player of the Game*/
  MemorizePlayer player;
  /** First and Second selected cardNum of the PlayingCard */
  int firstSelect, secondSelect;
  /** Denotes which number of the card selected */
  int firstCard, secondCard;
  /**Denotes which card is being selected (Whether its the first card selection or second)*/
  int cardNum = 1;

  MemoryView(Context context) {
    super(context);
    player = new MemorizePlayer((TextView) findViewById(R.id.textView1));
    cardArray = new ArrayList<>();
    cardArray.add(
            new PlayingCard(101, (ImageView) findViewById(R.id.iv_11), R.drawable.fv_image101));
    cardArray.add(
            new PlayingCard(102, (ImageView) findViewById(R.id.iv_12), R.drawable.fv_image102));
    cardArray.add(
            new PlayingCard(103, (ImageView) findViewById(R.id.iv_13), R.drawable.fv_image103));
    cardArray.add(
            new PlayingCard(104, (ImageView) findViewById(R.id.iv_14), R.drawable.fv_image104));
    cardArray.add(
            new PlayingCard(105, (ImageView) findViewById(R.id.iv_21), R.drawable.fv_image105));
    cardArray.add(
            new PlayingCard(106, (ImageView) findViewById(R.id.iv_22), R.drawable.fv_image106));
    cardArray.add(
            new PlayingCard(107, (ImageView) findViewById(R.id.iv_23), R.drawable.fv_image107));
    cardArray.add(
            new PlayingCard(108, (ImageView) findViewById(R.id.iv_24), R.drawable.fv_image108));
    cardArray.add(
            new PlayingCard(201, (ImageView) findViewById(R.id.iv_31), R.drawable.fv_image201));
    cardArray.add(
            new PlayingCard(202, (ImageView) findViewById(R.id.iv_32), R.drawable.fv_image202));
    cardArray.add(
        new PlayingCard(203, (ImageView) findViewById(R.id.iv_33), R.drawable.fv_image203));
    cardArray.add(
        new PlayingCard(204, (ImageView) findViewById(R.id.iv_34), R.drawable.fv_image204));
    cardArray.add(/**/
        new PlayingCard(205, (ImageView) findViewById(R.id.iv_41), R.drawable.fv_image205));
    cardArray.add(
        new PlayingCard(206, (ImageView) findViewById(R.id.iv_42), R.drawable.fv_image206));
    cardArray.add(
        new PlayingCard(207, (ImageView) findViewById(R.id.iv_43), R.drawable.fv_image207));
    cardArray.add(
        new PlayingCard(208, (ImageView) findViewById(R.id.iv_44), R.drawable.fv_image208));
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
//    if (cardNum = 1) {
//      firstCard =
//    }
    
  }
}
