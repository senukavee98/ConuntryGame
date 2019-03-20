package com.example.countrygame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Countdown extends AppCompatActivity {

    private TextView countdouwnText;
    private Button countdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftInMiliseconds = 10000;
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        countdouwnText = findViewById(R.id.countdown_txt);
        countdownButton = findViewById(R.id.countdown_button);

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });
        updateTimer();

    } // end of OnCreate Method



    private void startStop() {
        if (timerRunning){
            stopTimer();
        }else {
            startTimer();
        }
    }

    private void stopTimer() {
        countdownButton.setText("START");
        countDownTimer.cancel();
        countdouwnText.setText(timeLeftText);
        timerRunning = false;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMiliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMiliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        countdownButton.setText("START");
        timerRunning = true;
    }

    String timeLeftText ;
    private void updateTimer() {
        int minutes = (int) timeLeftInMiliseconds/60000;
        int seconds = (int) timeLeftInMiliseconds % 60000 / 1000;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10){
            timeLeftText += "0";
            timeLeftText += seconds;

            countdouwnText.setText(timeLeftText);
            countdownButton.setText("PAUSE");

        }
        if (timeLeftText.equals("0:00")){
            countdownButton.setText("TIME OUT");
            countdouwnText.setTextSize(minutes,50);
            countdouwnText.setText("Answers Submitted!");

        }
    }
}
