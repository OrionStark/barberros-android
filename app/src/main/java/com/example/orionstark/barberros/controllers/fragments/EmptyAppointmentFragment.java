package com.example.orionstark.barberros.controllers.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.controllers.activities.HomeActivity;

public class EmptyAppointmentFragment extends Fragment {
    View view;
    TextView textApp;
    Button btn_browse;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_empty_appointment, container, false);
        this.init();
        return view;
    }
    private void init() {
        Typeface myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/BreeSerif-Regular.ttf");
        textApp = view.findViewById(R.id.textApp1);
        textApp.setTypeface(myTypeface);
        btn_browse = view.findViewById(R.id.btn_browse2);

        btn_browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), HomeActivity.class));
                ((Activity) getContext()).finish();//untuk Sementara WWKKWKWKWK
                /*getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.home_router_outlet, new BarbersFragment())
                        .commit();*/
            }
        });
    }
}