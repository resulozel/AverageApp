package com.example.resulozel.ortalamaapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    Button btnOrtalamaHesapla;
    ImageView imgBalonResmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btnOrtalamaHesapla=findViewById(R.id.sub);
        imgBalonResmi=findViewById(R.id.ballon);


        btnOrtalamaHesapla.setAnimation(AnimationUtils.loadAnimation(this, R.anim.frombottom));
        imgBalonResmi.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fromtop));

        btnOrtalamaHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOrtalamaHesapla.startAnimation(AnimationUtils.loadAnimation(SplashActivity.this, R.anim.frombottombasilinca));
                imgBalonResmi.startAnimation(AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fromtopbasilinca));

                new CountDownTimer(700,700) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Intent i=new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                }.start();
            }
        });
    }
}
