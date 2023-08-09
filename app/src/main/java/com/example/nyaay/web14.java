package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web14 extends AppCompatActivity {

    WebView webv14;
    private String weburl14 = "https://court.mah.nic.in/courtweb/civil/html/chapter15.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web14);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv14 = (WebView) findViewById(R.id.webv14);
        webv14.loadUrl(weburl14);
    }
}