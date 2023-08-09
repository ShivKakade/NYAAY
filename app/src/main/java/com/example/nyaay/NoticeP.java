package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NoticeP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}