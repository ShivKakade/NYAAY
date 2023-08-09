package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web15 extends AppCompatActivity {

    WebView webv15;
    private String weburl15 = "https://court.mah.nic.in/courtweb/civil/html/chapter17.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web15);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv15 = (WebView) findViewById(R.id.webv15);
        webv15.loadUrl(weburl15);
    }
}