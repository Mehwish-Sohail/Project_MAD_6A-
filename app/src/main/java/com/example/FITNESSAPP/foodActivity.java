package com.example.FITNESSAPP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class foodActivity extends AppCompatActivity {

    ListView listView;
//    String[] storyTitles;
//    String[] storyDetails;storyDetails

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        // Initialize views
//        listView = findViewById(R.id.list);

        // Get arrays from resources
        String[]  tstory = getResources().getStringArray(R.array.title_story);
        final String[] dstory = getResources().getStringArray(R.array.details_story);

        listView = findViewById(R.id.list);

        // Set up ArrayAdapter for the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.rowtext, tstory);
        listView.setAdapter(adapter);

        // Set item click listener for ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Start FoodActivityDetails with selected story details
                String t=dstory[position];
                Intent intent = new Intent(foodActivity.this, FoodActivityDetails.class);
                intent.putExtra("Story",t);
                startActivity(intent);
            }
        });
    }

    // Method to handle back button click
    public void foodgoback(View view) {
        Intent intent = new Intent(foodActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(foodActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
