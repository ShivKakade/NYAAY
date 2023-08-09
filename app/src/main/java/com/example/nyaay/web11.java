package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web11 extends AppCompatActivity {

    WebView webv11;
    private String weburl11 = "https://court.mah.nic.in/courtweb/civil/html/chapter11.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web11);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv11 = (WebView) findViewById(R.id.webv11);
        webv11.loadUrl(weburl11);
    }
}