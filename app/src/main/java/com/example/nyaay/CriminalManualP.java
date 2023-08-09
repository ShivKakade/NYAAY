package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CriminalManualP extends AppCompatActivity {

    Button btn_01;
    Button btn_02;
    Button btn_03;
    Button btn_04;
    Button btn_05;
    Button btn_06;
    Button btn_07;
    Button btn_08;
    Button btn_09;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminal_manual_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_01 = findViewById(R.id.btn1);
        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web01.class);
                startActivity(intent);
            }
        });

        btn_02 = findViewById(R.id.btn2);
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web02.class);
                startActivity(intent);
            }
        });

        btn_03 = findViewById(R.id.btn3);
        btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web03.class);
                startActivity(intent);
            }
        });

        btn_04 = findViewById(R.id.btn4);
        btn_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web4.class);
                startActivity(intent);
            }
        });

        btn_05 = findViewById(R.id.btn5);
        btn_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web05.class);
                startActivity(intent);
            }
        });

        btn_06 = findViewById(R.id.btn6);
        btn_06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web06.class);
                startActivity(intent);
            }
        });

        btn_07 = findViewById(R.id.btn7);
        btn_07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web07.class);
                startActivity(intent);
            }
        });

        btn_08 = findViewById(R.id.btn8);
        btn_08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web08.class);
                startActivity(intent);
            }
        });

        btn_09 = findViewById(R.id.btn9);
        btn_09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web09.class);
                startActivity(intent);
            }
        });
    }
}