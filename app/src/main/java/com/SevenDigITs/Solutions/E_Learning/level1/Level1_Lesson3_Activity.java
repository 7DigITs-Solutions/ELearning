package com.SevenDigITs.Solutions.E_Learning.level1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.SevenDigITs.Solutions.E_Learning.R;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class Level1_Lesson3_Activity extends AppCompatActivity {


    CardView txt3, video3;
    Intent intentvideo3;

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
        setContentView(R.layout.activity_level1_lesson3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        txt3 = (CardView) findViewById(R.id.txt3_lev1_lesson3);
       // video3 = (CardView) findViewById(R.id.video3_lev1_lesson3);

        //imageView = (ImageView) findViewById(R.id.videoimag3);



        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level1_Lesson3_Activity.this, Level1_Lesson3_txt3_Activity.class);
                startActivity(intent);
            }
        });


        Firebase.setAndroidContext(this);
        String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

       /* video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentvideo3 = new Intent(Level1_Lesson3_Activity.this, Lesson2Level1Activity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(Level1_Lesson3_Activity.this, imageView
                                , ViewCompat.getTransitionName(imageView));
                startActivity(intentvideo3, options.toBundle());

//                startActivity(new Intent(Level1Activity.this, Lesson2Level1Activity.class));
//                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_in);

            }
        });*/

    }
}
