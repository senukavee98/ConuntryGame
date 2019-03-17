package com.example.countrygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GuessTheCountry extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //ImageView declearation
    private ImageView countryImage;
    private Button start_game_button;
    private Button nextButton;
    private Button submitButton;
    private Spinner spinner;
    private TextView correctAnswer;
    private TextView wrongAnswer;
    private TextView finalAnswer;
    private int pickedId;
    public static final int LOG_TAG = GuessTheCountry.class.getModifiers();


    //Random object
    Random random = new Random();


    //Flag Array
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

    String[] country_name = new String[]{

            "Andorra", "United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Anguilla", "Albania", "Armenia", "Netherlands Antilles",
            "Angola", "Antarctica", "Argentina", "American Samoa", "Austria", "Australia", "Aruba", "\u00c5land Islands", "Azerbaijan", "Bosnia and Herzegovina",
            "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Burundi", "Benin", "Saint Barthélemy",
            "Bermuda", "Brunei Darussalam", "Bolivia, Plurinational State of", "Caribbean Netherlands", "Brazil", "Bahamas", "Bhutan", "Bouvet Island", "Botswana", "Belarus", "Belize",
            "Canada", "Cocos (Keeling) Islands", "Congo, the Democratic Republic of the", "Central African Republic", "Congo", "Switzerland", "C\u00f4te d'Ivoire", "Cook Islands", "Chile", "Cameroon", "China", "Colombia", "Costa Rica", "Cuba",
            "Cape Verde", "Cura\u00e7ao", "Christmas Island", "Cyprus", "Czech Republic", "Germany", "Djibouti", "Denmark", "Dominica", "Dominican Republic", "Algeria", "Ecuador",
            "Estonia", "Egypt", "Western Sahara", "Eritrea", "Spain", "Ethiopia", "Europe", "Finland", "Fiji", "Falkland Islands (Malvinas)",
            "Micronesia, Federated States of", "Faroe Islands", "France", "Gabon", "England", "Northern Ireland", "Scotland", "Wales", "United Kingdom",
            "Grenada", "Georgia", "French Guiana", "Guernsey", "Ghana", "Gibraltar", "Greenland", "Gambia", "Guinea", "Guadeloupe",
            "Equatorial Guinea", "Greece", "South Georgia and the South Sandwich Islands", "Guatemala", "Guam", "Guinea-Bissau", "Guyana", "Hong Kong", "Heard Island and McDonald Islands", "Honduras", "Croatia", "Haiti", "Hungary", "Indonesia", "Ireland",
            "Israel", "Isle of Man", "India", "British Indian Ocean Territory", "Iraq", "Iran, Islamic Republic of", "Iceland", "Italy", "Jersey", "Jamaica", "Jordan", "Japan",
            "Kenya", "Kyrgyzstan", "Cambodia", "Kiribati", "Comoros", "Saint Kitts and Nevis",
            "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Cayman Islands", "Kazakhstan", "Lao People's Democratic Republic", "Lebanon", "Saint Lucia", "Liechtenstein",
            "Sri Lanka", "Liberia", "Lesotho", "Lithuania", "Luxembourg", "Latvia", "Libya", "Morocco", "Monaco", "Moldova, Republic of", "Montenegro", "Saint Martin", "Madagascar", "Marshall Islands",
            "Macedonia, the former Yugoslav Republic of", "Mali", "Myanmar", "Mongolia", "Macao", "Northern Mariana Islands", "Martinique", "Mauritania",
            "Montserrat", "Malta", "Mauritius", "Maldives", "Malawi", "Mexico", "Malaysia", "Mozambique", "Namibia", "New Caledonia", "Niger", "Norfolk Island",
            "Nigeria", "Nicaragua", "Netherlands", "Norway", "Nepal", "Nauru", "Niue", "New Zealand", "Oman", "Panama", "Peru", "French Polynesia", "Papua New Guinea", "Philippines",
            "Pakistan", "Poland", "Saint Pierre and Miquelon", "Pitcairn", "Puerto Rico", "Palestine", "Portugal", "Palau", "Paraguay", "Qatar", "Réunion", "Romania", "Serbia", "Russian Federation",
            "Rwanda", "Saudi Arabia", "Solomon Islands", "Seychelles", "Sudan", "Sweden", "Singapore", "Saint Helena, Ascension and Tristan da Cunha", "Slovenia", "Svalbard and Jan Mayen Islands",
            "Slovakia", "Sierra Leone", "San Marino", "Senegal", "Somalia", "Suriname", "South Sudan", "Sao Tome and Principe", "El Salvador",
            "Sint Maarten (Dutch part)", "Syrian Arab Republic", "Swaziland", "Turks and Caicos Islands", "Chad", "French Southern Territories", "Togo", "Thailand", "Tajikistan", "Tokelau",
            "Timor-Leste", "Turkmenistan", "Tunisia", "Tonga", "Turkey", "Trinidad and Tobago", "Tuvalu", "Taiwan", "Tanzania, United Republic of", "Ukraine", "Uganda", "US Minor Outlying Islands", "United States", "Uruguay", "Uzbekistan",
            "Holy See (Vatican City State)", "Saint Vincent and the Grenadines", "Venezuela, Bolivarian Republic of", "Virgin Islands, British", "Virgin Islands, U.S.", "Viet Nam", "Vanuatu", "Wallis and Futuna Islands", "Kosovo", "Samoa", "Yemen", "Mayotte", "South Africa",
            "Zambia", "Zimbabwe"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_country);

        countryImage = findViewById(R.id.CountryFlag);
      //  countryImage.setImageResource(R.drawable.ae);

        nextButton = findViewById(R.id.next);
        submitButton = findViewById(R.id.submit);

        spinner = findViewById(R.id.spinner);
        correctAnswer = findViewById(R.id.correct_answer);
        wrongAnswer = findViewById(R.id.wrong_answer);
        finalAnswer = findViewById(R.id.final_answer);
        start_game_button= findViewById(R.id.gameStartbtn);


        //----------spinner click listener-----------------------
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                country_name);
        spinner.setAdapter(myAdapter);

    }




    //-------------------------- Random flag change method ---------------------------//
    int pickedImage = 0, lastPicked = 0;
    boolean status1 = false , status2 = false;

    public void nextFlag(View view) {

       start_game_button.setVisibility(View.INVISIBLE);
        correctAnswer.setText("");
        wrongAnswer.setText("");
        finalAnswer.setText("");
        submitButton.setVisibility(View.VISIBLE);

     //-------remove duplications------//
        do {
            pickedImage = random.nextInt(flags.length);

        } while (pickedImage == lastPicked);

    // Equal to the last picked to the picked image
        lastPicked = pickedImage;
     //   pickedId = findArrayIndexInt(flags,pickedImage);

        //----------------- display random image -----------------------//
        countryImage.setImageResource(flags[pickedImage]);


   }

   public void submitSelected(View view){
       // nextButton.setVisibility(View.VISIBLE);
       correctAnswer.setVisibility(View.VISIBLE);
       wrongAnswer.setVisibility(View.VISIBLE);
       finalAnswer.setVisibility(View.VISIBLE);
       submitButton.setVisibility(View.INVISIBLE);
       if (status1){
           correctAnswer.setText(feedback1);
           status1 = false;

       }else if (status2){
           wrongAnswer.setText(feedback1);
           finalAnswer.setText(feedback2);

       }

   }




//-------------------Spinner auto generated methods-----------------------

    String feedback1,feedback2;
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (pickedImage==position){
            feedback1 = "CONGRATULATIONS, The Answer is Correct !!!";
            status1 = true;
        }else{
            feedback1="SORRY, The Answer is Incorrect !!!";
            position=pickedImage;
            status2=true;

            feedback2=parent.getItemAtPosition(position).toString();
        }
        /*//------ On selecting a spinner item ----------
        String item = parent.getItemAtPosition(position).toString();

        //---------- getting indexes of elements --------
        int arrayIndexOfCountry = findArrayIndex(country_name,item);
        int index = flags[random.nextInt(flags.length)];
        int arrayIndexOfFlag = findArrayIndexInt(flags,index);

        String cAns,wAns,fAns;

        if (arrayIndexOfFlag == arrayIndexOfCountry){
            cAns = " CONGRATULATIONS, The Answer is Correct !!!";
            correctAnswer.setText(cAns);
        }else {

            wAns = "SORRY, The Answer is Incorrect !!!";
            wrongAnswer.setText(wAns);

            fAns = country_name[arrayIndexOfFlag];
            finalAnswer.setText(fAns);
        }*/
        // Showing selected spinner item


      //  Toast.makeText(parent.getContext(), "Selected: " + position, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    //------------------ String array index finding -------------------------
    public int findArrayIndex(String[] arr, String spinnedWord) {

        //if array is null
        if (arr ==null){
            return -1;
        }

        int i=0;
        //-----browse through array-----
        while(i < arr.length){
            if (arr[i]==spinnedWord){
                return i;
            }else {
                i+=1;
            }
        }

        return -1;
    }
    //end of findArrayIndex method




    //------------------ Integer array index finding -------------------------
    public int findArrayIndexInt(Integer[] arr, int value) {

        //if array is null
        if (arr ==null){
            return -1;
        }

        int i=0;
        //-----browse through array-----
        while(i < arr.length){
            if (arr[i]==value){
                return i;
            }else {
                i+=1;
            }
        }

        return -1;
    }
    //end of findArrayIndexInt method



    //---------------------------getters and setters------------------------------

    public Integer[] getFlags() {
        return flags;
    }

    public void setFlags(Integer[] flags) {
        this.flags = flags;
    }

    public String[] getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String[] country_name) {
        this.country_name = country_name;
    }
}