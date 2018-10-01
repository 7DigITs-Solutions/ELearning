package com.SevenDigITs.Solutions.E_Learning.Level2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.SevenDigITs.Solutions.E_Learning.R;
import com.SevenDigITs.Solutions.E_Learning.videos.Lesson1Level2Activity;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class Level2_Lesson1_Activity extends AppCompatActivity {


    CardView txt1, video1;
    Intent intentvideo1;

    ImageView imageView;
    Button button;
    View bu;


    //defining firebase
    Firebase firebase;
    private FirebaseAuth mAuth;


    // for open session
    public static final String PREFS_NAME = "LoginPrefs";



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2_lesson1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        txt1 = (CardView) findViewById(R.id.txt1_lev2_lesson1);
        video1 = (CardView) findViewById(R.id.video1_lev2_lesson1);

        imageView = (ImageView) findViewById(R.id.videoimag1);



        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2_Lesson1_Activity.this, Level2_Lesson1_txt1_Activity.class);
                startActivity(intent);
            }
        });


        Firebase.setAndroidContext(this);
        String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentvideo1 = new Intent(Level2_Lesson1_Activity.this, Lesson1Level2Activity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(Level2_Lesson1_Activity.this, imageView
                                , ViewCompat.getTransitionName(imageView));
                startActivity(intentvideo1, options.toBundle());

//                startActivity(new Intent(Level1Activity.this, Lesson2Level1Activity.class));
//                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_in);

            }
        });



    }
}