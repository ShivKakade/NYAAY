package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web16 extends AppCompatActivity {

    WebView webv16;
    private String weburl16 = "https://court.mah.nic.in/courtweb/civil/html/chapter18.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web16);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv16 = (WebView) findViewById(R.id.webv16);
        webv16.loadUrl(weburl16);
    }
}