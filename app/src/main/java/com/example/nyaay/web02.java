package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web02 extends AppCompatActivity {

    WebView webv02;
    private String weburl02 = "https://court.mah.nic.in/courtweb/criminal/html/chapter2.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web02);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv02 = (WebView) findViewById(R.id.webv02);
        webv02.loadUrl(weburl02);

    }
}