package com.example.game;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread{
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    public static Canvas canvas;
    private boolean running;

    public GameThread(SurfaceHolder surfaceHolder, GameView gameView){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        while(running){
            canvas = null;
            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            } catch (Exception e){ e.printStackTrace();
            } finally{
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) { e.printStackTrace(); }
                }
            }
            long now = System.nanoTime();
            long wait = now - startTime;
            try {
                this.sleep(wait);
            } catch(InterruptedException e)  { e.printStackTrace(); }
            startTime = System.nanoTime();
        }
    }
}
