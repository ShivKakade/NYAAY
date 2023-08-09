package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class OfTheModeP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_of_the_mode_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView web = findViewById(R.id.OfTheModeWebView);
        web.loadUrl("file:///android_asset/ofthemode.html");
    }
}