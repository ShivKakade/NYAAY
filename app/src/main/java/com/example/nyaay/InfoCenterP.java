package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoCenterP extends AppCompatActivity {

    Button btn_CivilManual;
    Button btn_CriminalManual;
    Button btn_CaseCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_center_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_CivilManual = findViewById(R.id.btn_CivilManual);
        btn_CivilManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(InfoCenterP.this, CivilManualOptionsP.class);
                startActivity(intent);
            }
        });

        btn_CriminalManual = findViewById(R.id.btn_CriminalManual);
        btn_CriminalManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(InfoCenterP.this, CriminalManualP.class);
                startActivity(intent);
            }
        });

        btn_CaseCycle = findViewById(R.id.btn_CaseCycle);
        btn_CaseCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(InfoCenterP.this, CaseCycleP.class);
                startActivity(intent);
            }
        });
    }
}