package com.SevenDigITs.Solutions.E_Learning.videos;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.SevenDigITs.Solutions.E_Learning.FullScreenMediaController;
import com.SevenDigITs.Solutions.E_Learning.level1.Level1Activity;
import com.SevenDigITs.Solutions.E_Learning.R;

public class Lesson2Level1Activity extends AppCompatActivity {

    // initializing action variables
    private VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_level1);

        /** defining XML object and tag them */
        videoView = findViewById(R.id.videoView2);

        /** this if for check about button fullscreen */
        String fullScreen = getIntent().getStringExtra("fullScreenInd");
        if ("y".equals(fullScreen)) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
        }

        /** Getting video uri */
        String vidAddress = "https://firebasestorage.googleapis.com/v0/b/e-learning-7c397.appspot.com/o/Java%20Tutorial%20For%20Beginners%208%20-%20%20IF%20...%20ELSE%20Statements%20and%20Relational%20Operators.mp4?alt=media&token=c3a23a27-a1f0-43d8-a807-b3c941874245";
        Uri vidUri = Uri.parse(vidAddress);

        //Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.two);

        /** add uri to video view */
        videoView.setVideoURI(vidUri);

        /** get to full screen mode */
        mediaController = new FullScreenMediaControllerLvl1Ls2(this);
        mediaController.setAnchorView(videoView);

        /** on error occurs in loading video */
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), " An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });
        /** on complete video go to next vedio */
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent = new Intent(Lesson2Level1Activity.this, Level1Activity.class);
                startActivity(intent);
                finish();
            }
        });

        /** show controller of video */
        videoView.setMediaController(mediaController);
        videoView.start();

    }


    @Override
    protected void onStop() {
        super.onStop();
        videoView.canPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        videoView.start();
    }
}
