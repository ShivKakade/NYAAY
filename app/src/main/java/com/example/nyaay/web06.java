package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web06 extends AppCompatActivity {

    WebView webv06;
    private String weburl06 = "https://court.mah.nic.in/courtweb/criminal/html/chapter8.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web06);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv06 = (WebView) findViewById(R.id.webv06);
        webv06.loadUrl(weburl06);
    }
}