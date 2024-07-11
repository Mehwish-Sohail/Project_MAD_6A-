package com.example.FITNESSAPP;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = findViewById(R.id.startyoga1);
        button2 = findViewById(R.id.startyoga2);
        button3 = findViewById(R.id.startfood);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, secondactivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, secondactivity2.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, foodActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_privacy) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://policies.google.com/privacy?hl=en-US"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.id_term) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://policies.google.com/terms?hl=en-US"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.rate) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            } catch (Exception e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
            }
            return true;
        }
        if (id == R.id.more) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=softin.my.fast.fitness&hl=en"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.share) {
            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plain");
            String sharebody = "This is the best for yoga \nBy this app you stretch your body\n this is free, download now\n" + "https://play.google.com/store/apps/details?id=com.example.yogademo?h1=en";
            String sharehub = "Fitness App";
            myintent.putExtra(Intent.EXTRA_SUBJECT, sharehub);
            myintent.putExtra(Intent.EXTRA_TEXT, sharebody);
            startActivity(Intent.createChooser(myintent, "share using"));
            return true;
        }
        return true;
    }

    public void beforeage18(View view) {
        Intent intent = new Intent(MainActivity.this, secondactivity.class);
        startActivity(intent);
    }

    public void afterage18(View view) {
        Intent intent = new Intent(MainActivity.this, secondactivity2.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent = new Intent(MainActivity.this, foodActivity.class);
        startActivity(intent);
    }
}
