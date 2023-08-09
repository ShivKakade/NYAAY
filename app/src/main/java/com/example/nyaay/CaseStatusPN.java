package com.example.nyaay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class CaseStatusPN extends AppCompatActivity {

    private FirebaseAuth mAuth;
    DatabaseReference reference;
    TextView name;
    String na,key;
    TextView adv_mail;
    Button search;
    CardView card;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_status_pn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adv_mail = findViewById(R.id.adv_mail);
        search = findViewById(R.id.search);
        card = findViewById(R.id.card);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseDatabase db1 =FirebaseDatabase.getInstance();
                DatabaseReference postRef =db1.getReference().child("Advocates");
                postRef.orderByChild("email").equalTo(adv_mail.getText().toString())
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for(DataSnapshot ds : snapshot.getChildren()){
                                    key = ds.getKey();
                                    name = (TextView)findViewById(R.id.nametextP);
                                    card.setVisibility(View.VISIBLE);
                                    getname();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });



    }

    private void getname() {
        mAuth = FirebaseAuth.getInstance();

        FirebaseDatabase db =FirebaseDatabase.getInstance();
        DatabaseReference root=db.getReference().child("Plaintiffs").child(mAuth.getCurrentUser().getUid());


        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                if(snapshot.exists()){
                     na = snapshot.child("name").getValue(String.class);
                     name.setText(na);
                     casefetch(na);
                }

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });
    }

    private void casefetch(String name) {

        mAuth = FirebaseAuth.getInstance();
        TextView caseno = (TextView)findViewById(R.id.Case_NOP);
        TextView penfees = (TextView)findViewById(R.id.pending_feesP);
        TextView hearingdate = (TextView)findViewById(R.id.hearing_dateP);
        TextView casestatus = (TextView)findViewById(R.id.CaseStatusP);
        TextView casetype = (TextView)findViewById(R.id.casetypeP);
        CircleImageView img = (CircleImageView)findViewById(R.id.imgP);


        FirebaseDatabase db =FirebaseDatabase.getInstance();
        DatabaseReference root=db.getReference().child("Advocates").child(key).child("cases").child(name);
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String purl = snapshot.child("purl").getValue(String.class);
                    Uri uri = Uri.parse(purl);
                    Glide.with(img.getContext()).load(uri).into(img);

                    caseno.setText(snapshot.child("case_number").getValue(String.class));
                    penfees.setText(snapshot.child("pending_fees").getValue(String.class));
                    hearingdate.setText(snapshot.child("hearing_date").getValue(String.class));
                    casestatus.setText(snapshot.child("case_status").getValue(String.class));
                    casetype.setText(snapshot.child("case_type").getValue(String.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}