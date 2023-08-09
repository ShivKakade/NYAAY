package com.example.nyaay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationP extends AppCompatActivity {

    EditText username, password, repassword, email;
    Button signup, signin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        username =(EditText) findViewById(R.id.input_username);
        password =(EditText) findViewById((R.id.input_password));
        repassword=(EditText) findViewById((R.id.input_confirm_password));
        email=(EditText) findViewById(R.id.input_email);
        signup=(Button) findViewById(R.id.button_register);
        signin=(Button) findViewById(R.id.already_have_account);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString();
                String pass = password.getText().toString();
                String user = username.getText().toString();
                String repass = repassword.getText().toString();
                mAuth = FirebaseAuth.getInstance();


                if(user.equals("")||pass.equals("")||repass.equals("")||em.equals(""))
                    Toast.makeText(RegistrationP.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                if(Patterns.EMAIL_ADDRESS.matcher(em).matches()){
                    Toast.makeText(RegistrationP.this,"Email Verified",Toast.LENGTH_SHORT).show();

                    if(pass.equals(repass)){
                        mAuth.createUserWithEmailAndPassword(em,pass)
                                .addOnCompleteListener(RegistrationP.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task)
                                    {
                                        if(task.isSuccessful()){
                                            FirebaseDatabase db =FirebaseDatabase.getInstance();
                                            DatabaseReference root=db.getReference("Plaintiffs");
                                            dataholderP obj = new dataholderP(username.getText().toString());
                                            root.child(mAuth.getCurrentUser().getUid()).setValue(obj);
                                            Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                                            Intent in =new Intent(getApplicationContext(),LoginP.class);
                                            startActivity(in);
                                        }
                                        else
                                        {
                                            Toast.makeText(getApplicationContext(),"Registered Unsuccessfully",Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });


                    }
                    else{
                        Toast.makeText(RegistrationP.this,"Invalid password",Toast.LENGTH_SHORT).show();
                    }


                }
                else{
                    Toast.makeText(RegistrationP.this,"Please Enter valid Email address",Toast.LENGTH_SHORT).show();
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginP.class);
                startActivity(intent);
            }
        });
    }
}