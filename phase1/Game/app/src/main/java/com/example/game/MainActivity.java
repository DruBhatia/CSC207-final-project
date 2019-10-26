package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void game_Activities(View view){
        Intent intent1 = new Intent(this, Main2Activity.class);
        Intent intent2 = new Intent(this, Main3Activity.class);
        Intent intent3 = new Intent(this, Main4Activity.class);
        if(R.id.button1 == view.getId()) startActivity(intent1);
        else if (R.id.button5 == view.getId()) startActivity(intent2);
        else if (R.id.button6 == view.getId()) startActivity(intent3);
    }

}
