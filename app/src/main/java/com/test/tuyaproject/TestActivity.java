package com.test.tuyaproject;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.test.widgets.CustomImageView;
import com.test.widgets.CustomTextView;

/**
 * Created by T32E on 17/2/8.
 */

public class TestActivity extends AppCompatActivity {

    public static final String TAG = TestActivity.class.getSimpleName();

    private ImageView mImageView, mLoadingImageView,mRightView;
    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mFrameLayout = (FrameLayout)findViewById(R.id.button);
        mImageView = (ImageView) findViewById(R.id.main_bg);
        mLoadingImageView = (ImageView) findViewById(R.id.main_loading);
        mRightView = (ImageView)findViewById(R.id.main_right_icon);

        final AnimatorSet animatorSet = new AnimatorSet();

        final ObjectAnimator animatorX = ObjectAnimator.ofFloat(mImageView, "scaleX", 1, 1.2f, 0.9f);
        final ObjectAnimator animatorY = ObjectAnimator.ofFloat(mImageView,"scaleY",1,1.2f,0.9f);
        final ObjectAnimator animatorRotate = ObjectAnimator.ofFloat(mLoadingImageView,"rotation",0,360);
        final ObjectAnimator animatorRotate2 = ObjectAnimator.ofFloat(mLoadingImageView,"alpha",1.0f,0.0f);

        final ObjectAnimator animatorRight = ObjectAnimator.ofFloat(mRightView,"alpha",0.0f,1.0f);

       // animatorRotate.setRepeatCount(-1);
        animatorX.setDuration(700);
        animatorY.setDuration(700);
        animatorRotate.setDuration(5000);
        animatorRotate2.setDuration(700);
        animatorRight.setDuration(1000);

        animatorRotate.setInterpolator(new DecelerateInterpolator());

        animatorSet.playTogether(animatorX,animatorY);
        animatorSet.playSequentially(animatorRotate,animatorRotate2,animatorRight);


        animatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Log.d(TAG,"X value change--->"+valueAnimator.getAnimatedValue());
            }
        });

        animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Log.d(TAG,"Y value change--->"+valueAnimator.getAnimatedValue());
            }
        });

        animatorX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                mRightView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                mLoadingImageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animatorRight.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });


        animatorRotate2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                mRightView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        mFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatorSet.start();
            }
        });
    }
}
