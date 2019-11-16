package com.example.final_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AntCrusherCustomize extends AppCompatActivity {

    private Button backgroundLight;

    private Button backgroundDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ant_crusher_customize2);

        backgroundLight = findViewById(R.id.light);

        backgroundDark = findViewById(R.id.dark);

        backgroundLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int background = R.drawable.donut_background;
                Intent intentNew = new Intent(AntCrusherCustomize.this, Main3Activity.class);

                intentNew.putExtra("background", background);
                startActivity(intentNew);
            }
        });

        backgroundDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int background = R.drawable.background;
                Intent intentNew = new Intent(AntCrusherCustomize.this, Main3Activity.class);

                intentNew.putExtra("background", background);
                startActivity(intentNew);
            }
        });

    }
}
