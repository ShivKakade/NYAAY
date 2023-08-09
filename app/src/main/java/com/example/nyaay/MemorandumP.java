package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MemorandumP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorandum_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}