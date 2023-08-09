package com.example.nyaay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginA extends AppCompatActivity {

    EditText email;
    EditText password;
    Button sin;
    Button btnlogin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sin = (Button)findViewById(R.id.sign_up);
        email=(EditText)findViewById(R.id.input_email);
        password=(EditText)findViewById(R.id.input_password_login);
        btnlogin=(Button)findViewById(R.id.button_login);
        mAuth = FirebaseAuth.getInstance();
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),RegistrationA.class);
                startActivity(i);
            }
        });

       btnlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String em = email.getText().toString();
               String pass = password.getText().toString();
               mAuth.signInWithEmailAndPassword(em,pass)
                       .addOnCompleteListener(LoginA.this, new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if(task.isSuccessful())
                               {
                                mAuth = FirebaseAuth.getInstance();
                                FirebaseDatabase db =FirebaseDatabase.getInstance();
                                DatabaseReference root=db.getReference().child("Plaintiffs").child(mAuth.getCurrentUser().getUid());
                                  root.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if(snapshot.exists()){
                                            Toast.makeText(getApplicationContext(),"Please login in Plaintiff section",Toast.LENGTH_SHORT).show();

                                        }else{
                                            Intent intent =new Intent(getApplicationContext(),MainA.class);
                                            startActivity(intent);
                                            Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();


                                        }

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                               }else
                               {
                                   Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                               }
                           }
                       });

           }
       });

    }
}