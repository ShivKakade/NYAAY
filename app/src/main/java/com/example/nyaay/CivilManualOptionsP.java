package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CivilManualOptionsP extends AppCompatActivity {

    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_10;
    Button btn_11;
    Button btn_12;
    Button btn_13;
    Button btn_14;
    Button btn_15;
    Button btn_16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_manual_options_p);

        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), Web1.class);
                startActivity(intent);
            }
        });

        btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), Web2.class);
                startActivity(intent);
            }
        });

        btn_3 = findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web3.class);
                startActivity(intent);
            }
        });

        btn_4 = findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web4.class);
                startActivity(intent);
            }
        });

        btn_5 = findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web5.class);
                startActivity(intent);
            }
        });

        btn_6 = findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web6.class);
                startActivity(intent);
            }
        });

        btn_7 = findViewById(R.id.btn_7);
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web7.class);
                startActivity(intent);
            }
        });

        btn_8 = findViewById(R.id.btn_8);
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web8.class);
                startActivity(intent);
            }
        });

        btn_9 = findViewById(R.id.btn_9);
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web9.class);
                startActivity(intent);
            }
        });

        btn_10 = findViewById(R.id.btn_10);
        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web10.class);
                startActivity(intent);
            }
        });

        btn_11 = findViewById(R.id.btn_11);
        btn_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web11.class);
                startActivity(intent);
            }
        });

        btn_12 = findViewById(R.id.btn_12);
        btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web12.class);
                startActivity(intent);
            }
        });

        btn_13 = findViewById(R.id.btn_13);
        btn_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web13.class);
                startActivity(intent);
            }
        });

        btn_14 = findViewById(R.id.btn_14);
        btn_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web14.class);
                startActivity(intent);
            }
        });

        btn_15 = findViewById(R.id.btn_15);
        btn_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web15.class);
                startActivity(intent);
            }
        });

        btn_16 = findViewById(R.id.btn_16);
        btn_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), web16.class);
                startActivity(intent);
            }
        });



    }
}