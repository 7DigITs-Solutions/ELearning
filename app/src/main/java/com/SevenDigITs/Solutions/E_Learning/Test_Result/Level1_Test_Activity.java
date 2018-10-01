package com.SevenDigITs.Solutions.E_Learning.Test_Result;

import android.content.Intent;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.SevenDigITs.Solutions.E_Learning.R;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class Level1_Test_Activity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    // initializing firebase variables
    Firebase firebase;
    private FirebaseAuth mAuth;

    // initializing action variables
    Button  btnq1lvl, btnq2lvl, btnq3lvl, btnq4lvl, btnq5lvl, btnq6lvl, btnq7lvl, btnq8lvl, btnq9lvl, btnq10lvl, btnq11lvl;
    RadioButton q1Ans1lvl, q1Ans2lvl, q1Ans3lvl, q1Ans4lvl, q1Ans5lvl, q1Ans6lvl;
    RadioButton q2Ans1lvl, q2Ans2lvl, q2Ans3lvl, q2Ans4lvl, q2Ans5lvl, q2Ans6lvl;
    RadioButton q3Ans1lvl, q3Ans2lvl;
    RadioButton q4Ans1lvl, q4Ans2lvl, q4Ans3lvl, q4Ans4lvl,q4Ans5lvl;
    RadioButton q5Ans1lvl, q5Ans2lvl;
    RadioButton q6Ans1lvl, q6Ans2lvl;
    RadioButton q7Ans1lvl, q7Ans2lvl;
    RadioButton q8Ans1lvl, q8Ans2lvl, q8Ans3lvl, q8Ans4lvl;
    RadioButton q9Ans1lvl, q9Ans2lvl, q9Ans3lvl, q9Ans4lvl;
    RadioButton q10Ans1lvl, q10Ans2lvl, q10Ans3lvl, q10Ans4lvl;
    RadioButton q11Ans1lvl, q11Ans2lvl, q11Ans3lvl, q11Ans4lvl;


    RadioGroup r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11;
    CardView cardViewq1lvl,cardViewq2lvl,cardViewq3lvl,cardViewq4lvl,cardViewq5lvl,
            cardViewq6lvl,cardViewq7lvl,cardViewq8lvl,cardViewq9lvl,cardViewq10lvl,cardViewq11lvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_test);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        /** defining XML object and tag them */

        cardViewq1lvl = (CardView) findViewById(R.id.q1_lv1_cardView_id);
        cardViewq2lvl = (CardView) findViewById(R.id.q2_lv1_cardView_id);
        cardViewq3lvl = (CardView) findViewById(R.id.q3_lv1_cardView_id);
        cardViewq4lvl = (CardView) findViewById(R.id.q4_lv1_cardView_id);
        cardViewq5lvl = (CardView) findViewById(R.id.q5_lv1_cardView_id);
        cardViewq6lvl = (CardView) findViewById(R.id.q6_lv1_cardView_id);
        cardViewq7lvl = (CardView) findViewById(R.id.q7_lv1_cardView_id);
        cardViewq8lvl = (CardView) findViewById(R.id.q8_lv1_cardView_id);
        cardViewq9lvl = (CardView) findViewById(R.id.q9_lv1_cardView_id);
        cardViewq10lvl = (CardView) findViewById(R.id.q10_lv1_cardView_id);
        cardViewq11lvl = (CardView) findViewById(R.id.q11_lv1_cardView_id);


        r1 = (RadioGroup) findViewById(R.id.radioG1_lv1_q1);

        q1Ans1lvl = (RadioButton) findViewById(R.id.Q1Res1_lv1);
        q1Ans2lvl = (RadioButton) findViewById(R.id.Q1Res2_lv1);
        q1Ans3lvl = (RadioButton) findViewById(R.id.Q1Res3_lv1);
        q1Ans4lvl = (RadioButton) findViewById(R.id.Q1Res4_lv1);
        q1Ans5lvl = (RadioButton) findViewById(R.id.Q1Res5_lv1);
        q1Ans6lvl = (RadioButton) findViewById(R.id.Q1Res6_lv1);
        btnq1lvl =  (Button) findViewById(R.id.btnQ1_level1);


        q2Ans1lvl = (RadioButton) findViewById(R.id.Q2Res1_lv1);
        q2Ans2lvl = (RadioButton) findViewById(R.id.Q2Res2_lv1);
        q2Ans3lvl = (RadioButton) findViewById(R.id.Q2Res3_lv1);
        q2Ans4lvl = (RadioButton) findViewById(R.id.Q2Res4_lv1);
        q2Ans5lvl = (RadioButton) findViewById(R.id.Q2Res5_lv1);
        q2Ans6lvl = (RadioButton) findViewById(R.id.Q2Res6_lv1);
        btnq2lvl =  (Button) findViewById(R.id.btnQ2_level1);

        q3Ans1lvl = (RadioButton) findViewById(R.id.Q3Res1_lv1);
        q3Ans2lvl = (RadioButton) findViewById(R.id.Q3Res2_lv1);
        btnq3lvl = (Button) findViewById(R.id.btnQ3_level1);

        q4Ans1lvl = (RadioButton) findViewById(R.id.Q4Res1_lv1);
        q4Ans2lvl = (RadioButton) findViewById(R.id.Q4Res2_lv1);
        q4Ans3lvl = (RadioButton) findViewById(R.id.Q4Res3_lv1);
        q4Ans4lvl = (RadioButton) findViewById(R.id.Q4Res4_lv1);
        q4Ans5lvl = (RadioButton) findViewById(R.id.Q4Res5_lv1);
        btnq4lvl = (Button) findViewById(R.id.btnQ4_level1);

        q5Ans1lvl = (RadioButton) findViewById(R.id.Q5Res1_lv1);
        q5Ans2lvl = (RadioButton) findViewById(R.id.Q5Res2_lv1);
        btnq5lvl = (Button) findViewById(R.id.btnQ5_level1);

        q6Ans1lvl = (RadioButton) findViewById(R.id.Q6Res1_lv1);
        q6Ans2lvl = (RadioButton) findViewById(R.id.Q6Res2_lv1);
        btnq6lvl = (Button) findViewById(R.id.btnQ6_level1);

        q7Ans1lvl = (RadioButton) findViewById(R.id.Q7Res1_lv1);
        q7Ans2lvl = (RadioButton) findViewById(R.id.Q7Res2_lv1);
        btnq7lvl = (Button) findViewById(R.id.btnQ7_level1);

        q8Ans1lvl = (RadioButton) findViewById(R.id.Q8Res1_lv1);
        q8Ans2lvl = (RadioButton) findViewById(R.id.Q8Res2_lv1);
        q8Ans3lvl = (RadioButton) findViewById(R.id.Q8Res3_lv1);
        q8Ans4lvl = (RadioButton) findViewById(R.id.Q8Res4_lv1);
        btnq8lvl = (Button) findViewById(R.id.btnQ8_level1);

        q9Ans1lvl = (RadioButton) findViewById(R.id.Q9Res1_lv1);
        q9Ans2lvl = (RadioButton) findViewById(R.id.Q9Res2_lv1);
        q9Ans3lvl = (RadioButton) findViewById(R.id.Q9Res3_lv1);
        q9Ans4lvl = (RadioButton) findViewById(R.id.Q9Res4_lv1);
        btnq9lvl = (Button) findViewById(R.id.btnQ9_level1);

        q10Ans1lvl = (RadioButton) findViewById(R.id.Q10Res1_lv1);
        q10Ans2lvl = (RadioButton) findViewById(R.id.Q10Res2_lv1);
        q10Ans3lvl = (RadioButton) findViewById(R.id.Q10Res3_lv1);
        q10Ans4lvl = (RadioButton) findViewById(R.id.Q10Res4_lv1);
        btnq10lvl = (Button) findViewById(R.id.btnQ10_level1);

        q11Ans1lvl = (RadioButton) findViewById(R.id.Q11Res1_lv1);
        q11Ans2lvl = (RadioButton) findViewById(R.id.Q11Res2_lv1);
        q11Ans3lvl = (RadioButton) findViewById(R.id.Q11Res3_lv1);
        q11Ans4lvl = (RadioButton) findViewById(R.id.Q11Res4_lv1);
        btnq11lvl = (Button) findViewById(R.id.btnQ11_level1);




        /** get device id for create a user answer of the test using his mobile id in firebase  */
        Firebase.setAndroidContext(this);
        /** fire base set data in it */
        Firebase.setAndroidContext(getApplicationContext());
        String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        /** action for add answers questions to firebase */
        btnq1lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q1Ans1lvl.isChecked() && !q1Ans2lvl.isChecked()
                        && !q1Ans3lvl.isChecked() && !q1Ans4lvl.isChecked()
                        && !q1Ans5lvl.isChecked() &&  !q1Ans6lvl.isChecked()){

                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_SHORT).show();
                }
                if (q1Ans1lvl.isChecked() || q1Ans2lvl.isChecked()
                        || q1Ans3lvl.isChecked() || q1Ans4lvl.isChecked()
                        || q1Ans5lvl.isChecked() ||  q1Ans6lvl.isChecked()){
                    if (q1Ans1lvl.isChecked()) {
                        Firebase firebaseQ1 = firebase.child("Level 1 Answers").child("Question 1");
                        firebaseQ1.setValue("0");
                    }
                    if (q1Ans2lvl.isChecked()) {
                        Firebase firebaseQ1 = firebase.child("Level 1 Answers").child("Question 1");
                        firebaseQ1.setValue("0");
                    }
                    if (q1Ans3lvl.isChecked()) {
                        Firebase firebaseQ1 = firebase.child("Level 1 Answers").child("Question 1");
                        firebaseQ1.setValue("0");
                    }
                    if (q1Ans4lvl.isChecked()) {
                        Firebase firebaseQ1 = firebase.child("Level 1 Answers").child("Question 1");
                        firebaseQ1.setValue("1");
                    }
                    if (q1Ans5lvl.isChecked()) {
                        Firebase firebaseQ1 = firebase.child("Level 1 Answers").child("Question 1");
                        firebaseQ1.setValue("0");
                    }
                    if (q1Ans6lvl.isChecked()) {
                        Firebase firebaseQ1 = firebase.child("Level 1 Answers").child("Question 1");
                        firebaseQ1.setValue("0");
                    }
                    cardViewq1lvl.setVisibility(View.GONE);
                    cardViewq2lvl.setVisibility(View.VISIBLE);
                }
            }
        });

        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        btnq2lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q2Ans1lvl.isChecked() && !q2Ans2lvl.isChecked()
                        && !q2Ans3lvl.isChecked() && !q2Ans4lvl.isChecked()
                        && !q2Ans5lvl.isChecked() && !q2Ans6lvl.isChecked()) {

                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();

                }
                if (q2Ans1lvl.isChecked() || q2Ans2lvl.isChecked()
                        || q2Ans3lvl.isChecked() || q2Ans4lvl.isChecked()
                        || q2Ans5lvl.isChecked() || q2Ans6lvl.isChecked()) {

                    if (q2Ans1lvl.isChecked()) {
                        Firebase firebaseQ2 = firebase.child("Level 1 Answers").child("Question 2");
                        firebaseQ2.setValue("0");
                    }
                    if (q2Ans2lvl.isChecked()) {
                        Firebase firebaseQ2 = firebase.child("Level 1 Answers").child("Question 2");
                        firebaseQ2.setValue("0");
                    }
                    if (q2Ans3lvl.isChecked()) {
                        Firebase firebaseQ2 = firebase.child("Level 1 Answers").child("Question 2");
                        firebaseQ2.setValue("1");
                    }
                    if (q2Ans4lvl.isChecked()) {
                        Firebase firebaseQ2 = firebase.child("Level 1 Answers").child("Question 2");
                        firebaseQ2.setValue("0");
                    }
                    if (q2Ans5lvl.isChecked()) {
                        Firebase firebaseQ2 = firebase.child("Level 1 Answers").child("Question 2");
                        firebaseQ2.setValue("0");
                    }
                    if (q2Ans6lvl.isChecked()) {
                        Firebase firebaseQ2 = firebase.child("Level 1 Answers").child("Question 2");
                        firebaseQ2.setValue("0");
                    }
                    cardViewq2lvl.setVisibility(View.GONE);
                    cardViewq3lvl.setVisibility(View.VISIBLE);
                }
            }
        });

        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        btnq3lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q3Ans1lvl.isChecked() && !q3Ans2lvl.isChecked()) {

                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();

                }
                if (q3Ans1lvl.isChecked() || q3Ans2lvl.isChecked()) {
                    if (q3Ans1lvl.isChecked()) {
                        Firebase firebaseQ3 = firebase.child("Level 1 Answers").child("Question 3");
                        firebaseQ3.setValue("0");
                    }

                    if (q3Ans2lvl.isChecked()) {
                        Firebase firebaseQ3 = firebase.child("Level 1 Answers").child("Question 3");
                        firebaseQ3.setValue("1");
                    }

                    cardViewq3lvl.setVisibility(View.GONE);
                    cardViewq4lvl.setVisibility(View.VISIBLE);
                }
            }
        });


        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        btnq4lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q4Ans1lvl.isChecked() && !q4Ans2lvl.isChecked()
                        && !q4Ans3lvl.isChecked() && !q4Ans4lvl.isChecked()
                        && !q4Ans5lvl.isChecked()) {
                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();
                }
                if (q4Ans1lvl.isChecked() || q4Ans2lvl.isChecked()
                        || q4Ans3lvl.isChecked() || q4Ans4lvl.isChecked()
                        || q4Ans5lvl.isChecked()) {
                    if (q4Ans1lvl.isChecked()) {
                        Firebase firebaseQ4 = firebase.child("Level 1 Answers").child("Question 4");
                        firebaseQ4.setValue("1");
                    }

                    if (q4Ans2lvl.isChecked()) {
                        Firebase firebaseQ4 = firebase.child("Level 1 Answers").child("Question 4");
                        firebaseQ4.setValue("0");
                    }
                    if (q4Ans3lvl.isChecked()) {
                        Firebase firebaseQ4 = firebase.child("Level 1 Answers").child("Question 4");
                        firebaseQ4.setValue("0");
                    }
                    if (q4Ans4lvl.isChecked()) {
                        Firebase firebaseQ4 = firebase.child("Level 1 Answers").child("Question 4");
                        firebaseQ4.setValue("0");
                    }
                    if (q4Ans5lvl.isChecked()) {
                        Firebase firebaseQ4 = firebase.child("Level 1 Answers").child("Question 4");
                        firebaseQ4.setValue("0");
                    }
                    cardViewq4lvl.setVisibility(View.GONE);
                    cardViewq5lvl.setVisibility(View.VISIBLE);

                }
            }
        });
        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        btnq5lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q5Ans1lvl.isChecked() && !q5Ans2lvl.isChecked()) {

                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();

                }
                if (q5Ans1lvl.isChecked() || q5Ans2lvl.isChecked()) {
                    if (q5Ans1lvl.isChecked()) {
                        Firebase firebaseQ5 = firebase.child("Level 1 Answers").child("Question 5");
                        firebaseQ5.setValue("0");
                    }

                    if (q5Ans2lvl.isChecked()) {
                        Firebase firebaseQ5 = firebase.child("Level 1 Answers").child("Question 5");
                        firebaseQ5.setValue("1");
                    }

                    cardViewq5lvl.setVisibility(View.GONE);
                    cardViewq6lvl.setVisibility(View.VISIBLE);
                }
            }
        });
        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        btnq6lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q6Ans1lvl.isChecked() && !q6Ans2lvl.isChecked()) {

                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();

                }
                if (q6Ans1lvl.isChecked() || q6Ans2lvl.isChecked()) {
                    if (q6Ans1lvl.isChecked()) {
                        Firebase firebaseQ6 = firebase.child("Level 1 Answers").child("Question 6");
                        firebaseQ6.setValue("1");
                    }

                    if (q6Ans2lvl.isChecked()) {
                        Firebase firebaseQ6 = firebase.child("Level 1 Answers").child("Question 6");
                        firebaseQ6.setValue("0");
                    }
                    cardViewq6lvl.setVisibility(View.GONE);
                    cardViewq7lvl.setVisibility(View.VISIBLE);
                }
            }
        });
        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        btnq7lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q7Ans1lvl.isChecked() && !q7Ans2lvl.isChecked()) {
                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();

                }
                if (q7Ans1lvl.isChecked() || q7Ans2lvl.isChecked()) {
                    if (q7Ans1lvl.isChecked()) {
                        Firebase firebaseQ7 = firebase.child("Level 1 Answers").child("Question 7");
                        firebaseQ7.setValue("1");
                    }

                    if (q7Ans2lvl.isChecked()) {
                        Firebase firebaseQ7 = firebase.child("Level 1 Answers").child("Question 7");
                        firebaseQ7.setValue("0");
                    }
                    cardViewq7lvl.setVisibility(View.GONE);
                    cardViewq8lvl.setVisibility(View.VISIBLE);
                }
            }
        });
        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();
        btnq8lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q8Ans1lvl.isChecked() && !q8Ans2lvl.isChecked()
                        && !q8Ans3lvl.isChecked() && !q8Ans4lvl.isChecked()) {

                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();
                }
                if (q8Ans1lvl.isChecked() || q8Ans2lvl.isChecked()
                        || q8Ans3lvl.isChecked() || q8Ans4lvl.isChecked()) {
                    if (q8Ans1lvl.isChecked()) {
                        Firebase firebaseQ8 = firebase.child("Level 1 Answers").child("Question 8");
                        firebaseQ8.setValue("0");
                    }

                    if (q8Ans2lvl.isChecked()) {
                        Firebase firebaseQ8 = firebase.child("Level 1 Answers").child("Question 8");
                        firebaseQ8.setValue("0");
                    }
                    if (q8Ans3lvl.isChecked()) {
                        Firebase firebaseQ8 = firebase.child("Level 1 Answers").child("Question 8");
                        firebaseQ8.setValue("1");
                    }
                    if (q8Ans4lvl.isChecked()) {
                        Firebase firebaseQ8 = firebase.child("Level 1 Answers").child("Question 8");
                        firebaseQ8.setValue("0");
                    }
                    cardViewq8lvl.setVisibility(View.GONE);
                    cardViewq9lvl.setVisibility(View.VISIBLE);
                }
            }
        });

        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();
        btnq9lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q9Ans1lvl.isChecked() && !q9Ans2lvl.isChecked()
                        && !q9Ans3lvl.isChecked() && !q9Ans4lvl.isChecked()) {

                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();
                }
                if (q9Ans1lvl.isChecked() || q9Ans2lvl.isChecked()
                        || q9Ans3lvl.isChecked() || q9Ans4lvl.isChecked()) {
                    if (q9Ans1lvl.isChecked()) {
                        Firebase firebaseQ9 = firebase.child("Level 1 Answers").child("Question 9");
                        firebaseQ9.setValue("0");
                    }

                    if (q9Ans2lvl.isChecked()) {
                        Firebase firebaseQ9 = firebase.child("Level 1 Answers").child("Question 9");
                        firebaseQ9.setValue("0");
                    }
                    if (q9Ans3lvl.isChecked()) {
                        Firebase firebaseQ9 = firebase.child("Level 1 Answers").child("Question 9");
                        firebaseQ9.setValue("0");
                    }
                    if (q9Ans4lvl.isChecked()) {
                        Firebase firebaseQ9 = firebase.child("Level 1 Answers").child("Question 9");
                        firebaseQ9.setValue("1");
                    }
                    cardViewq9lvl.setVisibility(View.GONE);
                    cardViewq10lvl.setVisibility(View.VISIBLE);
                }
            }
        });
        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();
        btnq10lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q10Ans1lvl.isChecked() && !q10Ans2lvl.isChecked()
                        && !q10Ans3lvl.isChecked() && !q10Ans4lvl.isChecked()) {

                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();
                }
                if (q10Ans1lvl.isChecked() || q10Ans2lvl.isChecked()
                        || q10Ans3lvl.isChecked() || q10Ans4lvl.isChecked()) {
                    if (q10Ans1lvl.isChecked()) {
                        Firebase firebaseQ10 = firebase.child("Level 1 Answers").child("Question 10");
                        firebaseQ10.setValue("0");
                    }
                    if (q10Ans2lvl.isChecked()) {
                        Firebase firebaseQ10 = firebase.child("Level 1 Answers").child("Question 10");
                        firebaseQ10.setValue("0");
                    }
                    if (q10Ans3lvl.isChecked()) {
                        Firebase firebaseQ10 = firebase.child("Level 1 Answers").child("Question 10");
                        firebaseQ10.setValue("0");
                    }
                    if (q10Ans4lvl.isChecked()) {
                        Firebase firebaseQ10 = firebase.child("Level 1 Answers").child("Question 10");
                        firebaseQ10.setValue("1");
                    }
                    cardViewq10lvl.setVisibility(View.GONE);
                    cardViewq11lvl.setVisibility(View.VISIBLE);
                }
            }
        });
        Firebase.setAndroidContext(this);
        //fire base set data in it
        Firebase.setAndroidContext(getApplicationContext());
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();
        btnq11lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q11Ans1lvl.isChecked() && !q11Ans2lvl.isChecked()
                        && !q11Ans3lvl.isChecked() && !q11Ans4lvl.isChecked()) {

                    Toast.makeText(Level1_Test_Activity.this
                            , "You Must Choice From Answers", Toast.LENGTH_LONG).show();
                }
                if (q11Ans1lvl.isChecked() || q11Ans2lvl.isChecked()
                        || q11Ans3lvl.isChecked() || q11Ans4lvl.isChecked()) {
                    if (q11Ans1lvl.isChecked()) {
                        Firebase firebaseQ11 = firebase.child("Level 1 Answers").child("Question 11");
                        firebaseQ11.setValue("0");
                    }
                    if (q11Ans2lvl.isChecked()) {
                        Firebase firebaseQ11 = firebase.child("Level 1 Answers").child("Question 11");
                        firebaseQ11.setValue("0");
                    }
                    if (q11Ans3lvl.isChecked()) {
                        Firebase firebaseQ11 = firebase.child("Level 1 Answers").child("Question 11");
                        firebaseQ11.setValue("1");
                    }
                    if (q11Ans4lvl.isChecked()) {
                        Firebase firebaseQ11 = firebase.child("Level 1 Answers").child("Question 11");
                        firebaseQ11.setValue("0");
                    }
                    Intent intent = new Intent(Level1_Test_Activity.this, ResultLevel1Activity.class);
                    startActivity(intent);
                    finish();
                    //cardViewq11lvl.setVisibility(View.GONE);
                    //cardViewq11lvl.setVisibility(View.VISIBLE);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please Click BACK Again to Exit Exam", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}