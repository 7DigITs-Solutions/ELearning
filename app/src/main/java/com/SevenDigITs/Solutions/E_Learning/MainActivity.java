package com.SevenDigITs.Solutions.E_Learning;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.SevenDigITs.Solutions.E_Learning.Level2.Level2Activity;
import com.SevenDigITs.Solutions.E_Learning.Level2.Level2_Lesson1_Activity;
import com.SevenDigITs.Solutions.E_Learning.Level2.Level2_Lesson2_Activity;
import com.SevenDigITs.Solutions.E_Learning.Level2.Level2_Lesson3_Activity;
import com.SevenDigITs.Solutions.E_Learning.Signin_Signup.SignInActivity;
import com.SevenDigITs.Solutions.E_Learning.Test_Result.ResultLevel1Activity;
import com.SevenDigITs.Solutions.E_Learning.Test_Result.ResultLevel2Activity;
import com.SevenDigITs.Solutions.E_Learning.Test_Result.ScoreLevel1Activity;
import com.SevenDigITs.Solutions.E_Learning.Test_Result.ScoreLevel2Activity;
import com.SevenDigITs.Solutions.E_Learning.level1.Level1Activity;
import com.SevenDigITs.Solutions.E_Learning.level1.Level1_Lesson1_Activity;
import com.SevenDigITs.Solutions.E_Learning.level1.Level1_Lesson2_Activity;
import com.SevenDigITs.Solutions.E_Learning.level1.Level1_Lesson3_Activity;
import com.SevenDigITs.Solutions.E_Learning.level1.Level1_Lesson4_Activity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //initializing
    boolean doubleBackToExitPressedOnce = false;

    Intent intentLessone1, intentLessone2;
    private static final String TAG = MainActivity.class.getSimpleName();
    CardView overView, cLevel1, cLevel2;
    Intent intentLevel1, intentLevel2;

    CardView linearLayoutSession;
    Button buttonsession;

    // for open session
    public static final String PREFS_NAME = "LoginPrefs";


    // menu initializing
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;


    private String deviceID, UserCourse;
    DatabaseReference databaseReference, rootRef;

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView courseName = (TextView) findViewById(R.id.courseName);
        //  final TextView Continue = (TextView) findViewById(R.id.CourseContinue);
        final TextView youare = (TextView) findViewById(R.id.youare);
        linearLayoutSession = (CardView) findViewById(R.id.card1);
        buttonsession = (Button) findViewById(R.id.btn_session);

        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        /** check for user in this course and open session in last video */
        databaseReference = FirebaseDatabase.getInstance().getReference();
        rootRef = databaseReference.child("Users" + deviceID);
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /** Get map of users in datasnapshot */
                if (dataSnapshot.child("UserCourse").exists()) {

                    rootRef.child("UserCourse").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            /** Get map of users in datasnapshot */
                            String name = dataSnapshot.getValue(String.class);
                            UserCourse = name.toString().trim();
                            System.out.println(UserCourse);
                            courseName.setText(UserCourse);

                            if (courseName.getText().toString().trim().equals("")) {
//                                Continue.setText("");
//                                youare.setText("");
//                                courseName.setText("");
                                linearLayoutSession.setVisibility(View.GONE);
                            } else {
                                linearLayoutSession.setVisibility(View.VISIBLE);

                                if (courseName.getText().toString().trim().equals("Level 1 Lesson 1")) {
                                    buttonsession.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(MainActivity.this, Level1_Lesson1_Activity.class);
                                            startActivity(intent);
                                        }
                                    });

                                } else if (courseName.getText().toString().trim().equals("Level 1 Lesson 2")) {

                                    buttonsession.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(MainActivity.this, Level1_Lesson2_Activity.class);
                                            startActivity(intent);
                                        }
                                    });
                                } else if (courseName.getText().toString().trim().equals("Level 1 Lesson 3")) {

                                    buttonsession.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(MainActivity.this, Level1_Lesson3_Activity.class);
                                            startActivity(intent);
                                        }
                                    });
                                } else if (courseName.getText().toString().trim().equals("Level 1 Lesson 4")) {

                                    buttonsession.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(MainActivity.this, Level1_Lesson4_Activity.class);
                                            startActivity(intent);
                                        }
                                    });
                                }

                                if (courseName.getText().toString().trim().equals("Level 2 Lesson 1")) {
                                    buttonsession.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(MainActivity.this, Level2_Lesson1_Activity.class);
                                            startActivity(intent);
                                        }
                                    });

                                } else if (courseName.getText().toString().trim().equals("Level 2 Lesson 2")) {

                                    buttonsession.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(MainActivity.this, Level2_Lesson2_Activity.class);
                                            startActivity(intent);
                                        }
                                    });
                                } else if (courseName.getText().toString().trim().equals("Level 2 Lesson 3")) {

                                    buttonsession.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(MainActivity.this, Level2_Lesson3_Activity.class);
                                            startActivity(intent);
                                        }
                                    });
                                }


//                                Continue.setVisibility(View.VISIBLE);
//                                youare.setVisibility(View.VISIBLE);
//                                courseName.setVisibility(View.VISIBLE);

                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            /** Failed to read value */
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });


                } else {
                    System.out.println("Failed to read user Data");
                    Log.e(TAG, "Failed to read user Data");
//                    Continue.setVisibility(View.GONE);
//                    youare.setVisibility(View.GONE);
//                    courseName.setVisibility(View.GONE);
                    /** make liner visible for last session */
                    linearLayoutSession.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                /** Failed to read value */
                Log.e(TAG, "Failed to read user", databaseError.toException());
            }
        });


        /** menu initialize */
        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        overView = (CardView) findViewById(R.id.overView);
        cLevel1 = (CardView) findViewById(R.id.level_1);
        cLevel2 = (CardView) findViewById(R.id.level_2);

        /** Action for going to over view activity */
        overView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentLevel1 = new Intent(MainActivity.this, OverViewActivity.class);
                startActivity(intentLevel1);
            }
        });

        /** Action for going to level1 activity */
        cLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentLevel1 = new Intent(MainActivity.this, Level1Activity.class);
                startActivity(intentLevel1);
            }
        });

        /** Action for going to level2 activity */
        cLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentLevel2 = new Intent(MainActivity.this, Level2Activity.class);
                startActivity(intentLevel2);
            }
        });

    }


    /**
     * menu code
     */
    private void addDrawerItems() {
        String[] osArray = {"Personal Information", "Level 1 Score", "Level 2 Score", "My Courses", "Log Out"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        /** Onclick menu to go to activities */
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Personal Info", Toast.LENGTH_SHORT).show();
                    Intent InformationIntent = new Intent(MainActivity.this, InfoActivity.class);
                    startActivity(InformationIntent);
                } else if (position == 1) {

                    databaseReference = FirebaseDatabase.getInstance().getReference();
                    rootRef = databaseReference.child("Users" + deviceID);
                    rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            /** Get map of users in datasnapshot */
                            if (dataSnapshot.child("Level 1 Answers").exists()) {
                                Toast.makeText(MainActivity.this, "Level 1 Score", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, ScoreLevel1Activity.class);
                                startActivity(intent);


                            } else {
                                System.out.println("Failed to read user Data");
                                Log.e(TAG, "Failed to read user Data");
                                Toast.makeText(MainActivity.this, "There is not Score Yet Please Complete Course And Do Test To Get Score ", Toast.LENGTH_LONG).show();
//                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                                startActivity(intent);
//                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            /** Failed to read value */
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });

                } else if (position == 2) {
                    databaseReference = FirebaseDatabase.getInstance().getReference();
                    rootRef = databaseReference.child("Users" + deviceID);
                    rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            /** Get map of users in datasnapshot */
                            if (dataSnapshot.child("Level 2 Answers").exists()) {
                                Toast.makeText(MainActivity.this, "Level 2 Score", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, ScoreLevel2Activity.class);
                                startActivity(intent);


                            } else {
                                System.out.println("Failed to read user Data");
                                Log.e(TAG, "Failed to read user Data");
                                Toast.makeText(MainActivity.this, "There is not Score Yet Please Complete Course And Do Test To Get Score ", Toast.LENGTH_LONG).show();
//                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                                startActivity(intent);
//                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            /** Failed to read value */
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });

                } else if (position == 3) {
                    Toast.makeText(MainActivity.this, "You Have Register In Java Basic Operators", Toast.LENGTH_LONG).show();
                } else if (position == 4) {

                    /** ending session and go to login */
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.remove("logged");
                    editor.commit();
                    finish();

                    goLogInScreen();
                }
            }
        });
    }

    /**
     * this method for setup drawer design
     */
    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Menu");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        /** Sync the toggle state after onRestoreInstanceState has occurred.*/
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /** Handle action bar item clicks here. The action bar will
         // automatically handle clicks on the Home/Up button, so long
         // as you specify a parent activity in AndroidManifest.xml.*/
        int id = item.getItemId();

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * method for go to login screen
     */
    private void goLogInScreen() {
        Intent intent = new Intent(MainActivity.this, SignInActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please Click BACK Again to Exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}