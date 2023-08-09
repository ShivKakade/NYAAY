package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web10 extends AppCompatActivity {

    WebView webv10;
    private String weburl10 = "https://court.mah.nic.in/courtweb/civil/html/chapter10.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web10);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv10 = (WebView) findViewById(R.id.webv10);
        webv10.loadUrl(weburl10);
    }
}