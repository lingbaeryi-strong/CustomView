package com.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.customview.animate.CircleView;

public class MainActivity extends AppCompatActivity {

    ImageView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view);

//        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "radius", Utils.dp2px(150));
//        animator.setStartDelay(1000);
//        animator.start();

//        ObjectAnimator bottomAnimator = ObjectAnimator.ofFloat(view, "bottomFlip", 45);
//        bottomAnimator.setDuration(1500);
//
//        ObjectAnimator flipRotation = ObjectAnimator.ofFloat(view, "flipRotation", 270);
//        flipRotation.setDuration(1500);
//
//        ObjectAnimator topAnimator = ObjectAnimator.ofFloat(view, "topFlip", -45);
//        topAnimator.setDuration(1500);
//
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playSequentially(bottomAnimator, flipRotation, topAnimator);
//        animatorSet.setStartDelay(1000);
//        animatorSet.start();


        // 同时改变属性
//        PropertyValuesHolder bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip", 45);
//        PropertyValuesHolder flipRotationHolder = PropertyValuesHolder.ofFloat("flipRotation", 270);
//        PropertyValuesHolder topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -45);
//
//        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, bottomFlipHolder, flipRotationHolder, topFlipHolder);
//        objectAnimator.setDuration(2000);
//        objectAnimator.setStartDelay(1500);
//        objectAnimator.start();


        //同一个view 同一个属性 做多个动画(中间慢)
//        float length = Utils.dpTopixel(300);
//        Keyframe keyframe1 = Keyframe.ofFloat(0, 0);
//        Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 0.4f * length);
////        Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 1.5f * length);//超出会回弹
//        Keyframe keyframe3 = Keyframe.ofFloat(0.8f, 0.6f * length);
//        Keyframe keyframe4 = Keyframe.ofFloat(1, 1 * length);
//        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("translationX",
//                keyframe1, keyframe2, keyframe3, keyframe4);
//        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolder)se;
//        objectAnimator.setStartDelay(1000);
//        objectAnimator.setDuration(2000);
//        objectAnimator.start();


        // interpolator 差值器  默认 先加速后减速过程

        view.setTranslationY(-Utils.dpTopixel(100));
        view.animate()
                .translationY(Utils.dpTopixel(300))
                .setStartDelay(1000)
                .setDuration(2000)
                .setInterpolator(new DecelerateInterpolator())// 减速的差值器
//                .setInterpolator(new AccelerateInterpolator())// 加速的差值器
                .start();

    }
}
