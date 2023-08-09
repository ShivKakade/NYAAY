package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MiscellaneousP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscellaneous_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView web = findViewById(R.id.MiscellaneousWebView);
        web.loadUrl("file:///android_asset/miscellaneous.html");
    }
}