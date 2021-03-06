package com.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PieChart extends View {
    private static final int RADIUS = (int) Utils.dp2px(150);
    private static final int LENGTH = (int) Utils.dp2px(20);
    private static final int PULLED_OUT_INDEX = 2;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    RectF rectF = new RectF();
    int[] angles = {60, 100, 120, 80};
    int[] colors = {Color.parseColor("#2979FF"),
            Color.parseColor("#C2185B"),
            Color.parseColor("#009688"),
            Color.parseColor("#FF8F00")};

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        rectF.set(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int currenAngle = 0;
        for (int i = 0; i < angles.length; i++) {
            paint.setColor(colors[i]);
            canvas.save();
            if (i == PULLED_OUT_INDEX) {
                canvas.translate((float) Math.cos(Math.toRadians(currenAngle + angles[i] / 2)) * LENGTH,
                        (float) Math.sin(Math.toRadians(currenAngle + angles[i] / 2)) * LENGTH);
            }
            canvas.drawArc(rectF, currenAngle, angles[i], true, paint);
            canvas.restore();
            currenAngle += angles[i];
        }

    }
}
