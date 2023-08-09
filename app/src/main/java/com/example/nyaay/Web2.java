package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Web2 extends AppCompatActivity {

    WebView webv2;
    private String weburl2 = "https://court.mah.nic.in/courtweb/civil/html/chapter2.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webv2 = (WebView) findViewById(R.id.webv2);
        webv2.loadUrl(weburl2);
    }
}