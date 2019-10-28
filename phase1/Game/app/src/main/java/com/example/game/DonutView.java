package com.example.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class DonutView extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread gameThread;
    private AntManager manager;
    private Donut donutNew;

    public DonutView(Context context) {
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
    }

    public void update() {
        manager.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(-1);
        donutNew.draw(canvas);
        manager.draw(canvas);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Bitmap antBitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.ant);
        Bitmap donutBitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.donut);
        donutNew = new Donut(donutBitmap1, this.getWidth()/2 - donutBitmap1.getWidth()/2, 10, this );

        manager = new AntManager(10);
        manager.createAnts(antBitmap1, this);
        gameThread = new GameThread(this.getHolder(),this);
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while(retry){
            try{
                gameThread.setRunning(false);
                gameThread.join();
            } catch (Exception e) { e.printStackTrace(); }
            retry = false;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

}
