package com.example.final_game.Memorize;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final_game.R;

import java.util.List;


@SuppressLint("ViewConstructor")
public class MemoryView extends View {
  int[] light_images = {
    R.drawable.fv_image101,
    R.drawable.fv_image102,
    R.drawable.fv_image103,
    R.drawable.fv_image104,
    R.drawable.fv_image105,
    R.drawable.fv_image106,
    R.drawable.fv_image107,
    R.drawable.fv_image108
  };
  int[] dark_images = {
    R.drawable.fv_image1d1,
    R.drawable.fv_image1d2,
    R.drawable.fv_image1d3,
    R.drawable.fv_image1d4,
    R.drawable.fv_image1d5,
    R.drawable.fv_image1d6,
    R.drawable.fv_image1d7,
    R.drawable.fv_image1d8
  };
  MemoryPresenter presenter;
  /**
   * Constructor initializes a new player, a layout of playable, shuffled cards, sets off a timer,
   * and adds clickable functionality to the cards in the layout.
   */
  MemoryView(AppCompatActivity context, String theme, int num) {
    super(context);
    presenter = new MemoryPresenter(context, theme, num);
    if (theme.equals("L")) {
      presenter.initializeImages(light_images, R.drawable.bv_00);
    } else if (theme.equals("D")) {
      presenter.initializeImages(dark_images, R.drawable.bv_01);
    }
    presenter.show();
    presenter.setTimer();
    setOnClick();
  }

  /** Set an on click listener on the image view of all the cards in cardArray */
  // https://developer.android.com/reference/android/view/View.OnClickListener used to learn.
  void setOnClick() {
    final MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.cardflipsound);
    List<PlayingCard> cardArray = presenter.getCardArray();
    for (final PlayingCard card : cardArray) {
      card.getImageView()
          .setOnClickListener(
              new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  mediaPlayer.start();
                  presenter.setSelection(card);
                }
              });
    }
  }
}
