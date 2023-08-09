package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class web3 extends AppCompatActivity {

    WebView webv3;
    private String weburl3 = "https://court.mah.nic.in/courtweb/civil/html/chapter3.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webv3 = (WebView) findViewById(R.id.webv3);
        webv3.loadUrl(weburl3);
    }
}