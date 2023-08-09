package com.example.nyaay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileA extends AppCompatActivity {

    TextView Name,exp,enroll_no,email,mob_no,address,state;
    CircleImageView img;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Name = findViewById(R.id.nameP);
        exp = findViewById(R.id.exp);
        enroll_no = findViewById(R.id.enroll_no);
        email = findViewById(R.id.email);
        mob_no = findViewById(R.id.Mobile);
        address = findViewById(R.id.address);
        state = findViewById(R.id.state);
        img = (CircleImageView)findViewById(R.id.img3);
        mAuth = FirebaseAuth.getInstance();


        FirebaseDatabase db =FirebaseDatabase.getInstance();
        DatabaseReference root=db.getReference().child("Advocates").child(mAuth.getCurrentUser().getUid());
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String purl = snapshot.child("pimage").getValue(String.class);
                    Uri uri = Uri.parse(purl);
                    Glide.with(img.getContext()).load(uri).into(img);
                    Name.setText(snapshot.child("username").getValue(String.class));
                    exp.setText(snapshot.child("experience").getValue(String.class));
                    enroll_no.setText(snapshot.child("enroll_no").getValue(String.class));
                    email.setText(snapshot.child("email").getValue(String.class));
                    mob_no.setText(snapshot.child("mob_no").getValue(String.class));
                    address.setText(snapshot.child("address").getValue(String.class));
                    state.setText(snapshot.child("state").getValue(String.class));




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}