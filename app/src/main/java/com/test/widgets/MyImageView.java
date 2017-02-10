package com.test.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Weiping on 17/2/9.
 */

public class MyImageView extends ImageView {
    private Paint mPaint;
    private int mWidth,mHeight;
    private float mRadius = 100.0f;

    public MyImageView(Context context) {
        this(context,null);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
    }

    private void initPaint(Canvas canvas){
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawText("sd",20,30,mPaint);
        canvas.drawCircle(mWidth/2,mHeight/2,mRadius,mPaint);
    }
}
