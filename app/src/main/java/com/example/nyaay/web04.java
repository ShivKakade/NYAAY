package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web04 extends AppCompatActivity {

    WebView webv04;
    private String weburl04 = "https://court.mah.nic.in/courtweb/criminal/html/chapter5.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web04);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv04 = (WebView) findViewById(R.id.webv04);
        webv04.loadUrl(weburl04);
    }
}