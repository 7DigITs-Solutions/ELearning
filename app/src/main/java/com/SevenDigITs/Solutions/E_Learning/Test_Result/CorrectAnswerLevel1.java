package com.SevenDigITs.Solutions.E_Learning.Test_Result;

import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.SevenDigITs.Solutions.E_Learning.MainActivity;
import com.SevenDigITs.Solutions.E_Learning.R;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CorrectAnswerLevel1 extends AppCompatActivity {

    CardView cardViewq1lvl, cardViewq2lvl, cardViewq3lvl, cardViewq4lvl, cardViewq5lvl,
            cardViewq6lvl, cardViewq7lvl, cardViewq8lvl, cardViewq9lvl, cardViewq10lvl, cardViewq11lvl;

    // initializing firebase variables
    Firebase firebase;
    private FirebaseAuth mAuth;

    DatabaseReference databaseReference, rootRef;
    String deviceID, score, score2, score3, score4, score5, score6, score7, score8, score9, score10, score11;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer_level1);

        /** defining XML object and tag them */
        cardViewq1lvl = (CardView) findViewById(R.id.q1_lv1_cardView_id_correct);
        cardViewq2lvl = (CardView) findViewById(R.id.q2_lv1_cardView_id_correct);
        cardViewq3lvl = (CardView) findViewById(R.id.q3_lv1_cardView_id_correct);
        cardViewq4lvl = (CardView) findViewById(R.id.q4_lv1_cardView_id_correct);
        cardViewq5lvl = (CardView) findViewById(R.id.q5_lv1_cardView_id_correct);
        cardViewq6lvl = (CardView) findViewById(R.id.q6_lv1_cardView_id_correct);
        cardViewq7lvl = (CardView) findViewById(R.id.q7_lv1_cardView_id_correct);
        cardViewq8lvl = (CardView) findViewById(R.id.q8_lv1_cardView_id_correct);
        cardViewq9lvl = (CardView) findViewById(R.id.q9_lv1_cardView_id_correct);
        cardViewq10lvl = (CardView) findViewById(R.id.q10_lv1_cardView_id_correct);
        cardViewq11lvl = (CardView) findViewById(R.id.q11_lv1_cardView_id_correct);


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
                            if (score.equals("0")){
                                cardViewq1lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq1lvl.setVisibility(View.GONE);
                            }


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
                            if (score2.equals("0")){
                                cardViewq2lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq2lvl.setVisibility(View.GONE);
                            }

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
                            if (score3.equals("0")){
                                cardViewq3lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq3lvl.setVisibility(View.GONE);
                            }


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
                            if (score4.equals("0")){
                                cardViewq4lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq4lvl.setVisibility(View.GONE);
                            }

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
                            if (score5.equals("0")){
                                cardViewq5lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq5lvl.setVisibility(View.GONE);
                            }

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
                            if (score6.equals("0")){
                                cardViewq6lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq6lvl.setVisibility(View.GONE);
                            }

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
                            if (score7.equals("0")){
                                cardViewq7lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq7lvl.setVisibility(View.GONE);
                            }

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
                            if (score8.equals("0")){
                                cardViewq8lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq8lvl.setVisibility(View.GONE);
                            }

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
                            if (score9.equals("0")){
                                cardViewq9lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq9lvl.setVisibility(View.GONE);
                            }

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
                            if (score10.equals("0")){
                                cardViewq10lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq10lvl.setVisibility(View.GONE);
                            }

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
                            if (score11.equals("0")){
                                cardViewq11lvl.setVisibility(View.VISIBLE);

                            } else {
                                cardViewq11lvl.setVisibility(View.GONE);
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", databaseError.toException());
            }
        });
    }
}
