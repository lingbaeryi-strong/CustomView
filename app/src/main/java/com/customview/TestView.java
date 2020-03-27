package com.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TestView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    PathMeasure pathMeasure;

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        path.reset();
        path.addRect(getWidth() / 2 - 150, getHeight() / 2 - 300, getWidth() / 2 + 150, getHeight() / 2, Path.Direction.CCW);

        path.addCircle(getWidth() / 2, getHeight() / 2, 150, Path.Direction.CCW);

       // Path.Direction.CCW  顺时针   cw  逆时针

        pathMeasure=new PathMeasure(path,false);
        pathMeasure.getLength();
//        pathMeasure.getPosTan();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        path.setFillType(Path.FillType.EVEN_ODD);  //镂空用这个就可以
        canvas.drawPath(path, paint);
    }
}
