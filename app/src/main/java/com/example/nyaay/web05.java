package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web05 extends AppCompatActivity {

    WebView webv05;
    private String weburl05 = "https://court.mah.nic.in/courtweb/criminal/html/chapter7.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web05);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv05 = (WebView) findViewById(R.id.webv05);
        webv05.loadUrl(weburl05);
    }
}