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
import com.SevenDigITs.Solutions.E_Learning.Level2.Level2Activity;
import com.SevenDigITs.Solutions.E_Learning.R;

public class Lesson1Level2Activity extends AppCompatActivity {


    // initializing action variables
    private VideoView videoView;
    private MediaController mediaController;
    Intent intentLessone2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_level2);

        /** defining XML object and tag them */
        videoView = findViewById(R.id.videoView4);
        /** this if for check about button fullscreen */

        String fullScreen = getIntent().getStringExtra("fullScreenInd");
        if ("y".equals(fullScreen)) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
        }

        /** Getting video uri */
        String vidAddress = "https://firebasestorage.googleapis.com/v0/b/e-learning-7c397.appspot.com/o/Java%20Tutorial%20For%20Beginners%207%20-%20Increment%20Operator%20and%20Assignment%20Operator.mp4?alt=media&token=701ff337-59ce-4a1f-a06f-e318f922a62e";
        Uri vidUri = Uri.parse(vidAddress);
        // Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.one);

        /** add uri to video view */
        videoView.setVideoURI(vidUri);

        /** get to full screen mode */
        mediaController = new FullScreenMediaControllerLvl2Ls1(this);
        mediaController.setAnchorView(videoView);

        /** on complete video go to next vedio */
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                intentLessone2 = new Intent(Lesson1Level2Activity.this, Level2Activity.class);
                startActivity(intentLessone2);
                finish();
            }
        });
        /** on error occurs in loading video */
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), " An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });

        /** show controller of video */
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
