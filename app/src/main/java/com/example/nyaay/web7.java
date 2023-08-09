package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web7 extends AppCompatActivity {

    WebView webv7;
    private String weburl7 = "https://court.mah.nic.in/courtweb/civil/html/chapter7.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv7 = (WebView) findViewById(R.id.webv7);
        webv7.loadUrl(weburl7);
    }
}