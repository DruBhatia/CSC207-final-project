package com.example.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class DonutView extends View {

    private Bitmap Donut;

    private Bitmap Ants;

    public DonutView(Context context) {
        super(context);
        Donut = BitmapFactory.decodeResource(getResources(), R.drawable.donut);

        Ants = BitmapFactory.decodeResource(getResources(), R.drawable.ant);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(Donut, 300, 600, null);

        canvas.drawBitmap(Ants, 100, 1600, null);

        canvas.drawBitmap(Ants, 800, 1600, null);

        canvas.drawBitmap(Ants, 100, 0, null);

        canvas.drawBitmap(Ants, 800, 0, null);

    }
}
