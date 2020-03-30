package com.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ImageTextView extends View {

    private static final float RING_WIDTH = Utils.dp2px(20);
    private static final float RADIUS = Utils.dp2px(150);
    private static final int CIRCLE_COLOR = Color.parseColor("#90a4ae");
    private static final int HIGHTLIGHT_COLOR = Color.parseColor("#ff4081");

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    TextPaint textPaint = new TextPaint();
    Bitmap bitmap;
    float[] currtwidth = new float[1];

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setTextSize(Utils.dp2px(16));
        textPaint.setTextSize(Utils.dp2px(16));
        bitmap = getAvatar((int) Utils.dp2px(100));
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        StaticLayout staticLayout = new StaticLayout("ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ",
//                textPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
//        staticLayout.draw(canvas);

        canvas.drawBitmap(bitmap, getWidth() - (int) Utils.dp2px(100), 100, paint);

        String text = "ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD ABCD ab CD";

        int index = paint.breakText(text, true, getWidth(), currtwidth);
        canvas.drawText(text, 0, index, 0, 50, paint);
        int oldIndex = index;
        index = paint.breakText(text, index, text.length(), true, getWidth(), currtwidth);
        canvas.drawText(text, oldIndex, oldIndex + index, 0, 50 + paint.getFontSpacing(), paint);
        oldIndex = index;
        index = paint.breakText(text, index, text.length(), true, getWidth() - Utils.dp2px(100), currtwidth);
        canvas.drawText(text, oldIndex, oldIndex + index, 0, 50 + paint.getFontSpacing()*2, paint);
    }

    private Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.timg, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.mipmap.timg, options);
    }
}
