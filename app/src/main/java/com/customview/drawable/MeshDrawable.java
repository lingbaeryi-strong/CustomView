package com.customview.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import com.customview.Utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MeshDrawable extends Drawable {
    private static final int INTERVAL = (int) Utils.dpTopixel(80);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        paint.setColor(Color.RED);
        paint.setStrokeWidth(Utils.dpTopixel(2));
    }

    @Override
    public void draw(@NonNull Canvas canvas) {

        for (int i = 0; i < getBounds().right; i += INTERVAL) {
            for (int j = 0; j < getBounds().bottom; j += INTERVAL) {
                canvas.drawLine(getBounds().left, j, getBounds().right, j, paint);
                canvas.drawLine(i, getBounds().top, i, getBounds().bottom, paint);
            }
        }

    }

    @Override
    public void setAlpha(int alpha) {

        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return paint.getAlpha() == 0 ? PixelFormat.TRANSLUCENT :
                paint.getAlpha() == 0xff ? PixelFormat.OPAQUE : PixelFormat.TRANSLUCENT;
    }
}
