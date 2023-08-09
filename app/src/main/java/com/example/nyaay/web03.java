package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web03 extends AppCompatActivity {

    WebView webv03;
    private String weburl03 = "https://court.mah.nic.in/courtweb/criminal/html/chapter3.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web03);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv03 = (WebView) findViewById(R.id.webv03);
        webv03.loadUrl(weburl03);
    }
}