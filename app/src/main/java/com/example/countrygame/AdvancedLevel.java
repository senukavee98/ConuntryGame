package com.example.countrygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class AdvancedLevel extends AppCompatActivity {


    private ImageView aFlag1;
    private ImageView aFlag2;
    private ImageView aFlag3;
    private EditText editText_ans1;
    private EditText editText_ans2;
    private EditText editText_ans3;
    private String[] id;
    private Integer[] value;

    GuessTheCountry guessTheCountry = new GuessTheCountry();
    GuessTheFlag guessTheFlag = new GuessTheFlag();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);

        //----------finding the element ID of the XML ----------------
        aFlag1 = findViewById(R.id.advance_flag1);
        aFlag2 = findViewById(R.id.advance_flag2);
        aFlag3 = findViewById(R.id.advance_flag3);
        editText_ans1 = findViewById(R.id.editText_1);
        editText_ans2 = findViewById(R.id.editText_2);
        editText_ans3 = findViewById(R.id.editText_3);

        aFlag1.setImageResource(R.drawable.fo);
        aFlag2.setImageResource(R.drawable.vg);
        aFlag3.setImageResource(R.drawable.sr);

    }

    int pickedImage = 0, lastPicked = 0;

    public void nextStartClick(View view) {

        do {
            pickedImage = random.nextInt(guessTheFlag.flags.length);

        } while (pickedImage == lastPicked);

        lastPicked = pickedImage;

        //------------ display random image ------------------
        // **** for flag 01 **** //
        int fi1 = guessTheFlag.flags[random.nextInt(guessTheFlag.flags.length)];
        aFlag1.setImageResource(fi1);
        int fj1 = guessTheCountry.findArrayIndexInt(guessTheFlag.flags, fi1);
        String name1 = guessTheCountry.country_name[fj1];

        // **** for flag 02 **** //
        int fi2 = guessTheFlag.flags[random.nextInt(guessTheFlag.flags.length)];
        aFlag2.setImageResource(fi2);
        int fj2 = guessTheCountry.findArrayIndexInt(guessTheFlag.flags, fi2);
        String name2 = guessTheCountry.country_name[fj2];

        // **** for flag 03 **** //
        int fi3 = guessTheFlag.flags[random.nextInt(guessTheFlag.flags.length)];
        aFlag3.setImageResource(fi3);
        int fj3 = guessTheCountry.findArrayIndexInt(guessTheFlag.flags, fi3);
        String name3 = guessTheCountry.country_name[fj3];

        //-------------adding elements to the array---------------------

        value = new Integer[]{fj1, fj2, fj3};
        id = new String[]{name1, name2, name3};

    }

 //----------------- Submit Button Event Handler --------------//

    public void advancedSubmit(View view) {

        String edittext_value1 = editText_ans1.getText().toString();
        String edittext_value2 = editText_ans2.getText().toString();
        String edittext_value3 = editText_ans3.getText().toString();
        int correctTotal=0 ,wrongTotal=0;
        int k;

    //For edit text 1
        for (int i = 0; i < value.length; i++) {

            if (edittext_value1.equals(id[i])) {
                k = guessTheCountry.findArrayIndexInt(value, i);

                for (int j = 0; j < id.length; j++) {
                    if (value[k] == value[j]) {
                        correctTotal++;
                        editText_ans1.setBackgroundColor(getResources().getColor(R.color.green));
                        editText_ans1.setEnabled(false);
                    } //-------- compare images if ends -------
                    else
                        wrongTotal++;
                        editText_ans1.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        } // ---- end the operation for edit text 1 -------

//Edit text 2 
        for (int i = 0; i < value.length; i++) {
            if (edittext_value2.equals(id[i])) {
                k = guessTheCountry.findArrayIndexInt(value, i);

                for (int j = 0; j < id.length; j++) {
                    if (value[k] == value[j]) {
                        correctTotal++;
                        editText_ans1.setBackgroundColor(getResources().getColor(R.color.green));
                        editText_ans2.setEnabled(false);
                    } //-------- compare images if ends -------
                    else
                        wrongTotal++;
                    editText_ans1.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        } // ---- end the operation for edit text 2 -------

        for (int i = 0; i < value.length; i++) {
            if (edittext_value3.equals(id[i])) {
                k = guessTheCountry.findArrayIndexInt(value, i);

                for (int j = 0; j < id.length; j++) {
                    if (value[k] == value[j]) {
                        correctTotal++;
                        editText_ans1.setBackgroundColor(getResources().getColor(R.color.green));
                        editText_ans3.setEnabled(false);
                    } //-------- compare images if ends -------
                    else
                        wrongTotal++;
                    editText_ans1.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }


        } // ---- end the operation for edit text 3 ------- //


    } // end of the method advancedSubmit();


}  //End of the Class
