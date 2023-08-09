package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web07 extends AppCompatActivity {

    WebView webv07;
    private String weburl07 = "https://court.mah.nic.in/courtweb/criminal/html/chapter18.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web07);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv07 = (WebView) findViewById(R.id.webv07);
        webv07.loadUrl(weburl07);
    }
}