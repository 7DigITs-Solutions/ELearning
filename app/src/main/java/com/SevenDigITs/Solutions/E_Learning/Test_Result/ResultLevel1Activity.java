package com.SevenDigITs.Solutions.E_Learning.Test_Result;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

public class ResultLevel1Activity extends AppCompatActivity {
    // initializing firebase variables
    Firebase firebase;
    private FirebaseAuth mAuth;

    ProgressBar progressBar;
    TextView textViewPresentatge, textViewScore;
    DatabaseReference databaseReference, rootRef;
    String deviceID, score,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11;
    Button button1, button2, button3,button4;
    int sum, sumpersentatge, convertscore1,convertscore2,convertscore3,convertscore4,convertscore5,
            convertscore6,convertscore7,convertscore8,convertscore9,convertscore10,convertscore11;

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String shrd2 = "shared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_level1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        progressBar = (ProgressBar) findViewById(R.id.circle_progress_bar);
        textViewPresentatge = (TextView) findViewById(R.id.presentatage);
        textViewScore = (TextView) findViewById(R.id.score);
        button1 = (Button) findViewById(R.id.re_course);
        button2 = (Button) findViewById(R.id.re_exam);
        button3 = (Button) findViewById(R.id.next_level);
        button4 = (Button) findViewById(R.id.correctAnswerLevel1);

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



                            if (progressBar.getProgress() < 50) {
                                Toast.makeText(ResultLevel1Activity.this,"Your grade is less 50% you must repeat the lesson again ",
                                        Toast.LENGTH_LONG).show();
                                button1.setVisibility(View.VISIBLE);
                                button4.setVisibility(View.VISIBLE);
                            } else if (progressBar.getProgress() > 50 && progressBar.getProgress() < 70) {
                                Toast.makeText(ResultLevel1Activity.this,"Your grade is between 50% and 70% you must repeat the exam again ",
                                        Toast.LENGTH_LONG).show();
                                button2.setVisibility(View.VISIBLE);
                                button4.setVisibility(View.VISIBLE);
                            }else if (progressBar.getProgress() == 100) {
                                Toast.makeText(ResultLevel1Activity.this,"Your grade is 100% you will go to next level",
                                        Toast.LENGTH_LONG).show();
                                button3.setVisibility(View.VISIBLE);
                                button4.setVisibility(View.GONE);
                            } else if (progressBar.getProgress() > 70) {
                                Toast.makeText(ResultLevel1Activity.this,"Your grade is more than 70% you will go to next level",
                                        Toast.LENGTH_LONG).show();
                                button3.setVisibility(View.VISIBLE);
                                button4.setVisibility(View.VISIBLE);
                            }
                        }
                    }, 2000);


                } else {
                    System.out.println("Failed to read user Data");
                    Log.e(TAG, "Failed to read user Data");
                    button1.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", databaseError.toException());
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultLevel1Activity.this, Level1Activity.class);
                startActivity(intent);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultLevel1Activity.this, Level1_Test_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultLevel1Activity.this, Level2Activity.class);
                startActivity(intent);
                finish();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultLevel1Activity.this, CorrectAnswerLevel1.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ResultLevel1Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}