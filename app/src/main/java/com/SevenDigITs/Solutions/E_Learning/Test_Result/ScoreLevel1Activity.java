package com.SevenDigITs.Solutions.E_Learning.Test_Result;

import android.content.Intent;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.SevenDigITs.Solutions.E_Learning.Level2.Level2Activity;
import com.SevenDigITs.Solutions.E_Learning.MainActivity;
import com.SevenDigITs.Solutions.E_Learning.R;
import com.SevenDigITs.Solutions.E_Learning.level1.Level1Activity;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ScoreLevel1Activity extends AppCompatActivity {

    // initializing firebase variables
    Firebase firebase;
    private FirebaseAuth mAuth;

    ProgressBar progressBar;
    TextView textViewPresentatge, textViewScore;
    DatabaseReference databaseReference, rootRef;
    String deviceID, score,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11;

    int sum, sumpersentatge, convertscore1,convertscore2,convertscore3,convertscore4,convertscore5,
            convertscore6,convertscore7,convertscore8,convertscore9,convertscore10,convertscore11;

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String shrd2 = "shared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        progressBar = (ProgressBar) findViewById(R.id.circle_progress_barLvl1);
        textViewPresentatge = (TextView) findViewById(R.id.presentatageLvl1);
        textViewScore = (TextView) findViewById(R.id.scoreLvl1);


        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        rootRef = databaseReference.child("Users" + deviceID);
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get map of users in datasnapshot
                if (dataSnapshot.child("Level 1 Answers").exists()) {

                    rootRef.child("Level 1 Answers").child("Question 1").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score = name.toString().trim();
                            System.out.println(score);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 2").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score2 = name.toString().trim();
                            System.out.println(score2);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 3").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score3 = name.toString().trim();
                            System.out.println(score3);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 4").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score4 = name.toString().trim();
                            System.out.println(score4);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 5").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score5 = name.toString().trim();
                            System.out.println(score5);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 6").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score6 = name.toString().trim();
                            System.out.println(score6);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 7").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score7 = name.toString().trim();
                            System.out.println(score7);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 8").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score8 = name.toString().trim();
                            System.out.println(score8);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 9").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score9 = name.toString().trim();
                            System.out.println(score9);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 10").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score10 = name.toString().trim();
                            System.out.println(score10);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                    rootRef.child("Level 1 Answers").child("Question 11").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String name = dataSnapshot.getValue(String.class);
                            score11 = name.toString().trim();
                            System.out.println(score11);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //for calculating score
                            //first convert to int
                            convertscore1 = Integer.parseInt(score);
                            convertscore2 = Integer.parseInt(score2);
                            convertscore3 = Integer.parseInt(score3);
                            convertscore4 = Integer.parseInt(score4);
                            convertscore5 = Integer.parseInt(score5);
                            convertscore6 = Integer.parseInt(score6);
                            convertscore7 = Integer.parseInt(score7);
                            convertscore8 = Integer.parseInt(score8);
                            convertscore9 = Integer.parseInt(score9);
                            convertscore10 = Integer.parseInt(score10);
                            convertscore11 = Integer.parseInt(score11);

                            //then caculate and sum it
                            sum=convertscore1
                                    + convertscore2
                                    + convertscore3
                                    + convertscore4
                                    + convertscore5
                                    + convertscore6
                                    + convertscore7
                                    + convertscore8
                                    + convertscore9
                                    + convertscore10
                                    + convertscore11
                            ;

                            //then set it to text
                            textViewScore.setText(String.valueOf(sum+"/11"));

                            //then calculate persntatge %
                            //take sum and divid it into 5 and * to 100

                            sumpersentatge = (int) ((sum / 11.0) * 100.0);


                            //then set it in progress bar
                            progressBar.setProgress(sumpersentatge);
                            textViewPresentatge.setText(String.valueOf(sumpersentatge) + " %");


                            //fire base set data in it
                            Firebase.setAndroidContext(getApplicationContext());
                            deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                            firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
                            mAuth = FirebaseAuth.getInstance();

                            Firebase firebaseScore = firebase.child("Level 1 Answers").child("Level 1 Score");
                            firebaseScore.setValue(sumpersentatge);



                        }
                    }, 2000);


                } else {
                    System.out.println("Failed to read user Data");
                    Log.e(TAG, "Failed to read user Data");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", databaseError.toException());
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ScoreLevel1Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
