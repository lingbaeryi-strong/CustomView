package com.customview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;


public class MaterialEditText extends AppCompatEditText {

    private static final float TEXT_SIZE = Utils.dpTopixel(12);
    private static final float TEXT_MARGIN = Utils.dpTopixel(8);
    private static final float TEXT_VERTICAL_OFFSET = Utils.dpTopixel(12);
    private static final float TEXT_HORIZONTAL_OFFSET = Utils.dpTopixel(5);
    private static final float TEXT_ANIMATION_OFFSET = Utils.dpTopixel(16);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    boolean floatingLabelShow;
    float floatingLabelFraction;
    ObjectAnimator animator;
    boolean useFloatingLabel = true;
    Rect backgroundPadding = new Rect();

    public MaterialEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText);
        useFloatingLabel = typedArray.getBoolean(R.styleable.MaterialEditText_useFloatingLabel, true);
        typedArray.recycle();

        paint.setTextSize(TEXT_SIZE);
        onUseFloatingLabelChange();
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (useFloatingLabel) {
                    if (floatingLabelShow && TextUtils.isEmpty(s)) {
                        floatingLabelShow = false;
                        getAnimator().reverse();
                    } else if (!floatingLabelShow && !TextUtils.isEmpty(s)) {
                        floatingLabelShow = true;
                        getAnimator().start();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void setUseFloatingLabel(boolean useFloatingLabel) {
        if (this.useFloatingLabel != useFloatingLabel) {
            this.useFloatingLabel = useFloatingLabel;
            onUseFloatingLabelChange();
        }
    }

    private void onUseFloatingLabelChange() {
        getBackground().getPadding(backgroundPadding);
        if (useFloatingLabel) {
            setPadding(getPaddingLeft(), (int) (backgroundPadding.top + TEXT_SIZE + TEXT_MARGIN), getPaddingRight(), getPaddingBottom());
        } else {
            setPadding(getPaddingLeft(), backgroundPadding.top, getPaddingRight(), getPaddingBottom());
        }
    }

    private ObjectAnimator getAnimator() {
        if (animator == null) {
            animator = ObjectAnimator.ofFloat(MaterialEditText.this, "floatingLabelFraction", 0, 1);
        }
        return animator;
    }

    public float getFloatingLabelFraction() {
        return floatingLabelFraction;
    }

    public void setFloatingLabelFraction(float floatingLabelFraction) {
        this.floatingLabelFraction = floatingLabelFraction;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAlpha((int) (0xff * floatingLabelFraction));
        float exreoOFset = TEXT_ANIMATION_OFFSET * (1 - floatingLabelFraction);
        canvas.drawText(getHint().toString(), 0 + TEXT_HORIZONTAL_OFFSET, TEXT_VERTICAL_OFFSET + exreoOFset, paint);
    }
}
