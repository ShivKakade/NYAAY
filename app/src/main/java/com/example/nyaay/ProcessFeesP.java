package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class ProcessFeesP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_fees_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView web = findViewById(R.id.ProcessFeesWebView);
        web.loadUrl("file:///android_asset/processfees.html");
    }
}