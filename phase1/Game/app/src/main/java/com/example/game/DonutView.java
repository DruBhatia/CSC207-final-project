package com.example.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class DonutView extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread gameThread;
    private AntManager manager;
    Donut donutNew;
    private boolean touch = false;
    private Ant removedAnt;


    public DonutView(Context context) {
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
    }

    public void update() {

        if (touch){
            manager.ants.remove(removedAnt);
            System.out.println(manager.ants.size());
        } else {
          manager.update();
              }
//        manager.update();
//

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

        manager = new AntManager();
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            double buttonX = event.getX();
            double buttonY = event.getY();

            for (int i = 0; i < manager.ants.size(); i++){
                if (manager.ants.get(i).getX() < buttonX && buttonX< manager.ants.get(i).getX() + manager.ants.get(i).getWidth()
                && manager.ants.get(i).getY() < buttonY && buttonY< manager.ants.get(i).getY() + manager.ants.get(i).getHeight()){
                    touch = true;
                    removedAnt = manager.ants.get(i);
                    return true;

                }
            }
            touch = false;
            return false;
        } else {
            touch = false;
            return false;
        }
    }
}

// onTouchEvent.
