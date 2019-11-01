package com.example.game;

import android.annotation.SuppressLint;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

@SuppressLint("ViewConstructor")
public class MemoryView2 extends MemoryView {

  /**
   * Constructor initializes a new player, a layout of playable, shuffled cards, sets off a timer,
   * and adds clickable functionality to the cards in the layout.
   */
  MemoryView2(AppCompatActivity context) {
    super(context);
    this.cardBackView = R.drawable.bv_01;
  }

  /** Different set of cards is used in this theme.*/
  @Override
  void initializeCards(AppCompatActivity context) {
    cardArray = new ArrayList<>();
    imageArray = new ArrayList<>();
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_11)));
    int[] arr1 = new int[] {101, R.drawable.fv_image1d1};
    imageArray.add(arr1);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_12)));
    int[] arr2 = new int[] {102, R.drawable.fv_image1d2};
    imageArray.add(arr2);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_13)));
    int[] arr3 = new int[] {103, R.drawable.fv_image1d3};
    imageArray.add(arr3);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_14)));
    int[] arr4 = new int[] {104, R.drawable.fv_image1d4};
    imageArray.add(arr4);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_21)));
    int[] arr5 = new int[] {105, R.drawable.fv_image1d5};
    imageArray.add(arr5);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_22)));
    int[] arr6 = new int[] {106, R.drawable.fv_image1d6};
    imageArray.add(arr6);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_23)));
    int[] arr7 = new int[] {107, R.drawable.fv_image1d7};
    imageArray.add(arr7);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_24)));
    int[] arr8 = new int[] {108, R.drawable.fv_image1d8};
    imageArray.add(arr8);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_31)));
    int[] arr9 = new int[] {201, R.drawable.fv_image1d1};
    imageArray.add(arr9);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_32)));
    int[] arr10 = new int[] {202, R.drawable.fv_image1d2};
    imageArray.add(arr10);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_33)));
    int[] arr11 = new int[] {203, R.drawable.fv_image1d3};
    imageArray.add(arr11);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_34)));
    int[] arr12 = new int[] {204, R.drawable.fv_image1d4};
    imageArray.add(arr12);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_41)));
    int[] arr13 = new int[] {205, R.drawable.fv_image1d5};
    imageArray.add(arr13);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_42)));
    int[] arr14 = new int[] {206, R.drawable.fv_image1d6};
    imageArray.add(arr14);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_43)));
    int[] arr15 = new int[] {207, R.drawable.fv_image1d7};
    imageArray.add(arr15);
    cardArray.add(new PlayingCard((ImageView) context.findViewById(R.id.iv_44)));
    int[] arr16 = new int[] {208, R.drawable.fv_image1d8};
    imageArray.add(arr16);
    Collections.shuffle(imageArray);
  }
}
