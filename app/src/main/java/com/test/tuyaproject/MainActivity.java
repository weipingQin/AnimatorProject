package com.test.tuyaproject;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static com.test.tuyaproject.R.id.main_bg;

public class MainActivity extends AppCompatActivity{

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init(){
        mImageView = (ImageView)findViewById(R.id.main_bg);
    }
}
