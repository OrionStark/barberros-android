package com.example.orionstark.barberros.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragments = new ArrayList<>();
    List<String> labels = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragment(Fragment fragment, String label) {
        this.fragments.add(fragment);
        this.labels.add(label);
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.labels.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
