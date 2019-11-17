package com.example.final_game;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

public class AntCrusherCustomize extends Main1Activity {

    private Button backgroundLight;

    private Button backgroundDark;

    private Button getDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ant_crusher_customize2);

        backgroundLight = findViewById(R.id.light);

        backgroundDark = findViewById(R.id.dark);

        getDatabase = findViewById(R.id.database);

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

        getDatabase.setOnClickListener(
            new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cur = gameDb.getAllData("GAME2STATS");
                if (cur.getCount() == 0) {
                    System.out.println("Error no data found");
                    showMessage("ERROR", "NOTHING FOUND IN DATABASE");
                } else {
                StringBuilder stringBuffer = new StringBuilder();
                while (cur.moveToNext()) {
                    stringBuffer.append("id: " + cur.getString(0) + "\n");
                    stringBuffer.append("name: " + cur.getString(1) + "\n");
                    stringBuffer.append("score: " + cur.getString(2) + "\n");
                    stringBuffer.append("time: " + cur.getString(3) + "\n");
                    stringBuffer.append("stat3: " + cur.getString(4) + "\n\n");

                }
                showMessage("DATA FOUND", stringBuffer.toString());
                }
            }
        });
    }

    public void showMessage(String message, String data){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(true);
        alert.setTitle(message);
        alert.setMessage(data);
        alert.show();
    }
}
