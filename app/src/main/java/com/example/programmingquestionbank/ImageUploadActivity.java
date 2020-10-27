package com.example.programmingquestionbank;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

public class  ImageUploadActivity extends AppCompatActivity implements View.OnClickListener {

    private Button chooseButton,saveButton,displayButton;
    private ImageView imageView;
    private EditText imageNameEditText;
    private ProgressBar progressBar;
    private Uri imageUri;

    private  static  final  int IMAGE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);


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
                 break;
             case R.id.displayImageButton:
                 break;
         }
    }

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
}