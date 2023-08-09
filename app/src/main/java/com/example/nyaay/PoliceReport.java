package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PoliceReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_report);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}