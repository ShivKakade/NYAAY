package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherFormsP extends AppCompatActivity {

    Button btn_FilingForm;
    Button btn_AddressForm;
    Button btn_bbform;
    Button listofdoc;
    Button btn_motoraccident;
    Button btn_mediform;
    Button btn_policereport;
    Button btn_appearance;
    Button btn_producedocument;
    Button btn_feeform;
    Button btn_bondform;
    Button btn_vakalatnama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_forms_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_FilingForm = findViewById(R.id.btn_FilingForm);
        btn_FilingForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, FilingFormP.class);
                startActivity(intent);
            }
        });

        btn_AddressForm = findViewById(R.id.btn_AddressForm);
        btn_AddressForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, AddressFormP.class);
                startActivity(intent);
            }
        });

        btn_bbform = findViewById(R.id.btn_bbform);
        btn_bbform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, BailBondP.class);
                startActivity(intent);
            }
        });

        listofdoc = findViewById(R.id.listofdoc);
        listofdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, ListOfDocFormP.class);
                startActivity(intent);
            }
        });

        btn_mediform = findViewById(R.id.btn_mediform);
        btn_mediform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, MediForm.class);
                startActivity(intent);
            }
        });

        btn_policereport = findViewById(R.id.btn_policereport);
        btn_policereport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, PoliceReport.class);
                startActivity(intent);
            }
        });

        btn_appearance = findViewById(R.id.btn_appearance);
        btn_appearance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, MemorandumP.class);
                startActivity(intent);
            }
        });

        btn_producedocument = findViewById(R.id.btn_producedocument);
        btn_producedocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, NoticeP.class);
                startActivity(intent);
            }
        });

        btn_motoraccident = findViewById(R.id.btn_motoraccident);
        btn_motoraccident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, MotorAccidentP.class);
                startActivity(intent);
            }
        });

        btn_feeform = findViewById(R.id.btn_feeform);
        btn_feeform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, ProcessFeesFormP.class);
                startActivity(intent);
            }
        });

        btn_bondform = findViewById(R.id.btn_bondform);
        btn_bondform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, SurityBondP.class);
                startActivity(intent);
            }
        });

        btn_vakalatnama = findViewById(R.id.btn_vakalatnamaform);
        btn_vakalatnama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(OtherFormsP.this, Vakalatnama.class);
                startActivity(intent);
            }
        });


    }
}