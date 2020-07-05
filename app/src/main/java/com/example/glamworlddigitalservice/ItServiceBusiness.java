package com.example.glamworlddigitalservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.glamworlddigitalservice.serviceList.Immigrants;
import com.example.glamworlddigitalservice.serviceList.ServiceAdapter;
import com.example.glamworlddigitalservice.serviceList.Upload_Service;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ItServiceBusiness extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ServiceAdapter mAdapter;

    private ProgressBar progressBar;

    private DatabaseReference mDatabaseRef;
    private List<Upload_Service> mUploadServices;

    NewActivity newActivity;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);

        newActivity = new NewActivity();

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        progressBar = findViewById(R.id.progress_circular);

        mUploadServices = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Immigrants Service List");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload_Service uploadService = postSnapshot.getValue(Upload_Service.class);
                    mUploadServices.add(uploadService);
                }
                mAdapter = new ServiceAdapter(ItServiceBusiness.this, mUploadServices);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.setOnItemClickListener(new ServiceAdapter.OnItemClickListener() {
                    @Override
                    public void onItemCLick(int positon) {
                        String valueofName = mUploadServices.get(positon).getImgName();
                        String valueofPrice = mUploadServices.get(positon).getImgPrice();
                        String valueofDetails = mUploadServices.get(positon).getImgDetails();
                        String valueOfPhoto = mUploadServices.get(positon).getImgUrl();






                        Intent intent = new Intent(ItServiceBusiness.this, NewActivity.class);
                        intent.putExtra("name", valueofName);
                        intent.putExtra("price", valueofPrice);
                        intent.putExtra("details", valueofDetails);
                        intent.putExtra("url", valueOfPhoto);
                        startActivity(intent);
                    }
                });
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ItServiceBusiness.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }

}