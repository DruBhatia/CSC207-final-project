package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main3Activity extends AppCompatActivity {

    DonutView gameView;
    public static final String filename = "gameview.sav";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (load() == null) {
            gameView = new DonutView(this);
            setContentView(gameView);
        } else {
            setContentView(load());
            System.out.println("Game Loaded");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        save(gameView);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setContentView(load());
    }

    public static void save(Serializable object) {
        FileOutputStream fos;

        try {
            fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameView load() {
        if (new File(filename).isFile()) {
            FileInputStream fis = null;
            try{
                fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
                GameView loadedGameView = (GameView) ois.readObject();
                ois.close();
                return loadedGameView;
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
