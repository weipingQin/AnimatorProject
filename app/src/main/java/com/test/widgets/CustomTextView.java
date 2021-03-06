package com.test.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by T32E on 17/2/7.
 */

public class CustomTextView extends TextView implements Animatable{
    private ProgressDrawable drawable;

    public interface onAnimFinish {
        void onFinish();
    }
    private onAnimFinish listener;

    public CustomTextView(Context context) {
        super(context);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        drawable = new ProgressDrawable(getTextSize(), this);
        drawable.setColorDefault(getCurrentTextColor());
        drawable.setAnimatable(this);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public void startRotate() {
        this.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        setCompoundDrawablePadding(25);
        drawable.startRotate();
    }

    public void animFinish() {
        drawable.animFinish();
    }

    public void animError() {
        drawable.animError();
    }

    public void removeDrawable() {
        this.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        drawable.stopRotate();
    }

    @Override
    public void start() {
        startRotate();
    }

    @Override
    public void stop() {

        if (listener != null) {
            listener.onFinish();
        }
    }

    public void setOnAnimFinishListener(onAnimFinish listener) {
        this.listener = listener;
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
