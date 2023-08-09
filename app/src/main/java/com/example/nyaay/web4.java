package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web4 extends AppCompatActivity {

    WebView webv4;
    private String weburl4 = "https://court.mah.nic.in/courtweb/civil/html/chapter4.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv4 = (WebView) findViewById(R.id.webv4);
        webv4.loadUrl(weburl4);
    }
}