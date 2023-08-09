package com.example.nyaay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }
 private FirebaseAuth mAuth;

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final model model) {
        holder.name.setText(model.getName());
        holder.case_status.setText(model.getCase_status());
        holder.case_type.setText(model.getCase_type());
        holder.hearing_date.setText(model.getHearing_date());
        holder.pending_fees.setText("Rs "+model.getPending_fees());
        holder.case_no.setText(model.getCase_number());
        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nam = model.getName();
                String pu = model.getPurl();
                String casenum = model.getCase_number();
                String casestat = model.getCase_status();
                String casety = model.getCase_type();
                String penfees = model.getPending_fees();
                String date = model.getHearing_date();

                String key =getRef(holder.getAdapterPosition()).getKey();

                Intent intent =new Intent(v.getContext(),Edit.class);
                intent.putExtra("purl",pu);
                intent.putExtra("name",nam);
                intent.putExtra("caseno",casenum);
                intent.putExtra("casestatus",casestat);
                intent.putExtra("casetype",casety);
                intent.putExtra("pendingfees",penfees);
                intent.putExtra("hearingdate",date);
                intent.putExtra("key",key);
                v.getContext().startActivity(intent);

            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete....?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAuth = FirebaseAuth.getInstance();
                        FirebaseDatabase.getInstance().getReference().child("Advocates").child(mAuth.getCurrentUser().getUid()).child("cases")
                                .child(model.getName()).removeValue();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
         return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name,case_type,case_status,pending_fees,hearing_date,case_no;
        Button edit,delete;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.nametext);
            edit=(Button)itemView.findViewById(R.id.edit);
            delete=(Button)itemView.findViewById(R.id.delete);
            img=(CircleImageView) itemView.findViewById(R.id.img1);
            case_type=(TextView)itemView.findViewById(R.id.casetype);
            case_status=(TextView)itemView.findViewById(R.id.CaseStatus);
            pending_fees=(TextView)itemView.findViewById(R.id.pending_fees);
            hearing_date=(TextView)itemView.findViewById(R.id.hearing_date);
            case_no=(TextView)itemView.findViewById(R.id.Case_NO);

        }
    }
}
