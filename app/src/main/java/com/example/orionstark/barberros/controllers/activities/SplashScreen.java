package com.example.orionstark.barberros.controllers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.utils.UserPreference;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().hide();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (UserPreference.getInstance(SplashScreen.this).isUserLoggedIn()) {
                    startActivity(new Intent(SplashScreen.this, HomeActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashScreen.this, AuthScreen.class));
                    finish();
                }
            }
        }, 3000);
    }
}
