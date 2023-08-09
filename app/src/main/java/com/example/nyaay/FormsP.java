package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormsP extends AppCompatActivity {

    Button btn_list;
    Button btn_forms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(FormsP.this, ListOfDocP.class);
                startActivity(intent);
            }
        });

        btn_forms = findViewById(R.id.btn_forms);
        btn_forms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(FormsP.this, OtherFormsP.class);
                startActivity(intent);
            }
        });
    }
}