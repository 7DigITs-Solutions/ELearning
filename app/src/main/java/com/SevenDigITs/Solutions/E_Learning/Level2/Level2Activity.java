package com.SevenDigITs.Solutions.E_Learning.Level2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.SevenDigITs.Solutions.E_Learning.Test_Result.Level1_Test_Activity;
import com.SevenDigITs.Solutions.E_Learning.R;
import com.SevenDigITs.Solutions.E_Learning.Test_Result.Level2_Test_Activity;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class Level2Activity extends AppCompatActivity {


    CardView cLessone5, cLessone6, cLessone7, cLessone8;
    Intent intentLessone5, intentLessone6, intentLessone7, intentLessone8;
    CheckBox cb5, cb6, cb7, cb8;
    Button button;
    View bu2;


    String level_2_1 = "Level 2 Lesson 1";
    String level_2_2 = "Level 2 Lesson 2";
    String level_2_3 = "Level 2 Lesson 3";
    String level_2_4 = "Level 2 Lesson 4";

    //defining firebase
    Firebase firebase;
    private FirebaseAuth mAuth;


    // for open session
    public static final String PREFS_NAME = "LoginPrefs";


    public static final String shrd2 = "shared2";
    public static final String swtich5 = "swtich5";
    public static final String swtich6 = "swtich6";
    public static final String swtich7 = "swtich7";
    public static final String swtich8 = "swtich8";

    private boolean switchOnOff5, switchOnOff6, switchOnOff7, switchOnOff8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        cLessone5 = (CardView) findViewById(R.id.lv2_lesson1_id);
        cLessone6 = (CardView) findViewById(R.id.lv2_lesson2_id);
        cLessone7 = (CardView) findViewById(R.id.lv2_lesson3_id);
        cLessone8 = (CardView) findViewById(R.id.lv2_lesson4_id);

        cb5 = (CheckBox) findViewById(R.id.ch_lv2_ls1);
        cb6 = (CheckBox) findViewById(R.id.ch_lv2_ls2);
        cb7 = (CheckBox) findViewById(R.id.ch_lv2_ls3);

        button = (Button) findViewById(R.id.test2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bu2= findViewById(R.id.test2);

                if (cb5.isChecked()&& cb6.isChecked() && cb7.isChecked() ) {
                    bu2.setVisibility(View.VISIBLE);
                }else {
                    bu2.setVisibility(View.GONE);
                }

            }
        }, 5);

        Firebase.setAndroidContext(this);
        String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();


        cLessone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentLessone5 = new Intent(Level2Activity.this, Level2_Lesson1_Activity.class);
                cb5.setChecked(true);
                saveData();

                String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
                mAuth = FirebaseAuth.getInstance();

                Firebase firebaseCourse = firebase.child("UserCourse");
                firebaseCourse.setValue(level_2_1);
                startActivity(intentLessone5);

            }
        });

        cLessone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentLessone6 = new Intent(Level2Activity.this, Level2_Lesson2_Activity.class);
                cb6.setChecked(true);
                saveData();

                String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
                mAuth = FirebaseAuth.getInstance();

                Firebase firebaseCourse = firebase.child("UserCourse");
                firebaseCourse.setValue(level_2_2);
                startActivity(intentLessone6);
            }
        });

        cLessone7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentLessone7 = new Intent(Level2Activity.this, Level2_Lesson3_Activity.class);
                cb7.setChecked(true);
                saveData();

                String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
                mAuth = FirebaseAuth.getInstance();

                Firebase firebaseCourse = firebase.child("UserCourse");
                firebaseCourse.setValue(level_2_3);
                startActivity(intentLessone7);
            }
        });





        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              saveData();
            }
        });



        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              saveData();
            }
        });



        cb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveData();

            }
        });




        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb5.isChecked() && cb6.isChecked() && cb7.isChecked()) {
                    bu2 = findViewById(R.id.test2);
                    bu2.setVisibility(View.VISIBLE);
                } else {
                    bu2 = findViewById(R.id.test2);
                    bu2.setVisibility(View.GONE);
                }
                saveData();
            }
        });

        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb5.isChecked() && cb6.isChecked() && cb7.isChecked()) {
                    bu2 = findViewById(R.id.test2);
                    bu2.setVisibility(View.VISIBLE);
                } else {
                    bu2 = findViewById(R.id.test2);
                    bu2.setVisibility(View.GONE);
                }
                saveData();
            }
        });

        cb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb5.isChecked() && cb6.isChecked() && cb7.isChecked()) {
                    bu2 = findViewById(R.id.test2);
                    bu2.setVisibility(View.VISIBLE);
                } else {
                    bu2 = findViewById(R.id.test2);
                    bu2.setVisibility(View.GONE);
                }
                saveData();
            }

        });




        loadData();
        update();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2Activity.this, Level2_Test_Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(shrd2, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(swtich5, cb5.isChecked());
        editor.putBoolean(swtich6, cb6.isChecked());
        editor.putBoolean(swtich7, cb7.isChecked());

        editor.commit();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(shrd2, MODE_PRIVATE);
        switchOnOff5 = sharedPreferences.getBoolean(swtich5, false);
        switchOnOff6 = sharedPreferences.getBoolean(swtich6, false);
        switchOnOff7 = sharedPreferences.getBoolean(swtich7, false);

    }

    public void update() {
        cb5.setChecked(switchOnOff5);
        cb6.setChecked(switchOnOff6);
        cb7.setChecked(switchOnOff7);

    }


}

