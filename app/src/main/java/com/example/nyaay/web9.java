package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web9 extends AppCompatActivity {

    WebView webv9;
    private String weburl9 = "https://court.mah.nic.in/courtweb/civil/html/chapter9.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web9);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv9 = (WebView) findViewById(R.id.webv9);
        webv9.loadUrl(weburl9);
    }
}