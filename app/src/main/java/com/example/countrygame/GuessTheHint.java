package com.example.countrygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GuessTheHint extends AppCompatActivity {

    private ImageView randomFlag;
    private EditText dashlineText;
    private Button buttonNext;
    private Button hintStart;
    private TextView dashline;

    //---- Constructors -----//
    Random random = new Random();
    GuessTheCountry guessTheCountry = new GuessTheCountry();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_hint);

        randomFlag = findViewById(R.id.hint_flag);
        dashlineText = findViewById(R.id.dashlint_hint);
        buttonNext =findViewById(R.id.flag_changing_button);
        hintStart = findViewById(R.id.hint_start);
        dashline = findViewById(R.id.dashline_txt);
    }


        int pickedHintImage = 0 , lastpickedHint = 0;


    public void hintFlagNext(View view) {
        dashlineText.setVisibility(View.VISIBLE);
        buttonNext.setVisibility(View.VISIBLE);
        hintStart.setVisibility(View.INVISIBLE);

        do {
            pickedHintImage = random.nextInt(guessTheCountry.flags.length);
        }while (pickedHintImage==lastpickedHint);

        lastpickedHint = pickedHintImage;
        //int index = ;
        randomFlag.setImageResource(guessTheCountry.flags[pickedHintImage]);

        dashlineText.setHint("-------------- ------ ");


           /*int dashLineLenth = guessTheCountry.country_name[guessTheCountry.flags[pickedHintImage]].length();

                for (int i =0; i < dashLineLenth;i++){
                    dashlineText.setHint("- ");
                }
*/


    }
}
