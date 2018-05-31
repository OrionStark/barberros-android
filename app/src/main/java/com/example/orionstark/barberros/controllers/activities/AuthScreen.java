package com.example.orionstark.barberros.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orionstark.barberros.controllers.fragments.LoginFragment;
import com.example.orionstark.barberros.R;

public class AuthScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_screen);
        viewInit();
    }

    private void viewInit() {
        if (getSupportActionBar()!= null){
            getSupportActionBar().hide();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                .replace(R.id.auth_router_outlet, new LoginFragment(), "login.fragment")
                .commit();
    }

    @Override
    public void onBackPressed() {
        if ( getSupportFragmentManager().findFragmentByTag("login.fragment") != null
                && getSupportFragmentManager().findFragmentByTag("login.fragment").isVisible()) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.auth_router_outlet, new LoginFragment(), "login.fragment")
                    .commit();
        }
    }
}
