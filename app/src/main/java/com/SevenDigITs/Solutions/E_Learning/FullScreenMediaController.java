package com.SevenDigITs.Solutions.E_Learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;

import com.SevenDigITs.Solutions.E_Learning.videos.Lesson1Level1Activity;
import com.SevenDigITs.Solutions.E_Learning.videos.Lesson1Level2Activity;
import com.SevenDigITs.Solutions.E_Learning.videos.Lesson2Level1Activity;
import com.SevenDigITs.Solutions.E_Learning.videos.Lesson2Level2Activity;
import com.SevenDigITs.Solutions.E_Learning.videos.Lesson4Level1Activity;

public class FullScreenMediaController extends MediaController {

    private ImageButton fullScreen,fullScreen2,fullScreen3,fullScreen4,fullScreen5;
    private String isFullScreen;

    public FullScreenMediaController(Context context) {
        super(context);
    }

    @Override
    public void setAnchorView(View view) {

        super.setAnchorView(view);

        /**image button for full screen to be added to media controller*/
        fullScreen = new ImageButton (super.getContext());
        fullScreen2 = new ImageButton (super.getContext());
        fullScreen3 = new ImageButton (super.getContext());
        fullScreen4 = new ImageButton (super.getContext());
        fullScreen5 = new ImageButton (super.getContext());

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT;
        params.rightMargin = 80;
        addView(fullScreen, params);
        addView(fullScreen2, params);
        addView(fullScreen3, params);
        addView(fullScreen4, params);
        addView(fullScreen5, params);

        /**fullscreen indicator from intent*/
        isFullScreen =  ((Activity)getContext()).getIntent().
                getStringExtra("fullScreenInd");

        if("y".equals(isFullScreen)){
            fullScreen.setImageResource(R.drawable.ic_fullscreen_exit);
            fullScreen2.setImageResource(R.drawable.ic_fullscreen_exit);
            fullScreen3.setImageResource(R.drawable.ic_fullscreen_exit);
            fullScreen4.setImageResource(R.drawable.ic_fullscreen_exit);
            fullScreen5.setImageResource(R.drawable.ic_fullscreen_exit);
        }else{
            fullScreen.setImageResource(R.drawable.ic_fullscreen);
            fullScreen2.setImageResource(R.drawable.ic_fullscreen);
            fullScreen3.setImageResource(R.drawable.ic_fullscreen);
            fullScreen4.setImageResource(R.drawable.ic_fullscreen);
            fullScreen5.setImageResource(R.drawable.ic_fullscreen);
        }

        /**add listener to image button to handle full screen and exit full screen events*/
        fullScreen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Lesson1Level1Activity.class);

                if("y".equals(isFullScreen)){
                    intent.putExtra("fullScreenInd", "");
                }else{
                    intent.putExtra("fullScreenInd", "y");
                }
                ((Activity)getContext()).startActivity(intent);
            }
        });
        /**add listener to image button to handle full screen and exit full screen events*/
        fullScreen2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Lesson2Level1Activity.class);

                if("y".equals(isFullScreen)){
                    intent.putExtra("fullScreenInd", "");
                }else{
                    intent.putExtra("fullScreenInd", "y");
                }
                ((Activity)getContext()).startActivity(intent);
            }
        });

        /**add listener to image button to handle full screen and exit full screen events*/
        fullScreen3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Lesson4Level1Activity.class);

                if("y".equals(isFullScreen)){
                    intent.putExtra("fullScreenInd", "");
                }else{
                    intent.putExtra("fullScreenInd", "y");
                }
                ((Activity)getContext()).startActivity(intent);
            }
        });

        /**add listener to image button to handle full screen and exit full screen events*/
        fullScreen4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Lesson1Level2Activity.class);

                if("y".equals(isFullScreen)){
                    intent.putExtra("fullScreenInd", "");
                }else{
                    intent.putExtra("fullScreenInd", "y");
                }
                ((Activity)getContext()).startActivity(intent);
            }
        });

        /**add listener to image button to handle full screen and exit full screen events*/
        fullScreen5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Lesson2Level2Activity.class);

                if("y".equals(isFullScreen)){
                    intent.putExtra("fullScreenInd", "");
                }else{
                    intent.putExtra("fullScreenInd", "y");
                }
                ((Activity)getContext()).startActivity(intent);
            }
        });

    }
}