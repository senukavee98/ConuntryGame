package com.example.countrygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  //------- LOGCAT display for testing -------//
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.countrygame.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


  //----------------The action of country guessing button----------------//
    public void guessingCountry(View view) {
        Log.d(LOG_TAG,"Country guessing Button is clicked !");

        Intent intent = new Intent(this,GuessTheCountry.class);
        startActivity(intent);
    }

  //----------------The action of hint guessing button----------------//
    public void guessingHint(View view) {
        Log.d(LOG_TAG,"Country Hint Button is clicked !");
    }

  //----------------The action of the flag guessing button----------------//
    public void guessingFlag(View view) {
        Log.d(LOG_TAG,"Guess the flag Clicked ! ");

        Intent intent = new Intent(this,GuessTheFlag.class);
        startActivity(intent);
    }

  //----------------The action of Advanced level button----------------//
    public void advancedLevel(View view) {
        Log.d(LOG_TAG,"Advanced level Button is clicked !");
        Intent intent = new Intent(this,AdvancedLevel.class);
        startActivity(intent);
    }

  //------------ Countdown button ---------------//
    public void countDown(View view){
        Intent intent = new Intent(this,Countdown.class);
        startActivity(intent);

    }
}
