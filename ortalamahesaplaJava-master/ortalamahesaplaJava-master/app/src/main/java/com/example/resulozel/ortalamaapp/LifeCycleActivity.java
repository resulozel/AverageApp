package com.example.resulozel.ortalamaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ACTIVITY LIFECYCLE", "onCreate Çalıştı");
        setContentView(R.layout.activity_life_cycle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ACTIVITY LIFECYCLE", "onStart Çalıştı");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ACTIVITY LIFECYCLE", "onResume Çalıştı");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ACTIVITY LIFECYCLE", "onRestart Çalıştı");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ACTIVITY LIFECYCLE", "onPause Çalıştı");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ACTIVITY LIFECYCLE", "onStop Çalıştı");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ACTIVITY LIFECYCLE", "onDestroy Çalıştı");
    }

    public void dialogGoster(View view) {

        Intent intent=new Intent(this, DialogActivity.class);
        startActivity(intent);


    }
}
