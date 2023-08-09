package com.example.nyaay;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;
import java.util.Random;

import io.github.muddz.styleabletoast.StyleableToast;

public class RegistrationA extends AppCompatActivity {

    EditText username, password,mobile_no,enroll_no,exp,city,state,address, repassword, email;
    Button signup, signin, browse;
    ProgressBar bar;
    ImageView img;
    Bitmap bitmap;
    Uri filepath,finalUri;
    String result,em;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_adv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        img = (ImageView)findViewById(R.id.profile_photo);
        browse = (Button)findViewById(R.id.browse);
        password =(EditText) findViewById((R.id.input_password));
        repassword=(EditText) findViewById((R.id.input_confirm_password));
        email=(EditText) findViewById(R.id.input_email);
        signup=(Button) findViewById(R.id.button_register);
        signin=(Button) findViewById(R.id.already_have_account);
        bar=(ProgressBar)findViewById(R.id.progressBar2);


        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(RegistrationA.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse)
                            {
                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Select Image"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadtofirebase();
                bar.setVisibility(View.VISIBLE);
                 em = email.getText().toString();
                String pass = password.getText().toString();

                mAuth = FirebaseAuth.getInstance();

                mAuth.createUserWithEmailAndPassword(em,pass)
                        .addOnCompleteListener(RegistrationA.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                if(task.isSuccessful()){
                                    bar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                                    Intent in =new Intent(getApplicationContext(),LoginA.class);
                                    startActivity(in);
                                }
                                else
                                {
                                    bar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getApplicationContext(),"Registered Unsuccessfully",Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginA.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==-1 && requestCode==101 ){
            result=data.getStringExtra("RESULT");
            finalUri=Uri.parse(result);

            try {
                InputStream inputStream= getContentResolver().openInputStream(finalUri);
                bitmap = BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            }catch (Exception ex)
            {
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }
        }
        if( requestCode==1 && resultCode==RESULT_OK)
       {
           filepath = data.getData();
           Intent inte = new Intent(RegistrationA.this,CropperActivity.class);
           inte.putExtra("DATA",filepath.toString());
           startActivityForResult(inte,101);


       }

    }

    private void uploadtofirebase()
    {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("File Uploader");
        dialog.show();

        username =(EditText) findViewById(R.id.input_username);
        mobile_no =(EditText)findViewById(R.id.input_Mobile);
        enroll_no =(EditText)findViewById(R.id.input_enrollment);
        exp = (EditText)findViewById(R.id.input_date);
        city = (EditText)findViewById(R.id.input_city);
        state = (EditText)findViewById(R.id.input_state);
        address =(EditText)findViewById(R.id.input_office);

        FirebaseStorage storage=FirebaseStorage.getInstance();
        StorageReference uploader=storage.getReference(username.getText().toString());
        uploader.putFile(finalUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
            {
                uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        dialog.dismiss();
                        FirebaseDatabase db =FirebaseDatabase.getInstance();
                        DatabaseReference root=db.getReference("Advocates");
                        dataholder obj=new dataholder(enroll_no.getText().toString(),state.getText().toString(),address.getText().toString(),city.getText().toString(),email.getText().toString(),exp.getText().toString(),mobile_no.getText().toString(),finalUri.toString(),username.getText().toString());
                        root.child(mAuth.getCurrentUser().getUid()).setValue(obj);
                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot)
            {
                float percent = (100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                dialog.setMessage("uploaded:"+(int)percent+" %");
            }
        });

    }
}