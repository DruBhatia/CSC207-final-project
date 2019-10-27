package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {

    private DonutView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new DonutView(this);
        setContentView(gameView);

//        setContentView(R.layout.activity_main3);

    }
}
