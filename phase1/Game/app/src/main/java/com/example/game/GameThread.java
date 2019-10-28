package com.example.game;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread{
    private SurfaceHolder surfaceHolder;
    private DonutView gameView;
    public static Canvas canvas;
    private boolean running;

    public GameThread(SurfaceHolder surfaceHolder, DonutView gameView){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    @Override
    public void run() {
        while(running){
            canvas = null;
            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                    System.out.print("thread running");
                }
            } catch (Exception e){ e.printStackTrace();
            } finally{
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) { e.printStackTrace(); }
                }
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
