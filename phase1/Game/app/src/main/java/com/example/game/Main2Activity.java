package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MemoryView memorygame = new MemoryView(this);
        setContentView(R.layout.activity_memorygame);
    }
}
