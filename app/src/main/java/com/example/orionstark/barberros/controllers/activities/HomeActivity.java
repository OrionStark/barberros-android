package com.example.orionstark.barberros.controllers.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.orionstark.barberros.controllers.fragments.AppointmentFragment;
import com.example.orionstark.barberros.controllers.fragments.BarbersFragment;
import com.example.orionstark.barberros.controllers.fragments.FavoriteFragment;
import com.example.orionstark.barberros.controllers.fragments.NotificationFragment;
import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.adapters.ViewPagerAdapter;
import com.example.orionstark.barberros.utils.UserPreference;

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
        adapter.setFragment(new BarbersFragment(),null);
        adapter.setFragment(new FavoriteFragment(),null);
        adapter.setFragment(new AppointmentFragment(),null);
        adapter.setFragment(new NotificationFragment(),null);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //set Icon
        tabLayout.getTabAt(0).setIcon(R.drawable.home_icon_barber);
        tabLayout.getTabAt(1).setIcon(R.drawable.heart_white);
        tabLayout.getTabAt(2).setIcon(R.drawable.calendar_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.bell_icon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.search:
                return true;
//            case R.id.profil:
//                startActivity(new Intent(this, ProfileActivity.class));
//                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        if (UserPreference.getInstance(this).isUserLoggedIn()) {
            super.onResume();
        } else {
            super.onResume();
            startActivity(new Intent(this, AuthScreen.class));
            finish();
        }
    }
}
