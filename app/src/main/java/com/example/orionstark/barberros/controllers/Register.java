package com.example.orionstark.barberros.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orionstark.barberros.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private Toolbar toolbar;
    private Button signup_btn;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private EditText password2;
    private EditText phoneNumber;
    private EditText password_confirm;
    private EditText password_confirm2;
    private CheckBox check;
    public  Boolean valid =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setNavIcon();
        setProps();
    }
    private void setNavIcon(){
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.toolbar.setNavigationIcon(R.drawable.back_arrow);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }
    private void setProps(){
        this.signup_btn = (Button)findViewById(R.id.signup_btn);
        this.firstName = (EditText)findViewById(R.id.first_name_field);
        this.lastName = (EditText)findViewById(R.id.last_name_field);
        this.email = (EditText)findViewById(R.id.email_field);
        this.phoneNumber = (EditText)findViewById(R.id.phone_number);
        this.password = (EditText)findViewById(R.id.password_field);
        this.password_confirm = (EditText)findViewById(R.id.retype_password_field);
        this.password2 = (EditText)findViewById(R.id.password2_field);
        this.password_confirm2 = (EditText)findViewById(R.id.retype_password2_field);
        this.check=(CheckBox)findViewById(R.id.agreement_check);




        this.signup_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(firstName.getText().toString())) {
                    //jika form Email belum di isi / masih kosong
                    valid=false;
                    firstName.setError("this field required");
                } else if (TextUtils.isEmpty(lastName.getText().toString())) {
                    //jika form Username belum di isi / masih kosong
                    valid=false;
                    lastName.setError("this field required");
                } else if (TextUtils.isEmpty(email.getText().toString())) {
                    //jika form Passwrod belum di isi / masih kosong
                    valid=false;
                    email.setError("this field required");
                } else if (!isemailvalid(email.getText().toString())) {
                    valid=false;
                    email.setError("Email is not valid");
                }else if (TextUtils.isEmpty(phoneNumber.getText().toString())) {
                    valid=false;
                    phoneNumber.setError("this field required");
                }else if (!(phoneNumber.getText().toString().length() <= 12)) {
                    valid = false;
                    phoneNumber.setError("Phone number max 12 digit");
                }
                else if (password.getText().toString().length() <7 && password_confirm.getText().toString().length() <7) {
                    valid=false;
                    password.setError("Password at least is 7 character");
                }else if (TextUtils.isEmpty(password.getText().toString())){
                    valid=false;
                    password.setError("this field is required");
                }else if (!password_confirm.getText().toString().equals(password.getText().toString())){
                    valid=false;
                    password_confirm.setError("password not match");
                }else if (password2.getText().toString().length() <7 && password_confirm2.getText().toString().length() <7) {
                    valid=false;
                    password2.setError("Password at least is 7 character");
                }else if (TextUtils.isEmpty(password2.getText().toString())){
                    valid=false;
                    password2.setError("this field is required");
                }else if (!password_confirm2.getText().toString().equals(password2.getText().toString())) {
                    valid = false;
                    password_confirm2.setError("password not match");
                }else if (!check.isChecked()){
                    valid=false;
                    Toast.makeText(getApplicationContext(), "Please check user agreement", Toast.LENGTH_SHORT).show();
                } else {
                    valid = true;
                }

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

    public static boolean ispasswordvalid(String password) {
        String _expression = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[@!\\*?$&\\^#-])[\\w@!\\*?$&\\^#-]{8,}$";
        Pattern _pattern = Pattern.compile(_expression, Pattern.CASE_INSENSITIVE);
        Matcher _mathcer = _pattern.matcher(password);

        if (_mathcer.matches()) {
            return true;
        }
        return false;
    }
}
