package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web6 extends AppCompatActivity {

    WebView webv6;
    private String weburl6 = "https://court.mah.nic.in/courtweb/civil/html/chapter21.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv6 = (WebView) findViewById(R.id.webv6);
        webv6.loadUrl(weburl6);
    }
}