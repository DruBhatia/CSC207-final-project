package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MemoryBegin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorybegin);
        ImageButton playMemory = findViewById(R.id.imageButton);

        playMemory.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v){
                Intent intent2 = new Intent(MemoryBegin.this, Main2Activity.class);
                startActivity(intent2);
            }
        });
    }
}
