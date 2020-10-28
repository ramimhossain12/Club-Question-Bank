package com.example.programmingquestionbank.Image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.programmingquestionbank.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterMy adapterMy;
    private List<ImageUpload> uploadList;
    private ProgressBar progressBar1;
    private FirebaseStorage firebaseStorage;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        progressBar1 = findViewById(R.id.progID);
        recyclerView = findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        uploadList = new ArrayList<>();
        firebaseStorage = FirebaseStorage.getInstance();



        databaseReference = FirebaseDatabase.getInstance().getReference("Image_Upload");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                  uploadList.clear();
                for (DataSnapshot dataSnapshot1: snapshot.getChildren() ){
                    ImageUpload upload = dataSnapshot1.getValue(ImageUpload.class);
                    upload.setKey(dataSnapshot1.getKey());
                    uploadList.add(upload);
                }
                adapterMy = new AdapterMy(ImageActivity.this,uploadList);
                recyclerView.setAdapter(adapterMy);

                adapterMy.setOnItemClickListener(new AdapterMy.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                    }

                    @Override
                    public void OndoAnyTask(int position) {

                    }

                    @Override
                    public void Ondelete(int position) {

                        ImageUpload selectedITem = uploadList.get(position);
                        final String key = selectedITem.getKey();

                        //for delete variable.....

                        StorageReference storageReference = firebaseStorage.getReferenceFromUrl(selectedITem.getImageUrl());
                        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                databaseReference.child(key).removeValue();
                                Toast.makeText(getApplicationContext(),"Image Delete",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                progressBar1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getApplicationContext(), "Error :" + error.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar1 .setVisibility(View.VISIBLE);
            }
        });
    }
}