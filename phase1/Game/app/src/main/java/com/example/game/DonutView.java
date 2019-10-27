package com.example.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class DonutView extends SurfaceView implements SurfaceHolder.Callback {

    private Bitmap Donut;

    private Bitmap Ant;


    public DonutView(Context context) {
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
        Donut = BitmapFactory.decodeResource(getResources(), R.drawable.donut);

        Ant = BitmapFactory.decodeResource(getResources(), R.drawable.ant);
    }

    public void update(Canvas canvas) {
        //need to add this method in the Ant class.
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

}
