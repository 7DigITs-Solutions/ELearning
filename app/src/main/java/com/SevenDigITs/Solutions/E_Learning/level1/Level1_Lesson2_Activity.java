package com.SevenDigITs.Solutions.E_Learning.level1;

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
import com.SevenDigITs.Solutions.E_Learning.videos.Lesson2Level1Activity;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class Level1_Lesson2_Activity extends AppCompatActivity {



    CardView txt2, video2;
    Intent intentvideo2;

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
        setContentView(R.layout.activity_level1_lesson2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        txt2 = (CardView) findViewById(R.id.txt2_lev1_lesson2);
        video2 = (CardView) findViewById(R.id.video2_lev1_lesson2);

        imageView = (ImageView) findViewById(R.id.videoimag2);


        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level1_Lesson2_Activity.this, Level1_Lesson2_txt2_Activity.class);
                startActivity(intent);
            }
        });



        Firebase.setAndroidContext(this);
        String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentvideo2 = new Intent(Level1_Lesson2_Activity.this, Lesson2Level1Activity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(Level1_Lesson2_Activity.this, imageView
                                , ViewCompat.getTransitionName(imageView));
                startActivity(intentvideo2, options.toBundle());

//                startActivity(new Intent(Level1Activity.this, Lesson2Level1Activity.class));
//                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_in);

            }
        });


    }
}
