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
import com.SevenDigITs.Solutions.E_Learning.videos.Lesson4Level1Activity;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class Level1_Lesson4_Activity extends AppCompatActivity {
    CardView txt4, video4;
    Intent intentvideo4;

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
        setContentView(R.layout.activity_level1_lesson4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        txt4 = (CardView) findViewById(R.id.txt4_lev1_lesson4);
        video4 = (CardView) findViewById(R.id.video4_lev1_lesson4);

        imageView = (ImageView) findViewById(R.id.videoimag4);



        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level1_Lesson4_Activity.this, Level1_Lesson4_txt4_Activity.class);
                startActivity(intent);
            }
        });


        Firebase.setAndroidContext(this);
        String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        video4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentvideo4 = new Intent(Level1_Lesson4_Activity.this, Lesson4Level1Activity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(Level1_Lesson4_Activity.this, imageView
                                , ViewCompat.getTransitionName(imageView));
                startActivity(intentvideo4, options.toBundle());

//                startActivity(new Intent(Level1Activity.this, Lesson2Level1Activity.class));
//                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_in);

            }
        });






    }

}
