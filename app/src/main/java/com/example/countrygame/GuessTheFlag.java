package com.example.countrygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class GuessTheFlag extends AppCompatActivity {

  //---------- variables declaration -----------//
    private ImageView flag_01;
    private ImageView flag_02;
    private ImageView flag_03;
    private TextView flagName;
    private TextView correctResult;
    private TextView marks;
    private Button buttonStart;

  /*  private HashMap<Integer, String> threeElementList = new HashMap<Integer, String>();
    private Object[] keys;
    Object keyId;
    String randomFlagName;
    private List<Integer> id;
    private List<String> value;*/

  //------- Constructors ------//
    GuessTheCountry guessTheCountry = new GuessTheCountry();
    Random random = new Random();

    //--------------- Integer list of Flags ---------------//
    Integer[] flags = {
            R.drawable.ad, R.drawable.ae, R.drawable.af, R.drawable.ag, R.drawable.ai, R.drawable.al, R.drawable.am, R.drawable.an, R.drawable.ao,
            R.drawable.aq, R.drawable.ar, R.drawable.as, R.drawable.at, R.drawable.au, R.drawable.aw, R.drawable.ax, R.drawable.az,

            R.drawable.ba, R.drawable.bb, R.drawable.bd, R.drawable.be, R.drawable.bf, R.drawable.bg, R.drawable.bh, R.drawable.bi, R.drawable.bj, R.drawable.bl,
            R.drawable.bm, R.drawable.bn, R.drawable.bo, R.drawable.bq, R.drawable.br, R.drawable.bs, R.drawable.bt, R.drawable.bv, R.drawable.bw,
            R.drawable.by, R.drawable.bz,

            R.drawable.ca, R.drawable.cc, R.drawable.cd, R.drawable.cf, R.drawable.cg, R.drawable.ch, R.drawable.ci, R.drawable.ck, R.drawable.cl, R.drawable.cm,
            R.drawable.cn, R.drawable.co, R.drawable.cr, R.drawable.cu, R.drawable.cv, R.drawable.cw, R.drawable.cx, R.drawable.cy, R.drawable.cz,

            R.drawable.de, R.drawable.dj, R.drawable.dk, R.drawable.dm, R.drawable.do_0, R.drawable.dz,

            R.drawable.ec, R.drawable.ee, R.drawable.eg, R.drawable.eh, R.drawable.er, R.drawable.es, R.drawable.et, R.drawable.eu,

            R.drawable.fi, R.drawable.fj, R.drawable.fk, R.drawable.fm, R.drawable.fo, R.drawable.fr,

            R.drawable.ga, R.drawable.gb, R.drawable.gb_eng, R.drawable.gb_nir, R.drawable.gb_sct, R.drawable.gb_wls, R.drawable.gd, R.drawable.ge,
            R.drawable.gf, R.drawable.gg, R.drawable.gh, R.drawable.gi, R.drawable.gl, R.drawable.gm, R.drawable.gn, R.drawable.gp, R.drawable.gq, R.drawable.gr,
            R.drawable.gs, R.drawable.gt, R.drawable.gu, R.drawable.gw, R.drawable.gy,

            R.drawable.hk, R.drawable.hm, R.drawable.hn, R.drawable.hr, R.drawable.ht, R.drawable.hu,

            R.drawable.id, R.drawable.ie, R.drawable.il, R.drawable.im, R.drawable.in, R.drawable.io, R.drawable.iq, R.drawable.ir, R.drawable.is, R.drawable.it,

            R.drawable.je, R.drawable.jm, R.drawable.jo, R.drawable.jp,

            R.drawable.ke, R.drawable.kg, R.drawable.kh, R.drawable.ki, R.drawable.km, R.drawable.kn, R.drawable.kp, R.drawable.kr, R.drawable.kw, R.drawable.ky,
            R.drawable.kz,

            R.drawable.la, R.drawable.lb, R.drawable.lc, R.drawable.li, R.drawable.lk, R.drawable.lr, R.drawable.ls, R.drawable.lt, R.drawable.lu, R.drawable.lv,
            R.drawable.ly,

            R.drawable.ma, R.drawable.mc, R.drawable.md, R.drawable.me, R.drawable.mf, R.drawable.mg, R.drawable.mh, R.drawable.mk, R.drawable.ml,
            R.drawable.mm, R.drawable.mn, R.drawable.mo, R.drawable.mp, R.drawable.mq, R.drawable.mr, R.drawable.ms, R.drawable.mt, R.drawable.mu, R.drawable.mv,
            R.drawable.mw, R.drawable.mx, R.drawable.my, R.drawable.mz,

            R.drawable.na, R.drawable.nc, R.drawable.ne, R.drawable.nf, R.drawable.ng, R.drawable.ni, R.drawable.nl, R.drawable.no, R.drawable.np, R.drawable.nr,
            R.drawable.nu, R.drawable.nz,

            R.drawable.om,

            R.drawable.pa, R.drawable.pe, R.drawable.pf, R.drawable.pg, R.drawable.ph, R.drawable.pk, R.drawable.pl, R.drawable.pm, R.drawable.pn,
            R.drawable.pr, R.drawable.ps, R.drawable.pt, R.drawable.pw, R.drawable.py,

            R.drawable.qa,

            R.drawable.re, R.drawable.ro, R.drawable.rs, R.drawable.ru, R.drawable.rw,

            R.drawable.sa, R.drawable.sb, R.drawable.sc, R.drawable.sd, R.drawable.se, R.drawable.sg, R.drawable.sh, R.drawable.si, R.drawable.sj, R.drawable.sk,
            R.drawable.sl, R.drawable.sm, R.drawable.sn, R.drawable.so, R.drawable.sr, R.drawable.ss, R.drawable.st, R.drawable.sv, R.drawable.sx, R.drawable.sy,
            R.drawable.sz,

            R.drawable.tc, R.drawable.td, R.drawable.tf, R.drawable.tg, R.drawable.th, R.drawable.tj, R.drawable.tk, R.drawable.tl, R.drawable.tm, R.drawable.tn,
            R.drawable.to, R.drawable.tr, R.drawable.tt, R.drawable.tv, R.drawable.tw, R.drawable.tz,

            R.drawable.ua, R.drawable.ug, R.drawable.um, R.drawable.us, R.drawable.uy, R.drawable.uz,

            R.drawable.va, R.drawable.vc, R.drawable.ve, R.drawable.vg, R.drawable.vi, R.drawable.vn, R.drawable.vu,

            R.drawable.wf, R.drawable.ws,

            R.drawable.xk,

            R.drawable.ye, R.drawable.yt,

            R.drawable.za, R.drawable.zm, R.drawable.zw
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_flag);

      //------ ImageView ------//
        flag_01 = findViewById(R.id.flag1);
        flag_02 = findViewById(R.id.flag2);
        flag_03 = findViewById(R.id.flag3);

      //------ TextView ------//
        flagName = findViewById(R.id.flag_name);
        correctResult = findViewById(R.id.correct_results);
        marks = findViewById(R.id.Marks);

      //------ Button ------//
        buttonStart = findViewById(R.id.button_start);

    }

//--------------------------- NEXT BUTTON Function - Continue with the game ------------------------------//

        int pickedImage1, lastPicked1;
        int pickedImage2, lastPicked2;
        int pickedImage3, lastPicked3;
        int count=1,countryName_index;


    public void nextThreeFlags(View view) {

        buttonStart.setVisibility(View.INVISIBLE);
        correctResult.setText("");


        //------------ display random image ------------------//
        // **** for flag 01 **** //
        do {
            pickedImage1 = random.nextInt(guessTheCountry.flags.length);

        } while (pickedImage1 == lastPicked1);

        lastPicked1 = pickedImage1;
        int fi1 = guessTheCountry.flags[pickedImage1];
        flag_01.setImageResource(fi1);


        // **** for flag 02 **** //
        do {
            pickedImage2 = random.nextInt(guessTheCountry.flags.length);

        } while (pickedImage2 == lastPicked2);
        lastPicked2 = pickedImage2;
        int fi2 = guessTheCountry.flags[pickedImage2];
        flag_02.setImageResource(fi2);

        // **** for flag 03 **** //
        do {
            pickedImage3 = random.nextInt(guessTheCountry.flags.length);

        } while (pickedImage3 == lastPicked3);
        lastPicked3 = pickedImage3;
        int fi3 = guessTheCountry.flags[pickedImage3];
        flag_03.setImageResource(fi3);


        do {
            countryName_index = random.nextInt(guessTheCountry.country_name.length);

            if (countryName_index==pickedImage1 || countryName_index == pickedImage2 || countryName_index ==pickedImage3){
                String name = guessTheCountry.country_name[countryName_index];
                flagName.setText(name);
            }
        }while (!(countryName_index==pickedImage1 || countryName_index == pickedImage2 || countryName_index ==pickedImage3));



        /*if (count==1){
            name1 =guessTheCountry.country_name[pickedImage2];
            flagName.setText(name1);
            count++;
        }else if (count==2){
            name2=(guessTheCountry.country_name[pickedImage1]);
            flagName.setText(name2);
            count++;
        }else if (count==3){
            name3=(guessTheCountry.country_name[pickedImage3]);
            flagName.setText(name3);
            count=1;
        }
*/
        /*int fj3 = guessTheCountry.findArrayIndexInt(flags, fi3);
        String name3 = guessTheCountry.country_name[fj3];
        // ---- adding elements to HashMap -------
        threeElementList.put(fj1, name1);
        threeElementList.put(fj2, name2);
        threeElementList.put(fj3, name3);

        keys = threeElementList.keySet().toArray();
        keyId = keys[random.nextInt(keys.length)];
        randomFlagName = threeElementList.get(keyId);
        flagName.setText(randomFlagName);
        flag_02.setImageResource(fi2);
        correctResult.setText("");
        wrongResult.setText("");

        //-------adding to the two lists----------------
     *//*   id.add(fj1); value.add(name1);
        id.add(fj2); value.add(name2);
        id.add(fj3); value.add(name3);

       flagName.setText("Country Name : " + name1);
*/
    }


//--------------------------- Clickable Image - choosing the correct flag function -----------------------------//

    int Marks =0;

    public void clickableImage(View view) {

        //**** For image 1 ****//
            if (countryName_index==pickedImage1){
                correctResult.setText("CORRECT !!!");
                Marks++;
                correctResult.setTextColor(getResources().getColor(R.color.green));
            }else {
                correctResult.setText("WRONG !!!");
                correctResult.setTextColor(getResources().getColor(R.color.red));
            }

        //**** For image 2 ****//
            if (countryName_index==pickedImage2){
                correctResult.setText("CORRECT !!!");
                Marks++;
                correctResult.setTextColor(getResources().getColor(R.color.green));

            } else {
                correctResult.setText("WRONG !!!");
                correctResult.setTextColor(getResources().getColor(R.color.red));
            }

       //**** For image 3 ****//
            if (countryName_index==pickedImage3){
                correctResult.setText("CORRECT !!!");
                Marks++;
                correctResult.setTextColor(getResources().getColor(R.color.green));
            }else {
                correctResult.setText("WRONG !!!");
                correctResult.setTextColor(getResources().getColor(R.color.red));
            }



           /* if (pickedImage1==guessTheCountry.flags[i]){
                correctResult.setText("Hii");

            } //for image 1

            if (pickedImage2==guessTheCountry.flags[i]){


            }//for image 1

            if (pickedImage3==guessTheCountry.flags[i]){


            } //for image 1*/



    }


   /* public void cliickableImage(View view) {
        //  int value = findArrayIndexInt(threeElementList,values.length);

        while (true) {

            if (k == 2) {
                correctResult.setText("CORRECT !!!");
                k = 0;
            } else {
                wrongResult.setText("INCORRECT !!!");
                k++;
            }
            break;
        }

    }*/


    //------------------ String array index finding -------------------------
    public int findArrayIndex(String[] arr, String value) {

        //if array is null
        if (arr == null) {
            return -1;
        }

        int i = 0;
        //-----browse through array-----
        while (i < arr.length) {
            if (arr[i] == value) {
                return i;
            } else {
                i += 1;
            }
        }

        return -1;
    }
    //end of findArrayIndex method


}