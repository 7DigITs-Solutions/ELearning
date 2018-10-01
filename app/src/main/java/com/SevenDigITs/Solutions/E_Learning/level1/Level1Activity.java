package com.SevenDigITs.Solutions.E_Learning.level1;

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
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class Level1Activity extends AppCompatActivity {

    // initializing action variables
    CardView cLessone1, cLessone2, cLessone3, cLessone4;
    Intent intentLessone1, intentLessone2, intentLessone3, intentLessone4;
    CheckBox cb1, cb2, cb3, cb4;
    Button button;
    View bu;


    // initializing String variables
    String level_1_1 = "Level 1 Lesson 1";
    String level_1_2 = "Level 1 Lesson 2";
    String level_1_3 = "Level 1 Lesson 3";
    String level_1_4 = "Level 1 Lesson 4";

    //defining firebase
    Firebase firebase;
    private FirebaseAuth mAuth;


    // for open session
    public static final String PREFS_NAME = "LoginPrefs";

    // for checkbox session
    public static final String shrd1 = "shared";
    public static final String swtich = "swtich";
    public static final String swtich2 = "swtich2";
    public static final String swtich3 = "swtich3";
    public static final String swtich4 = "swtich4";

    // variables for action of checkbox change
    private boolean switchOnOff, switchOnOff2, switchOnOff3, switchOnOff4;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bu= findViewById(R.id.test1);

                if (cb1.isChecked()&& cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                    bu.setVisibility(View.VISIBLE);
                }else {
                    bu.setVisibility(View.GONE);
                }

            }
        }, 5);



        /** defining XML object and tag them */
        cLessone1 = (CardView) findViewById(R.id.lv1_lesson1_id);
        cLessone2 = (CardView) findViewById(R.id.lv1_lesson2_id);
        cLessone3 = (CardView) findViewById(R.id.lv1_lesson3_id);
        cLessone4 = (CardView) findViewById(R.id.lv1_lesson4_id);

        cb1 = (CheckBox) findViewById(R.id.ch_lv1_ls1);
        cb2 = (CheckBox) findViewById(R.id.ch_lv1_ls2);
        cb3 = (CheckBox) findViewById(R.id.ch_lv1_ls3);
        cb4 = (CheckBox) findViewById(R.id.ch_lv1_ls4);

        button = (Button) findViewById(R.id.test1);

    /** get device id for create a user using his mobile id in firebase  */
        Firebase.setAndroidContext(this);
        String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

    /** action for go to video lesson 1 */
        cLessone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentLessone1 = new Intent(Level1Activity.this, Level1_Lesson1_Activity.class);
                /** when click set checbox checked */
                cb1.setChecked(true);
                /** method for save checkbox when checked */
                saveData();

         /** get device id for create a user course child  using his mobile id in firebase  */
                String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
                mAuth = FirebaseAuth.getInstance();

                Firebase firebaseCourse = firebase.child("UserCourse");
                firebaseCourse.setValue(level_1_1);

                startActivity(intentLessone1);

            }
        });

    /** action for go to video lesson 2 */
        cLessone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentLessone2 = new Intent(Level1Activity.this, Level1_Lesson2_Activity.class);
                /** when click set checbox checked */
                cb2.setChecked(true);
                /** method for save checkbox when checked */
                saveData();

        /** get device id for create a user course child  using his mobile id in firebase  */
                String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
                mAuth = FirebaseAuth.getInstance();

                Firebase firebaseCourse = firebase.child("UserCourse");
                firebaseCourse.setValue(level_1_2);
                startActivity(intentLessone2);
            }
        });

    /** action for go to video lesson 3 */
        cLessone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentLessone3 = new Intent(Level1Activity.this, Level1_Lesson3_Activity.class);
                /** when click set checbox checked */
                cb3.setChecked(true);
                /** method for save checkbox when checked */
                saveData();

                /** get device id for create a user course child  using his mobile id in firebase  */
                String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
                mAuth = FirebaseAuth.getInstance();

                Firebase firebaseCourse = firebase.child("UserCourse");
                firebaseCourse.setValue(level_1_3);
                startActivity(intentLessone3);
            }
        });

    /** action for go to video lesson 4 */
        cLessone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentLessone4 = new Intent(Level1Activity.this, Level1_Lesson4_Activity.class);
                /** when click set checbox checked */
                cb4.setChecked(true);
                /** method for save checkbox when checked */
                saveData();

                /** get device id for create a user course child  using his mobile id in firebase  */
                String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
                mAuth = FirebaseAuth.getInstance();

                Firebase firebaseCourse = firebase.child("UserCourse");
                firebaseCourse.setValue(level_1_4);
                startActivity(intentLessone4);
            }
        });

        loadData();
        update();

    /** this 4 checkbox for save changing checked */
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveData();
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveData();
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveData();
            }
        });

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveData();
            }
        });



        /** this 4 checkbox for controlling visibility of button test when all checkbox is checked */
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                    saveData();
                    bu= findViewById(R.id.test1);
                    bu.setVisibility(View.VISIBLE);
                } else {
                    saveData();
                    bu = findViewById(R.id.test1);
                    bu.setVisibility(View.GONE);
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                    saveData();
                    bu= findViewById(R.id.test1);
                    bu.setVisibility(View.VISIBLE);
                } else {
                    saveData();
                    bu = findViewById(R.id.test1);
                    bu.setVisibility(View.GONE);
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                    saveData();
                    bu= findViewById(R.id.test1);
                    bu.setVisibility(View.VISIBLE);
                } else {
                    saveData();
                    bu = findViewById(R.id.test1);
                    bu.setVisibility(View.GONE);
                }
            }

        });

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                    saveData();
                    bu= findViewById(R.id.test1);
                    bu.setVisibility(View.VISIBLE);
                } else {
                    saveData();
                    bu = findViewById(R.id.test1);
                    bu.setVisibility(View.GONE);
                }
            }

        });



        /** this method responsible for load data of check box when open app  */
        loadData();

        /** this method responsible for Update data of check box when open app  */
        update();


        /** action for go to test level */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level1Activity.this, Level1_Test_Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    /** this method responsible for save checkbox when checked */
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(shrd1, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(swtich, cb1.isChecked());
        editor.putBoolean(swtich2, cb2.isChecked());
        editor.putBoolean(swtich3, cb3.isChecked());
        editor.putBoolean(swtich4, cb4.isChecked());
        editor.commit();
    }

    /** this method responsible for load data of check box when open app  */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(shrd1, MODE_PRIVATE);
        switchOnOff = sharedPreferences.getBoolean(swtich, false);
        switchOnOff2 = sharedPreferences.getBoolean(swtich2, false);
        switchOnOff3 = sharedPreferences.getBoolean(swtich3, false);
        switchOnOff4 = sharedPreferences.getBoolean(swtich4, false);
    }

    /** this method responsible for Update data of check box when open app  */
    public void update() {
        cb1.setChecked(switchOnOff);
        cb2.setChecked(switchOnOff2);
        cb3.setChecked(switchOnOff3);
        cb4.setChecked(switchOnOff4);
    }


}