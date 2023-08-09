package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web1 extends AppCompatActivity {

    WebView webv1;
    private String weburl1 = "https://court.mah.nic.in/courtweb/civil/html/chapter1.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web1);

        webv1 = (WebView) findViewById(R.id.webv1);
        webv1.loadUrl(weburl1);

    }
}