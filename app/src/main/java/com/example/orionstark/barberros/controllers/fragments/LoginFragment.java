package com.example.orionstark.barberros.controllers.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.controllers.activities.HomeActivity;
import com.example.orionstark.barberros.controllers.activities.PassConfigActivity;
import com.example.orionstark.barberros.services.BarberrosService;
import com.transitionseverywhere.TransitionManager;

import org.json.JSONException;

public class LoginFragment extends Fragment {
    View view;
    LinearLayout progress_bar;
    LinearLayout login_form_container;
    Button login_btn;
    TextView register_nav;
    EditText username, password;
    TextView forget_pass_nav;
    ViewGroup rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        initView();
        return view;
    }

    private void initView() {
        progress_bar = view.findViewById(R.id.progress_bar_login);
        login_form_container = view.findViewById(R.id.login_container);
        login_btn = view.findViewById(R.id.login_button);
        register_nav = view.findViewById(R.id.register_nav);
        forget_pass_nav = view.findViewById(R.id.forgot_pass_nav);
        rootview = view.findViewById(R.id.login_root);
        username = view.findViewById(R.id.username_login_field);
        password = view.findViewById(R.id.password_login_field);

        register_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.auth_router_outlet, new RegisterFragment())
                        .commit();
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                TransitionManager.beginDelayedTransition(rootview);
                login_form_container.setVisibility(View.GONE);
                progress_bar.setVisibility(View.VISIBLE);
                try {
                    BarberrosService.login(username.getText().toString(),
                            password.getText().toString(), getContext(), new BarberrosService.LoginCallback() {
                        @Override
                        public void onSucceed(String message) {
                            startActivity(new Intent(getContext(), HomeActivity.class));
                            ((Activity) getContext()).finish();
                        }

                        @Override
                        public void onError(String message) {
                            TransitionManager.beginDelayedTransition(rootview);
                            login_form_container.setVisibility(View.VISIBLE);
                            progress_bar.setVisibility(View.GONE);
                            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
                        }
                    });
                } catch (JSONException e) {
                   if ( e.getMessage() != null ) {
                       TransitionManager.beginDelayedTransition(rootview);
                       login_form_container.setVisibility(View.VISIBLE);
                       progress_bar.setVisibility(View.GONE);
                       Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                   } else {
                       TransitionManager.beginDelayedTransition(rootview);
                       login_form_container.setVisibility(View.VISIBLE);
                       progress_bar.setVisibility(View.GONE);
                       Snackbar.make(view, "Unknown error, please try it again later.", Snackbar.LENGTH_SHORT).show();
                   }
                }
            }
        });
        forget_pass_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), PassConfigActivity.class));
            }
        });

    }

}
