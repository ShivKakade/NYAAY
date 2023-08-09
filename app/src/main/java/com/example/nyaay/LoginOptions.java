package com.example.nyaay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginOptions extends AppCompatActivity {

    Button button_plantiffs;
    Button button_adv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_plantiffs = findViewById(R.id.button_plantiffs);
        button_plantiffs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(LoginOptions.this, LoginP.class);
                startActivity(intent);
            }
        });
        button_adv = findViewById(R.id.button_adv);
        button_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(LoginOptions.this, LoginA.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(LoginOptions.this);
        builder.setTitle("Close App");
        builder.setMessage("Are you sure to Close application?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}