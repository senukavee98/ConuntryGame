package com.example.countrygame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class AdvancedLevel extends AppCompatActivity {


    private ImageView aFlag1;
    private ImageView aFlag2;
    private ImageView aFlag3;
    private EditText editText_ans1;
    private EditText editText_ans2;
    private EditText editText_ans3;
    private TextView ans_1;
    private TextView ans_2;
    private TextView ans_3;
    private TextView finalResult;
    private Button advance_btn_start;


    //constructors
    GuessTheCountry guessTheCountry = new GuessTheCountry();
    GuessTheFlag guessTheFlag = new GuessTheFlag();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);

        //----------finding the element ID of the XML ----------------
        //flag images
        aFlag1 = findViewById(R.id.advance_flag1);
        aFlag2 = findViewById(R.id.advance_flag2);
        aFlag3 = findViewById(R.id.advance_flag3);
        //fag text boxes
        editText_ans1 = findViewById(R.id.editText_1);
        editText_ans2 = findViewById(R.id.editText_2);
        editText_ans3 = findViewById(R.id.editText_3);

        ans_1=findViewById(R.id.ans_1);
        ans_2=findViewById(R.id.ans_2);
        ans_3=findViewById(R.id.ans_3);
        finalResult = findViewById(R.id.final_result);
        advance_btn_start = findViewById(R.id.advance_btn_start);

        //hardcoded
        /*aFlag1.setImageResource(R.drawable.fo);
        aFlag2.setImageResource(R.drawable.vg);
        aFlag3.setImageResource(R.drawable.sr);
*/

        editText_ans1.setVisibility(View.INVISIBLE);
        editText_ans2.setVisibility(View.INVISIBLE);
        editText_ans3.setVisibility(View.INVISIBLE);

    }


// -------------------- **Event handler of SUBMIT button** --------------------- //

    int correctTotal=0 ,wrongTotal=0,noOfAttempts =0;
    public void advancedSubmit(View view) {
        noOfAttempts+=1;

        // for image 1
        for (int i = 0; i < guessTheCountry.country_name.length; i++) {
            String flagName = guessTheCountry.country_name[i];
            String userGivenAnswer1 = editText_ans1.getText().toString();
            String userGivenAnswer2 = editText_ans2.getText().toString();
            String userGivenAnswer3 = editText_ans3.getText().toString();

            if (userGivenAnswer1.equals(flagName)) {
                if (i == pickedImage1) {
                    correctTotal++;
                    editText_ans1.setEnabled(false);
                    editText_ans1.setBackgroundColor(getResources().getColor(R.color.green));
                }
            } else {
                editText_ans1.setBackgroundColor(getResources().getColor(R.color.red));
                wrongTotal++;

            }//End for image 1

            if (userGivenAnswer2.equals(flagName)) {
                if (i == pickedImage2) {
                    correctTotal++;
                    editText_ans2.setEnabled(false);
                    editText_ans2.setBackgroundColor(getResources().getColor(R.color.green));
                }
            } else {
                editText_ans2.setBackgroundColor(getResources().getColor(R.color.red));
                wrongTotal++;
            }//End for image 2

            if (userGivenAnswer3.equals(flagName)) {
                if (i == pickedImage2) {
                    correctTotal++;
                    editText_ans3.setEnabled(false);
                    editText_ans3.setBackgroundColor(getResources().getColor(R.color.green));
                }
            } else {
                editText_ans3.setBackgroundColor(getResources().getColor(R.color.red));
                wrongTotal++;
            }//End for image 3

        } //End For Loop


        if (noOfAttempts==3){
            editText_ans1.setEnabled(false);
            editText_ans2.setEnabled(false);
            editText_ans3.setEnabled(false);

            ans_1.setVisibility(View.VISIBLE);
            ans_2.setVisibility(View.VISIBLE);
            ans_3.setVisibility(View.VISIBLE);

            noOfAttempts=0;

        }else if (correctTotal==3){
            finalResult.setText("CORRECT !!!");
            finalResult.setTextColor(getResources().getColor(R.color.green));
        }else if (wrongTotal>0){
            finalResult.setText("WRONG");
            finalResult.setTextColor(getResources().getColor(R.color.red));
        }

    }// End of the advancedSubmit method



 // -------------------- **Event handler of NEXT button** --------------------- //
        int pickedImage1 , lastPicked1 ;
        int pickedImage2 , lastPicked2 ;
        int pickedImage3 , lastPicked3 ;

    public void nextStartClick(View view) {

        //---- Editing disabled ----//
        editText_ans1.setEnabled(true);
        editText_ans2.setEnabled(true);
        editText_ans3.setEnabled(true);

        editText_ans1.setVisibility(View.VISIBLE);
        editText_ans2.setVisibility(View.VISIBLE);
        editText_ans3.setVisibility(View.VISIBLE);
        advance_btn_start.setVisibility(View.INVISIBLE);

        //---- Remove text in text boxes ----//
        editText_ans1.setText("");
        editText_ans2.setText("");
        editText_ans3.setText("");
        ans_1.setText("");
        ans_2.setText("");
        ans_3.setText("");
        finalResult.setText(null);

        //---- Change the edit box color ----//
        editText_ans1.setBackgroundColor(Color.TRANSPARENT);
        editText_ans2.setBackgroundColor(Color.TRANSPARENT);
        editText_ans3.setBackgroundColor(Color.TRANSPARENT);



     //------------ display random image ------------------//
        // **** for flag 01 **** //
        do {
            pickedImage1 = random.nextInt(guessTheFlag.flags.length);

        } while (pickedImage1 == lastPicked1);

        lastPicked1 = pickedImage1;
        int fi1 = guessTheFlag.flags[pickedImage1];
        aFlag1.setImageResource(fi1);
        ans_1.setText(guessTheCountry.country_name[pickedImage1]);
        ans_1.setVisibility(View.INVISIBLE);

        // **** for flag 02 **** //
        do {
            pickedImage2 = random.nextInt(guessTheFlag.flags.length);

        } while (pickedImage2 == lastPicked2);
        lastPicked2 = pickedImage2;
        int fi2 = guessTheFlag.flags[pickedImage2];
        aFlag2.setImageResource(fi2);
        ans_2.setText(guessTheCountry.country_name[pickedImage2]);
        ans_2.setVisibility(View.INVISIBLE);

        // **** for flag 03 **** //
        do {
            pickedImage3 = random.nextInt(guessTheFlag.flags.length);

        } while (pickedImage3 == lastPicked3);
        lastPicked3 = pickedImage3;
        int fi3 = guessTheFlag.flags[pickedImage3];
        aFlag3.setImageResource(fi3);
        ans_3.setText(guessTheCountry.country_name[pickedImage3]);
        ans_3.setVisibility(View.INVISIBLE);

    }



/*

 //----------------- Submit Button Event Handler --------------//

    public void advancedSubmit(View view) {

        String edittext_value1 = editText_ans1.getText().toString();
        String edittext_value2 = editText_ans2.getText().toString();
        String edittext_value3 = editText_ans3.getText().toString();
        int correctTotal=0 ,wrongTotal=0;
        int k;


    //For edit text 1
        for (int i = 0; i < id.length; i++) {
            if (edittext_value1.equals(value[i])) {
                k = guessTheCountry.findArrayIndexInt(id, i);

                for (int j = 0; j < value.length; j++) {
                    if (id[k] == id[j]) {
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
        for (int i = 0; i < id.length; i++) {
            if (edittext_value2.equals(value[i])) {
                k = guessTheCountry.findArrayIndexInt(id, i);

                for (int j = 0; j < value.length; j++) {
                    if (id[k] == id[j]) {
                        correctTotal++;
                        editText_ans2.setBackgroundColor(getResources().getColor(R.color.green));
                        editText_ans2.setEnabled(false);
                    } //-------- compare images if ends -------
                    else
                        wrongTotal++;
                    editText_ans2.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        } // ---- end the operation for edit text 2 -------


    //For edit text 3
        for (int i = 0; i < id.length; i++) {
            if (edittext_value3.equals(value[i])) {
                k = guessTheCountry.findArrayIndexInt(id, i);

                for (int j = 0; j < value.length; j++) {
                    if (id[k] == id[j]) {
                        correctTotal++;
                        editText_ans3.setBackgroundColor(getResources().getColor(R.color.green));
                        editText_ans3.setEnabled(false);
                    } //-------- compare images if ends -------
                    else
                        wrongTotal++;
                    editText_ans3.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        } // ---- end the operation for edit text 2 -------


    } // end of the method advancedSubmit();

*/

}  //End of the Class
