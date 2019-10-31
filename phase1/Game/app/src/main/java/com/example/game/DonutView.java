package com.example.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.Serializable;

/** DonutView class is the whole surface that is visible to the user while playing the game.*/

public class DonutView extends SurfaceView implements SurfaceHolder.Callback, Serializable {

    /**GameThread manages and time component and starts the game.*/
    private GameThread gameThread;
    /** Manager is responsible for updating and creating the ants.*/
    private AntManager manager;
    /**The surface level view of the game*/
    Donut donutNew;
    /**Boolean to detect a touch on the screen*/
    private boolean touch = false;
    /** The ant that has to be removed as it has been touched.*/
    private Ant removedAnt;
    /**The speed of the initial generation of ants*/
    private int antGenerationSpeed = 10;
    /**The score paint to display the score.*/
    private Paint scorePaint = new Paint();
    /**The score variable that keeps track of current score*/
    private int score;
    private Paint livesPaint = new Paint();
    private int lives = 10;
    /**The background picture for our gameView.*/
    private Bitmap backgroundPicture;
    public static final long serialVersionUID = 1L;

    /**
     * Construct the thread.
     *
     * @param context is the environment of this game.
     */
    public DonutView(Context context) {
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
        score = 0;
    }

    public void update() {
        Bitmap antBitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.ant);
        if (touch){
            manager.ants.remove(removedAnt);
            if (manager.ants.size() < 2) {
                antGenerationSpeed += 2;
                manager.createAnts(antBitmap1,this, antGenerationSpeed);
            }
            System.out.println(manager.ants.size());
        } else {
          manager.update();
        }

        if (lives == 0) {

            gameThread.setRunning(false);

            Intent newGameintent = new Intent(getContext(), GameOverActivity.class);

            newGameintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            newGameintent.putExtra("Score", score);

            getContext().startActivity(newGameintent);

        }
    }

    public void decreaseLife() {
        if (lives - 1 >= 0){
            lives--;
        }

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(-3355444);
        canvas.drawBitmap(backgroundPicture, 0, 0, null);
        scorePaint.setColor(-16776961);
        scorePaint.setTextSize(80);
        scorePaint.setUnderlineText(true);
        canvas.drawText("Score : " + score , 20, 60, scorePaint);
        livesPaint.setColor(-65536);
        livesPaint.setTextSize(70);
        canvas.drawText("Lives Left : " + lives , 500, 60, livesPaint);
        donutNew.draw(canvas);
        manager.draw(canvas);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Bitmap antBitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.ant);


        Bitmap donutBitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.donut);
        donutNew = new Donut(donutBitmap1, this.getWidth()/2 - donutBitmap1.getWidth()/2, 10, this );

        backgroundPicture = BitmapFactory.decodeResource(getResources(), R.drawable.donut_background);

        manager = new AntManager();
        manager.createAnts(antBitmap1, this, antGenerationSpeed);
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
                    score +=  10;
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

    public int getScore(){
        return score;
    }
}
