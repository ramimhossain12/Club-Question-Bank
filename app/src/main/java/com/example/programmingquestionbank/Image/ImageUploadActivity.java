package com.example.programmingquestionbank.Image;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.programmingquestionbank.R;
import com.example.programmingquestionbank.StartActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;

public class  ImageUploadActivity extends AppCompatActivity implements View.OnClickListener {

    private Button chooseButton,saveButton,displayButton;
    private ImageView imageView;
    private EditText imageNameEditText;
    private ProgressBar progressBar;
    private Uri imageUri;


    DatabaseReference databaseReference;
    StorageReference storageReference;
    StorageTask uploadTask;

    private  static  final  int IMAGE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);


        databaseReference = FirebaseDatabase.getInstance().getReference("Image_Upload");
        storageReference = FirebaseStorage.getInstance().getReference("Image_Upload");

        //find ID
        chooseButton = findViewById(R.id.chooseImageButton);
        saveButton = findViewById(R.id.saveImageButton);
        displayButton = findViewById(R.id.displayImageButton);
        progressBar = findViewById(R.id.progressbarIDt);
        imageView  = findViewById(R.id.imageViewID);
        imageNameEditText = findViewById(R.id.imageNameEditTextID);


        saveButton.setOnClickListener(this);
        displayButton.setOnClickListener(this);
        chooseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


         switch (v.getId()){

             case  R.id.chooseImageButton:

                 openFileChooser();
                 break;
             case R.id.saveImageButton:
                 if (uploadTask!=null && uploadTask.isInProgress()){
                     Toast.makeText(getApplicationContext(),"Please wait uploading in picture",Toast.LENGTH_SHORT).show();
                 }
                 else{
                     saveData();
                 }
                 break;
             case R.id.displayImageButton:

                 Intent intent = new Intent(ImageUploadActivity.this,ImageActivity.class);
                 startActivity(intent);
                 break;
         }
    }



    // for image chooser..............
    private void openFileChooser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_REQUEST);
    }




    // for image load........

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

         if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK
                 && data != null && data.getData() != null){

             imageUri = data.getData();
             Picasso.get().load(imageUri).into(imageView);
         }
    }

    // getting the extension in image...........
    public String  getFileExtension(Uri imageUri){

        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return  mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));
    }

    // for image upload.......
    private void saveData() {

        final String imageName = imageNameEditText.getText().toString().trim();
        if (imageName.isEmpty()){
            imageNameEditText.setError("Enter the image name ");
            imageNameEditText.requestFocus();
            return;
        }

        StorageReference  ref = storageReference.child(System.currentTimeMillis()+"."+getFileExtension(imageUri));




        ref.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content

                        Toast.makeText(getApplicationContext(),"Image is stored successfully",Toast.LENGTH_SHORT).show();

                        Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!urlTask.isSuccessful());
                        Uri downloadUrl = urlTask.getResult();

                         ImageUpload upload = new ImageUpload(imageName, downloadUrl.toString());
                         String  uploadId = databaseReference.push().getKey();
                         databaseReference.child(uploadId).setValue(upload);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...

                        Toast.makeText(getApplicationContext(),"Image is Notstored successfully",Toast.LENGTH_SHORT).show();
                    }
                });
    }

}