package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CaseNumberP extends AppCompatActivity {

    WebView webcaseno;
    private String webcasenourl = "https://court.mah.nic.in/courtweb/index_eng.php#";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_number_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webcaseno = (WebView) findViewById(R.id.webcaseno);
        webcaseno.loadUrl(webcasenourl);

    }
}