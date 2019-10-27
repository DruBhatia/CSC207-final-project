package com.example.game;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MemoryView extends View {
    List<PlayingCard> cardArray;
    MemorizePlayer player;

    MemoryView(Context context) {
        super(context);
        player = new MemorizePlayer((TextView) findViewById(R.id.textView1));
        cardArray = new ArrayList<>();
        cardArray.add(new PlayingCard(0, (ImageView) findViewById(R.id.iv_11),
                R.drawable.fv_image101));
        cardArray.add(new PlayingCard(1, (ImageView) findViewById(R.id.iv_12),
                R.drawable.fv_image102));
        cardArray.add(new PlayingCard(2, (ImageView) findViewById(R.id.iv_13),
                R.drawable.fv_image103));
        cardArray.add(new PlayingCard(3, (ImageView) findViewById(R.id.iv_14),
                R.drawable.fv_image104));
        cardArray.add(new PlayingCard(4, (ImageView) findViewById(R.id.iv_21),
                R.drawable.fv_image105));
        cardArray.add(new PlayingCard(5, (ImageView) findViewById(R.id.iv_22),
                R.drawable.fv_image106));
        cardArray.add(new PlayingCard(6, (ImageView) findViewById(R.id.iv_23),
                R.drawable.fv_image107));
        cardArray.add(new PlayingCard(7, (ImageView) findViewById(R.id.iv_24),
                R.drawable.fv_image108));
        cardArray.add(new PlayingCard(8, (ImageView) findViewById(R.id.iv_31),
                R.drawable.fv_image201));
        cardArray.add(new PlayingCard(9, (ImageView) findViewById(R.id.iv_32),
                R.drawable.fv_image202));
        cardArray.add(new PlayingCard(10, (ImageView) findViewById(R.id.iv_33),
                R.drawable.fv_image203));
        cardArray.add(new PlayingCard(11, (ImageView) findViewById(R.id.iv_34),
                R.drawable.fv_image204));
        cardArray.add(new PlayingCard(12, (ImageView) findViewById(R.id.iv_41),
                R.drawable.fv_image205));
        cardArray.add(new PlayingCard(13, (ImageView) findViewById(R.id.iv_42),
                R.drawable.fv_image206));
        cardArray.add(new PlayingCard(14, (ImageView) findViewById(R.id.iv_43),
                R.drawable.fv_image207));
        cardArray.add(new PlayingCard(15, (ImageView) findViewById(R.id.iv_44),
                R.drawable.fv_image208));





    }



}
