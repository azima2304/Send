package com.example.send;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class WelcomeActivity extends AppCompatActivity {

    LottieAnimationView animationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        animationView = findViewById(R.id.ani);
        animationView.setAnimation(R.raw.animation);
        if (animationView != null) {
            animationView.setAnimation(R.raw.animation);
            animationView.playAnimation();
        }



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

}
