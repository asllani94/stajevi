package com.uygulama.stajevi.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.uygulama.stajevi.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startAnimation();
        count();


    }


    private void count(){//count method to display company logo for 4 seconds and then proceed to Giris Activity
        new CountDownTimer(3500, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                Intent i=new Intent(SplashActivity.this,GirisActivity.class);
                overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
                startActivity(i);
                finish();

            }

        }.start();


    }


    //animating the company logo
    private void startAnimation(){

        Animation anim = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.translate);
        anim.reset();
        ImageView flylogo = (ImageView) findViewById(R.id.fly);
        flylogo.clearAnimation();
        flylogo.startAnimation(anim);


    }
}
