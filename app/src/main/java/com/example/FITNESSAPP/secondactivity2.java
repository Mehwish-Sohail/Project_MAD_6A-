package com.example.FITNESSAPP;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class secondactivity2 extends AppCompatActivity {
    int[] newarray;
//    private AdView madview, madview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
//        madview = findViewById(R.id.adView);
//        AdRequest adrequest;
//        adrequest = new AdRequest.Builder().build();
//        madview.loadAd(adrequest);
////
////        madview1 = findViewById(R.id.adView1);
//        AdRequest adrequest1;
//        adrequest1 = new AdRequest.Builder().build();
//        madview1.loadAd(adrequest1);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        newarray = new int[]{
                R.id.boot_pose1, R.id.boot_pose2, R.id.boot_pose3, R.id.boot_pose4,
                R.id.boot_pose5, R.id.boot_pose6, R.id.boot_pose7, R.id.boot_pose8,
                R.id.boot_pose9, R.id.boot_pose10, R.id.boot_pose11, R.id.boot_pose12,
                R.id.boot_pose13, R.id.boot_pose14, R.id.boot_pose15,
        };
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
            String sharebody = "This is the best for yoga \nBy this app you streach your body\n this is the free download now\n" + "https://play.google.com/store/apps/details?id=com.example.yogademo?h1=en";
            String sharehub = "Fitness App";
            myintent.putExtra(Intent.EXTRA_SUBJECT, sharehub);
            myintent.putExtra(Intent.EXTRA_TEXT, sharebody);
            startActivity(Intent.createChooser(myintent, "share using"));

            return true;
        }

        return true;
    }


    public void Imagebuttonclick(View view) {
        for (int i = 0; i < newarray.length; i++) {
            if (view.getId() == newarray[i]) {
                int value = i + 1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(secondactivity2.this, ThirdActivity3.class);
                intent.putExtra("value", String.valueOf(value));
                startActivity(intent);
            }
        }
    }

}
