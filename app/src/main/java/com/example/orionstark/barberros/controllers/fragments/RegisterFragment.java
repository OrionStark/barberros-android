package com.example.orionstark.barberros.controllers.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.controllers.fragments.LoginFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFragment extends Fragment {
    View view;
    Button register_btn;
    TextView login_nav;
    EditText username;
    EditText number;
    EditText fullname;
    EditText pass;
    EditText conf_pass;
    EditText pin;
    EditText conf_pin;
    EditText email;
    Boolean valid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        initView();
        return view;
    }

    private void initView() {
        username= (EditText)view.findViewById(R.id.username);
        number= (EditText)view.findViewById(R.id.number);
        fullname= (EditText)view.findViewById(R.id.fullname);
        pass= (EditText)view.findViewById(R.id.pass);
        conf_pass= (EditText)view.findViewById(R.id.conf_pass);
        pin= (EditText)view.findViewById(R.id.pin);
        conf_pin= (EditText)view.findViewById(R.id.conf_pin);
        email= (EditText)view.findViewById(R.id.email);
        register_btn = view.findViewById(R.id.register_btn);
        login_nav = view.findViewById(R.id.login_nav);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(username.getText().toString())) {
                    valid = false;
                    username.setError("field is require");
                } else if (TextUtils.isEmpty(number.getText().toString())) {
                    valid = false;
                    number.setError("field is require");
                } else if (number.getText().length() < 11 || number.getText().length() > 13 )  {
                    valid = false;
                    number.setError("number phone is not valid");
                }
                else if (TextUtils.isEmpty(fullname.getText().toString())) {
                    valid = false;
                    fullname.setError("field is require");
                } else if (TextUtils.isEmpty(pass.getText().toString())) {
                    valid = false;
                    pass.setError("field is require");
                }else if (pass.getText().toString().length() <7 ) {
                    valid = false;
                    pass.setError("Password at least is 7 character");
                }else if (!pass.getText().toString().equals(conf_pass.getText().toString())){
                    valid=false;
                    conf_pass.setError("password not match");
                }
                else if (TextUtils.isEmpty(conf_pass.getText().toString())) {
                    valid = false;
                    conf_pass.setError("field is require");
                } else if (TextUtils.isEmpty(pin.getText().toString())) {
                    valid = false;
                    pin.setError("field is require");
                }else if (!pin.getText().toString().equals(conf_pin.getText().toString())){
                    valid=false;
                    conf_pin.setError("pin not match");
                } else if (TextUtils.isEmpty(conf_pin.getText().toString())) {
                    valid = false;
                    conf_pass.setError("field is require");
                } else if (TextUtils.isEmpty(email.getText().toString())) {
                    valid = false;
                    email.setError("field is require");
                }else if (!isemailvalid(email.getText().toString())){
                    valid=false;
                    email.setError("Email is not valid");
                }
                else {
                    valid = true;
                }

                if (valid) {
                    getFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                            .replace(R.id.auth_router_outlet, new LoginFragment())
                            .commit();
                }
            }

        });

        login_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    getFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                            .replace(R.id.auth_router_outlet, new LoginFragment())
                            .commit();
                }

        });


    }
    public static boolean isemailvalid(String email) {
//        String _expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        String _expression = "^[a-z]([a-z0-9-\\.]+)?+@[a-z]+\\.[a-z]{2,10}+(\\.[a-z]{2,10})?$";
        CharSequence _email = email;
        Pattern _pattern = Pattern.compile(_expression, Pattern.CASE_INSENSITIVE);
        Matcher _mathcer = _pattern.matcher(_email);

        if (_mathcer.matches()) {
            return true;
        }
        return false;
    }






}
