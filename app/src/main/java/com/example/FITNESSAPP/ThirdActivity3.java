package com.example.FITNESSAPP;

import static com.example.FITNESSAPP.R.*;
import static com.example.FITNESSAPP.R.id.timer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity3 extends AppCompatActivity {
    String buttonvalue;
    Button startbtn;
    private CountDownTimer timer;
    TextView mtv;
    private boolean MTimeRunning;
    private long Mtimeleftmini;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Intent intent= getIntent();
        buttonvalue = intent.getStringExtra("value");
        int intvalue=Integer.valueOf(buttonvalue);
        switch (intvalue) {
            case 1:
                setContentView(R.layout.activity_bow1);
                break;
            case 2:
                setContentView(R.layout.activity_bow2);
                break;
            case 3:
                setContentView(R.layout.activity_bow3);
                break;
            case 4:
                setContentView(R.layout.activity_bow4);
                break;
            case 5:
                setContentView(R.layout.activity_bow5);
                break;
            case 6:
                setContentView(R.layout.activity_bow6);
                break;
            case 7:
                setContentView(R.layout.activity_bow7);
                break;
            case 8:
                setContentView(R.layout.activity_bow8);
                break;
            case 9:
                setContentView(R.layout.activity_bow9);
                break;
            case 10:
                setContentView(R.layout.activity_bow10);
                break;
            case 11:
                setContentView(R.layout.activity_bow11);
                break;
            case 12:
                setContentView(R.layout.activity_bow12);
                break;
            case 13:
                setContentView(R.layout.activity_bow13);
                break;
            case 14:
                setContentView(R.layout.activity_bow14);
                break;
            case 15:
                setContentView(R.layout.activity_bow15);
                break;
        }

        startbtn= findViewById(R.id.startbutton);
        mtv= findViewById(R.id.timer);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MTimeRunning)
                {
                    stoptimer();

                }

                else{
                    startTimer();

                }
            }
        });
    }
    private void stoptimer()
    {
        timer.cancel();
        MTimeRunning=false;
        startbtn.setText("START");

    }
    private <int_number> void startTimer(){
        final CharSequence value= mtv.getText();
        String num1=value.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);



        final int number= Integer.valueOf(num2) * 60+ Integer.valueOf(num3);
        Mtimeleftmini=number*1000;




        timer=new CountDownTimer(Mtimeleftmini,3000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Mtimeleftmini= millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int newvalue=Integer.valueOf(buttonvalue)+1;
                if(newvalue<=7){
                    Intent intent=new Intent(ThirdActivity3.this,ThirdActivity3.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else{
                    newvalue=1;
                    Intent intent=new Intent(ThirdActivity3.this,ThirdActivity3.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }

            }
        }.start();
        startbtn.setText("Pause");
        MTimeRunning=true;
    }
    private void updateTimer()
    {
        int minutes=(int) Mtimeleftmini/ 60_000;
        // Corrected line of code
        int seconds = (int) (Mtimeleftmini % 60000) / 1000;

            String timelefttext="";
        if(minutes<10)
            timelefttext="0";
        timelefttext=timelefttext+minutes+"1";
        if(seconds<10)
            timelefttext="0";
        timelefttext+=seconds;
        mtv.setText(timelefttext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




}

