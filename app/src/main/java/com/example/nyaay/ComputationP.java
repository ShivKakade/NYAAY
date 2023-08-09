package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class ComputationP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computation_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView web = findViewById(R.id.ComputationWebView);
        web.loadUrl("file:///android_asset/computation.html");
    }
}