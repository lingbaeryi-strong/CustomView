package com.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import com.customview.animate.CircleView;

public class MainActivity extends AppCompatActivity {

    CircleView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view);

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "radius", Utils.dp2px(150));
        animator.setStartDelay(1000);
        animator.start();

    }
}
