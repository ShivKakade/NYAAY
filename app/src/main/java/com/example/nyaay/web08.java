package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web08 extends AppCompatActivity {

    WebView webv08;
    private String weburl08 = "https://court.mah.nic.in/courtweb/criminal/html/chapter20.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web08);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv08 = (WebView) findViewById(R.id.webv08);
        webv08.loadUrl(weburl08);
    }
}