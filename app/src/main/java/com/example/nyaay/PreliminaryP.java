package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PreliminaryP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preliminary_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView web = findViewById(R.id.PreliminaryWebView);
        web.loadUrl("file:///android_asset/preliminary.html");
    }
}