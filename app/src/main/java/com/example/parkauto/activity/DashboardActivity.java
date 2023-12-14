package com.example.parkauto.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.parkauto.R;

public class DashboardActivity extends AppCompatActivity {
    TextView firstname,lastname,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        firstname = findViewById(R.id.textViewWelcome);
        lastname = findViewById(R.id.textViewWelcome2);
        email = findViewById(R.id.textViewWelcome3);

        Intent intent = getIntent();
        if(intent.getExtras()!=null){
            String passedfn = intent.getStringExtra("data");
            String passedln = intent.getStringExtra("data1");
            String passedEmail = intent.getStringExtra("data2");

            firstname.setText(String.format("Welcome %s ",passedfn));
            lastname.setText(String.format("Welcome %s ",passedln));
            email.setText(String.format("Welcome %s ",passedEmail));


        }
    }
}