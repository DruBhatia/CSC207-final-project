package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;

public class Main3Activity extends AppCompatActivity {



    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DonutView gameView = new DonutView(this);
        FinalView finalView = new FinalView(this, gameView);
        setContentView(gameView);

//        if (gameView.getLives() == 0) {
//            System.out.println("Reached here");
//            setContentView(finalView);
//        } else {
//            System.out.println(" Reached here now" + gameView.getLives());
//            setContentView(gameView);
//        }

//        new CountDownTimer(5000, 100) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//            }
//
//            @Override
//            public void onFinish() {
//                setContentView(finalView);
//            }
//        }.start();
    }
}
