package com.example.nyaay;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
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
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Edit extends AppCompatActivity {

    EditText name,caseno,casestatus,casetype,pendingfees,hearingdate;
    private FirebaseAuth mAuth;
    CircleImageView img;
    Uri filepath,finalUri,temp;
    String result,temp2;
    Bitmap bitmap;
    Boolean Clicked= false;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==-1 && requestCode==101 ){
            result=data.getStringExtra("RESULT");
            finalUri= Uri.parse(result);

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
            Intent inte = new Intent(Edit.this,CropperActivity.class);
            inte.putExtra("DATA",filepath.toString());
            startActivityForResult(inte,101);


        }

    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(getApplicationContext(),CaseStatusA.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
         img = findViewById(R.id.profile_photoU);
         name = findViewById(R.id.nametext1);
         caseno = findViewById(R.id.case_no);
         casestatus = findViewById(R.id.case_status);
         casetype = findViewById(R.id.case_type);
         pendingfees = findViewById(R.id.pending_fees);
         hearingdate = findViewById(R.id.hearing_date);
         Button update =findViewById(R.id.usubmit);
         Button browse = findViewById(R.id.browseU);

        String nam = getIntent().getStringExtra("name");
        String pu = getIntent().getStringExtra("purl");
        String casen = getIntent().getStringExtra("caseno");
        String casestat = getIntent().getStringExtra("casestatus");
        String casety = getIntent().getStringExtra("casetype");
        String penfees = getIntent().getStringExtra("pendingfees");
        String date = getIntent().getStringExtra("hearingdate");
        String key = getIntent().getStringExtra("key");

        name.setText(nam);
        caseno.setText(casen);
        casestatus.setText(casestat);
        casetype.setText(casety);
        pendingfees.setText(penfees);
        hearingdate.setText(date);
        temp = Uri.parse(pu);
        Glide.with(img.getContext()).load(temp).into(img);



        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clicked = true;
                Dexter.withActivity(Edit.this)
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




        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog dialog = new ProgressDialog(Edit.this);
                dialog.setTitle("File Uploader");
                dialog.show();

                FirebaseStorage storage=FirebaseStorage.getInstance();
                StorageReference uploader=storage.getReference(name.getText().toString());
                if(Clicked==false){
                    dialog.dismiss();
                    finalUri = Uri.parse(pu);
                    upload(finalUri);

                }else{
                    uploader.putFile(finalUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                        {
                            uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    dialog.dismiss();
                                    upload(uri);

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
        });

    }

    private void upload(Uri uri) {
        String pu = getIntent().getStringExtra("purl");
        String key = getIntent().getStringExtra("key");
        String nam = getIntent().getStringExtra("name");

        mAuth = FirebaseAuth.getInstance();

        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("purl",uri.toString());
        map.put("case_number",caseno.getText().toString());
        map.put("case_status",casestatus.getText().toString());
        map.put("case_type",casetype.getText().toString());
        map.put("pending_fees",pendingfees.getText().toString());
        map.put("hearing_date",hearingdate.getText().toString());


        FirebaseDatabase.getInstance().getReference().child("Advocates").child(mAuth.getCurrentUser().getUid()).child("cases")
                .child(nam).updateChildren(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(),"Updated Succesfully",Toast.LENGTH_SHORT).show();
                        finish();
                        Intent intent = new Intent(getApplicationContext(),CaseStatusA.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Can't Update due to some error",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });


    }
}