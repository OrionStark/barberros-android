package com.example.orionstark.barberros.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orionstark.barberros.controllers.fragments.ConfirmPassFragment;
import com.example.orionstark.barberros.R;

public class PassConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_config);
        initView();
    }

    private void initView() {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                .replace(R.id.passconfig_outlet, new ConfirmPassFragment())
                .commit();
    }
}
