package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web13 extends AppCompatActivity {

    WebView webv13;
    private String weburl13 = "https://court.mah.nic.in/courtweb/civil/html/chapter13.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web13);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv13 = (WebView) findViewById(R.id.webv13);
        webv13.loadUrl(weburl13);
    }
}