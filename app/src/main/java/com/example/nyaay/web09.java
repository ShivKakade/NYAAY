package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web09 extends AppCompatActivity {

    WebView webv09;
    private String weburl09 = "https://court.mah.nic.in/courtweb/criminal/html/chapter22html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web09);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv09 = (WebView) findViewById(R.id.webv09);
        webv09.loadUrl(weburl09);
    }
}