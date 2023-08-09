package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web12 extends AppCompatActivity {

    WebView webv12;
    private String weburl12 = "https://court.mah.nic.in/courtweb/civil/html/chapter26.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web12);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv12 = (WebView) findViewById(R.id.webv12);
        webv12.loadUrl(weburl12);
    }
}