package com.example.orionstark.barberros.controllers.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.orionstark.barberros.R;

public class ConfirmPassFragment extends Fragment {
   View view;
   Button confirm_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_confirm_pass, container, false);
        viewInit();
        return view;
    }

    private void viewInit() {
        confirm_btn = view.findViewById(R.id.confirm_pass_btn);
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.passconfig_outlet, new CreatePassFragment())
                        .commit();
            }
        });
    }

}
