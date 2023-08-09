package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MediForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medi_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}