package com.example.nyaay;

import android.Manifest;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class adddata extends AppCompatActivity {
    CircleImageView img;
    EditText caseno, casestatus, casetype, hearingdate, pendingfees, name;
    Button submit, back, browse;
    Uri filepath, finalUri;
    String result;
    Bitmap bitmap;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);

        img = (CircleImageView) findViewById(R.id.profile_photo1);
        browse = (Button) findViewById(R.id.browse1);
        caseno = (EditText) findViewById(R.id.case_no1);
        casestatus = (EditText) findViewById(R.id.case_status1);
        casetype = (EditText) findViewById(R.id.case_type1);
        hearingdate = (EditText) findViewById(R.id.hearing_date1);
        pendingfees = (EditText) findViewById(R.id.pending_fees1);
        submit = (Button) findViewById(R.id.usubmit1);
        back = (Button) findViewById(R.id.back);
        name = (EditText) findViewById(R.id.Name1);

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(adddata.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CaseStatusA.class));
                finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadtofirebase();
            }
        });

    }

    private void uploadtofirebase() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("File Uploader");
        dialog.show();

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference uploader = storage.getReference(name.getText().toString());
        uploader.putFile(finalUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        dialog.dismiss();
                        mAuth = FirebaseAuth.getInstance();

                        Map<String, Object> map = new HashMap<>();
                        map.put("name", name.getText().toString());
                        map.put("purl", uri.toString());
                        map.put("case_number", caseno.getText().toString());
                        map.put("case_status", casestatus.getText().toString());
                        map.put("case_type", casetype.getText().toString());
                        map.put("pending_fees", pendingfees.getText().toString());
                        map.put("hearing_date", hearingdate.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("Advocates").child(mAuth.getCurrentUser().getUid()).child("cases").child(name.getText().toString())
                                .setValue(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(getApplicationContext(), "Inserted Succcessfully", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getApplicationContext(), "Inserted Unsucccessfully", Toast.LENGTH_SHORT).show();

                                    }
                                });


                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                float percent = (100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                dialog.setMessage("uploaded:" + (int) percent + " %");
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(getApplicationContext(), CaseStatusA.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == -1 && requestCode == 101) {
            result = data.getStringExtra("RESULT");
            finalUri = Uri.parse(result);

            try {
                InputStream inputStream = getContentResolver().openInputStream(finalUri);
                bitmap = BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == 1 && resultCode == RESULT_OK) {
            filepath = data.getData();
            Intent inte = new Intent(adddata.this, CropperActivity.class);
            inte.putExtra("DATA", filepath.toString());
            startActivityForResult(inte, 101);


        }

    }
}