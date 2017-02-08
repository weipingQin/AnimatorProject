package com.test.tuyaproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.test.widgets.CustomImageView;

/**
 * Created by T32E on 17/2/8.
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        CustomImageView imageView = (CustomImageView)findViewById(R.id.animatorbutton);
        imageView.start();
    }
}
