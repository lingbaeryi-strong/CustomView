package com.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class SportsView extends View {

    private static final float RING_WIDTH = Utils.dp2px(20);
    private static final float RADIUS = Utils.dp2px(150);
    private static final int CIRCLE_COLOR = Color.parseColor("#90a4ae");
    private static final int HIGHTLIGHT_COLOR = Color.parseColor("#ff4081");

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Rect rect = new Rect();

    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();

    public SportsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setTextSize(Utils.dp2px(100));
//        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(),""));//字体
        paint.setTextAlign(Paint.Align.CENTER);//横向剧中

        fontMetrics = paint.getFontMetrics();//文字不会跳动

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制圆环
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(CIRCLE_COLOR);
        paint.setStrokeWidth(RING_WIDTH);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, RADIUS, paint);


        //绘制进度条
        paint.setColor(HIGHTLIGHT_COLOR);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS
                , -90, 220, false, paint);

        //绘制文字
        paint.setStyle(Paint.Style.FILL);
        //文字纵向 偏移量
//        paint.getTextBounds("abab", 0, "abab".length(), rect);
//        int offset = (rect.top + rect.bottom) / 2;

        //文字纵向 偏移量 （文字不会跳动）
        float offset = (fontMetrics.ascent + fontMetrics.descent) / 2;
        canvas.drawText("aaaa", getWidth() / 2, getHeight() / 2 - offset, paint);

        //绘制文字 2
        paint.setTextAlign(Paint.Align.LEFT);
        paint.getTextBounds("abab", 0, "abab".length(), rect);
        canvas.drawText("aaaa", -rect.left, 120, paint);

        //绘制文字 3
        paint.setTextSize(Utils.dp2px(15));
        canvas.drawText("aaaa", 0, 120+paint.getFontSpacing(), paint);
    }
}
