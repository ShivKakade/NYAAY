package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web5 extends AppCompatActivity {

    WebView webv5;
    private String weburl5 = "https://court.mah.nic.in/courtweb/civil/html/chapter5.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv5 = (WebView) findViewById(R.id.webv5);
        webv5.loadUrl(weburl5);
    }
}