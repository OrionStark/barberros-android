package com.example.orionstark.barberros.controllers;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.orionstark.barberros.R;


public class Login_Page extends AppCompatActivity {
    private TextView title_apps;
    private TextView desc_app;
    private EditText email_field;
    private EditText password_field;
    private Button login_btn;
    private Button register_email_btn;
    private TextView forgot_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        this.setprops();
    }
    private void setprops() {
        this.title_apps = (TextView) findViewById(R.id.title_txt);
        this.desc_app = (TextView) findViewById(R.id.desc_txt);
        this.email_field = (EditText) findViewById(R.id.email_field_login);
        this.password_field = (EditText) findViewById(R.id.password_field_login);
        this.login_btn = (Button) findViewById(R.id.login_btn);
        this.register_email_btn = (Button) findViewById(R.id.register_btn);
        this.forgot_password = (TextView) findViewById(R.id.forgot_password);

        this.forgot_password.setPaintFlags(forgot_password.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        this.title_apps.setTypeface(Typeface.createFromAsset(getAssets(), "BreeSerif-Regular.ttf"));
        this.desc_app.setTypeface(Typeface.createFromAsset(getAssets(), "Poppins-Medium.ttf"));
        this.forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Page.this, Forgot_Password.class));
            }
        });
        this.register_email_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Page.this, Register.class));
            }
        });
    }
}
