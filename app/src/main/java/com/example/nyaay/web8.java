package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web8 extends AppCompatActivity {

    WebView webv8;
    private String weburl8 = "https://court.mah.nic.in/courtweb/civil/html/chapter22.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web8);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv8 = (WebView) findViewById(R.id.webv8);
        webv8.loadUrl(weburl8);
    }
}