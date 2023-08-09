package com.example.nyaay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class CaseStatusA extends AppCompatActivity {

    RecyclerView recview;
    myadapter myadapter;
    FloatingActionButton fb;
    private FirebaseAuth mAuth;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        if (item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_case_status);
        recview= (RecyclerView)findViewById(R.id.recyclerView);
        recview.setLayoutManager(new LinearLayoutManager(this));
        Query basequery = FirebaseDatabase.getInstance().getReference().child("Advocates").child(mAuth.getCurrentUser().getUid()).child("cases");
        FirebaseRecyclerOptions<model>options=
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(basequery,model.class)
                        .build();

        myadapter=new myadapter(options);
        recview.setAdapter(myadapter);
        fb=(FloatingActionButton) findViewById(R.id.add);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),adddata.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainA.class);
        startActivity(intent);    }

    @Override
    protected void onStart(){
        super.onStart();
        myadapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        myadapter.stopListening();
    }
}