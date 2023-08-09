package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CaseStatusP extends AppCompatActivity {

    Button btn_CaseNumber;
    Button btn_FIRNumber;
    Button btn_AdvName;
    Button btn_FilingNumber;
    Button btn_CaseType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_status_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_CaseNumber = findViewById(R.id.btn_CaseNumber);
        btn_CaseNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(CaseStatusP.this, CaseNumberP.class);
                startActivity(intent);
            }
        });

        btn_FIRNumber = findViewById(R.id. btn_FIRNumber);
        btn_FIRNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(CaseStatusP.this, FIRNumberP.class);
                startActivity(intent);
            }
        });

        btn_AdvName = findViewById(R.id. btn_AdvName);
        btn_AdvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(CaseStatusP.this, AdvocateNameP.class);
                startActivity(intent);
            }
        });

        btn_FilingNumber = findViewById(R.id. btn_FilingNumber);
        btn_FilingNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(CaseStatusP.this, FilingNumberP.class);
                startActivity(intent);
            }
        });

        btn_CaseType = findViewById(R.id. btn_CaseType);
        btn_CaseType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(CaseStatusP.this, CaseTypeP.class);
                startActivity(intent);
            }
        });

    }
}