package com.example.orionstark.barberros.controllers.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.orionstark.barberros.R;

public class CreatePassFragment extends Fragment {
    View view;
    Button submit_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_create_pass, container, false);
        initView();
        return view;
    }
    private void initView() {
        submit_btn = view.findViewById(R.id.submit_pass_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });
    }

}
