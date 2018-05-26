package com.example.orionstark.barberros;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.orionstark.barberros.controllers.Login_Page;
import com.example.orionstark.barberros.services.BarberrosService;

import org.json.JSONException;

public class SplashScreen extends AppCompatActivity {
    TextView title_text;
    TextView description;
    private static int splashInterval = 3000;//set waktu lama Splashscreen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        this.title_text = (TextView)findViewById(R.id.title_text);
        this.description = (TextView)findViewById(R.id.description_text);
        this.title_text.setTypeface(Typeface.createFromAsset(getAssets(), "BreeSerif-Regular.ttf"));
        this.description.setTypeface(Typeface.createFromAsset(getAssets(), "Poppins-Medium.ttf"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,Login_Page.class);
                startActivity(i);//Menghubungkan activity splashscreen ke login page dengan intent
                //jeda selesai SplashScreen
                try {
                    BarberrosService.register(
                            "ian",
                            "test",
                            "test_sec",
                            "blablabla@gmail.com",
                            SplashScreen.this,
                            new BarberrosService.RegisterCallback() {
                                @Override
                                public void onSucceed(String message) {
                                    Log.d("RESS", message);
                                }

                                @Override
                                public void onError(String message) {
                                    Log.d("ERR", message);
                                }
                            }
                    );
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.finish();
            }
            public void finish(){
                //TODO Auto-generated method sub
            }
        }, splashInterval);
    }
}
