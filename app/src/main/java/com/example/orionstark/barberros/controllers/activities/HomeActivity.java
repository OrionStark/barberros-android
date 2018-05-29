package com.example.orionstark.barberros.controllers.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orionstark.barberros.AppointmentFragment;
import com.example.orionstark.barberros.BarbersFragment;
import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.adapters.ViewPagerAdapter;

public class HomeActivity extends AppCompatActivity {
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setElevation(0);
        }
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.home_viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        tabLayout = findViewById(R.id.home_tablayout);
        adapter.setFragment(new BarbersFragment(), "Barbers");
        adapter.setFragment(new AppointmentFragment(), "Appointment");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
