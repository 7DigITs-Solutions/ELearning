package com.SevenDigITs.Solutions.E_Learning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class OverViewActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }


}
