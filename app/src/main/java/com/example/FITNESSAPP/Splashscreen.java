package com.example.FITNESSAPP;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Splashscreen extends AppCompatActivity {
    Animation up,down;
     TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashscreen);
       TextView textview= findViewById(R.id.appname);
       down= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
       textview.setAnimation(down);



       new Handler().postDelayed(new Runnable() {
       @Override
           public void run() {
               startActivity(new Intent(getApplicationContext(),MainActivity.class));
               finish();
           }
       }, 3500);}}
