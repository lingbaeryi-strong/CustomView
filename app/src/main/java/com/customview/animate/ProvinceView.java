package com.customview.animate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.customview.Utils;

import androidx.annotation.Nullable;

public class ProvinceView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String province = "北京市";

    public ProvinceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);//关闭硬件加速
//        setLayerType(LAYER_TYPE_HARDWARE, null);//开启硬件加速 额外有离屏缓冲
//        setLayerType(LAYER_TYPE_NONE, null);//打开硬件加速

        paint.setTextSize(Utils.dpTopixel(100));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(province, getWidth() / 2, getHeight() / 2, paint);
    }
}
