package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListOfDocFormP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_doc_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}