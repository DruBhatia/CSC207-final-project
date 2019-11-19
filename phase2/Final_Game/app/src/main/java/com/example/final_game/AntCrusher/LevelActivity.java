package com.example.final_game.AntCrusher;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final_game.R;

public class LevelActivity extends AppCompatActivity {

    Button proceed;

    int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        level = (int) getIntent().getExtras().get("Level");

        TextView text = findViewById(R.id.newLevel);

        text.setText("level " + level + " completed");

//        proceed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent newIntent = new Intent(LevelActivity.this, Main3Activity.class);
//                startActivity(newIntent);
//            }
//        });

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2000);
                    finish();
                }
                catch (Exception e){
                    e.printStackTrace();

                }

            }

        };
        thread.start();
    }




    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
