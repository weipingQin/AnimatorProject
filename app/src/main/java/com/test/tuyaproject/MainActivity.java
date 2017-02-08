package com.test.tuyaproject;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.test.widgets.CustomImageView;
import com.test.widgets.CustomTextView;

public class MainActivity extends AppCompatActivity{
  //  private int count = 0 ;

    private AnimationDrawable animationDrawable;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
//            @Override
//            public void idsAvailable(String userId, String registrationId) {
//                String text = "OneSignal UserID:\n" + userId + "\n\n";
//
//                if (registrationId != null)
//                    text += "Google Registration Id:\n" + registrationId;
//                else
//                    text += "Google Registration Id:\nCould not subscribe for push";
//
//                TextView textView = (TextView)findViewById(R.id.debug_view);
//                textView.setText(text);
//            }
//        });
       // init();
    }

    private void init(){
        CustomImageView imageView = (CustomImageView)findViewById(R.id.animatorbutton);
        imageView.start();
    }

//    private void init(){
//        mImageView = (ImageView) findViewById(R.id.iv_animation);
//        animationDrawable =(AnimationDrawable)mImageView.getDrawable();
//    }
}
