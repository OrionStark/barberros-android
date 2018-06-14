package com.example.orionstark.barberros.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.adapters.ProfileRecyclerAdapter;
import com.example.orionstark.barberros.utils.UserPreference;

public class ProfileActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProfileRecyclerAdapter adapter;
    TextView full_nameBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.profile_list_recycler);
        adapter = new ProfileRecyclerAdapter();
        full_nameBanner = findViewById(R.id.fullName_banner);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        full_nameBanner.setText(UserPreference.getInstance(this).getUser().getFull_name());
    }
}
