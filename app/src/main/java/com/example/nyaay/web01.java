package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web01 extends AppCompatActivity {

    WebView webv01;
    private String weburl01 = "https://court.mah.nic.in/courtweb/criminal/html/chapter1.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web01);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webv01 = (WebView) findViewById(R.id.webv01);
        webv01.loadUrl(weburl01);

    }
}