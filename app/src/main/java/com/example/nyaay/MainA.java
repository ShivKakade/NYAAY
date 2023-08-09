package com.example.nyaay;
import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import io.github.muddz.styleabletoast.StyleableToast;

public class MainA extends AppCompatActivity {

    Button btn_CaseStatus;
    Button btn_InfoCenter;
    Button btn_Forms;
    Button btn_Fees;
    Button btn_profile;
    DrawerLayout drawerLayout;
    NavigationView navigation;
    Toolbar toolbar;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn_CaseStatus = findViewById(R.id.btn_CaseStatus);
        btn_CaseStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainA.this, CaseStatusA.class);
                startActivity(intent);
            }
        });

        btn_InfoCenter = findViewById(R.id.btn_InfoCenter);
        btn_InfoCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainA.this, InfoCenterP.class);
                startActivity(intent);
            }
        });

        btn_Forms = findViewById(R.id.btn_Forms);
        btn_Forms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainA.this, FormsP.class);
                startActivity(intent);
            }
        });

        btn_Fees = findViewById(R.id.btn_Fees);
        btn_Fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainA.this, FeesP.class);
                startActivity(intent);
            }
        });

        btn_profile = findViewById(R.id.btn_profile);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainA.this, ProfileA.class);
                startActivity(intent);
            }
        });

        drawerLayout =  findViewById(R.id.drawer_layout);
        navigation=  findViewById(R.id.nav);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        StyleableToast.makeText(MainA.this,"Home",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        Intent i =new Intent(getApplicationContext(),LoginOptions.class);
                        startActivity(i);
                        break;
                    case R.id.privacyPolicy:
                        StyleableToast.makeText(MainA.this,"Privacy Policy",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        Intent i1 =new Intent(getApplicationContext(),Privacy_policy.class);
                        startActivity(i1);
                        break;
                    case R.id.logout:
                        StyleableToast.makeText(MainA.this,"Logout Successfully",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        Intent i2 =new Intent(getApplicationContext(),LoginOptions.class);
                        startActivity(i2);
                        break;
                    case R.id.contact:
                        StyleableToast.makeText(MainA.this,"Contact",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        Intent i3 =new Intent(getApplicationContext(),Contact_Us.class);
                        startActivity(i3);
                        break;
                    case R.id.nav_share:
                        Intent inte = new Intent(Intent.ACTION_SEND);
                        inte.setType("text/plain");
                        inte.putExtra(Intent.EXTRA_TEXT,"Download Our app :\n"+"https://drive.google.com/file/d/1cYRLsemEc-Ap8VG1PVyvN2iytSGI1mFI/view?usp=sharing");
                        try {
                            startActivity(Intent.createChooser(inte,"Share"));
                        }catch (android.content.ActivityNotFoundException ex){
                            StyleableToast.makeText(MainA.this,"No message Clients found",Toast.LENGTH_SHORT,R.style.CustomToast).show();

                        }
                        StyleableToast.makeText(MainA.this,"Share",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        break;
                    case R.id.mail:
                        Intent in = new Intent(Intent.ACTION_SEND);
                        in.setType("messgae/rfc822");
                        in.putExtra(Intent.EXTRA_EMAIL,new String[]{"Shivkakade45@gmail.com"});
                        in.putExtra(Intent.EXTRA_SUBJECT,"Contact us");
                        in.putExtra(Intent.EXTRA_TEXT,"Customer Support");
                        try {
                            startActivity(Intent.createChooser(in,"Send Email"));
                        }catch (android.content.ActivityNotFoundException ex){
                            StyleableToast.makeText(MainA.this,"No Email Clients found",Toast.LENGTH_SHORT,R.style.CustomToast).show();

                        }
                        StyleableToast.makeText(MainA.this,"Mail",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        break;
                    case R.id.phone:
                        Dexter.withActivity(MainA.this)
                                .withPermission(Manifest.permission.CALL_PHONE)
                                .withListener(new PermissionListener() {
                                    @Override
                                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse)
                                    {
                                        Intent intent = new Intent(Intent.ACTION_DIAL);
                                        intent.setData(Uri.parse("tel:"+"9307589583"));
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                                    }

                                    @Override
                                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                                    }
                                }).check();
                        StyleableToast.makeText(MainA.this,"Phone",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        break;

                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainA.this);
        builder.setTitle("Sign Out");
        builder.setMessage("Are you sure to Sign Out");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(),"Sign Out Successfully",Toast.LENGTH_SHORT).show();
                finish();
                Intent intent= new Intent(getApplicationContext(),LoginOptions.class);
                startActivity(intent);

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();    }
}