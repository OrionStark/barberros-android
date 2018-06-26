package com.example.orionstark.barberros.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.orionstark.barberros.R;

public class MakeAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_appointment);
        //get the spinner from the xml.
        Spinner dropdown1 = findViewById(R.id.spinner1);
        String[] items1 = new String[]{"23", "12", "07" , "00", "11", "34", "55","11", "34", "55","11", "34", "55"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdown1.setAdapter(adapter1);

        Spinner dropdown2 = findViewById(R.id.spinner2);
        String[] items2 = new String[]{"59", "48", "29"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items2);
        dropdown2.setAdapter(adapter2);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio1:
                if (checked)
                    break;
            case R.id.radio2:
                if (checked)
                    break;
            case R.id.radio3:
                if (checked)
                    break;
            case R.id.radio4:
                if (checked)
                    break;
        }

    }
}
