package com.example.FITNESSAPP;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.ads.AdRequest;

public class FoodActivityDetails extends AppCompatActivity {

TextView textview;
//private View madview;
    protected void onCreate (Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food_details);
//        madview= findViewById(R.id.adView);
//        AdRequest adrequest;
//        adrequest = new AdRequest.Builder().build();
//        madview.clearAnimation();
        textview=findViewById(R.id.text);
        String dstory=getIntent().getStringExtra("story");
        textview.setText(dstory);}
public void gooback(View view){
    Intent intent=new Intent(FoodActivityDetails.this,foodActivity.class);
    startActivity(intent);
    finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FoodActivityDetails.this, foodActivity.class);
        startActivity(intent);
        finish();
    }
}