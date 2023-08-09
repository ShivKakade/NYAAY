package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeesP extends AppCompatActivity {

    Button btn_preliminary;
    Button btn_fihc;
    Button btn_computation;
    Button btn_probates;
    Button btn_ProcessFees;
    Button btn_OfTheMode;
    Button btn_Miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_preliminary = findViewById(R.id.btn_preliminary);
        btn_preliminary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PreliminaryP.class);
                //Intent intent = new Intent(FeesP.this, PreliminaryP.class);
                startActivity(intent);
            }
        });

        btn_fihc = findViewById(R.id.btn_fihc);
        btn_fihc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), PreliminaryP.class);
                Intent intent = new Intent(FeesP.this, FeesInTheHighCourtP.class);
                startActivity(intent);
            }
        });

        btn_computation = findViewById(R.id.btn_computation);
        btn_computation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ComputationP.class);
                //Intent intent = new Intent(FeesP.this, PreliminaryP.class);
                startActivity(intent);
            }
        });

        btn_probates = findViewById(R.id.btn_probates);
        btn_probates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProbatesP.class);
                //Intent intent = new Intent(FeesP.this, PreliminaryP.class);
                startActivity(intent);
            }
        });

        btn_ProcessFees = findViewById(R.id.btn_ProcessFees);
        btn_ProcessFees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProcessFeesP.class);
                //Intent intent = new Intent(FeesP.this, PreliminaryP.class);
                startActivity(intent);
            }
        });

        btn_OfTheMode = findViewById(R.id.btn_OfTheMode);
        btn_OfTheMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OfTheModeP.class);
                //Intent intent = new Intent(FeesP.this, PreliminaryP.class);
                startActivity(intent);
            }
        });

        btn_Miscellaneous = findViewById(R.id.btn_Miscellaneous);
        btn_Miscellaneous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MiscellaneousP.class);
                //Intent intent = new Intent(FeesP.this, PreliminaryP.class);
                startActivity(intent);
            }
        });
    }
}