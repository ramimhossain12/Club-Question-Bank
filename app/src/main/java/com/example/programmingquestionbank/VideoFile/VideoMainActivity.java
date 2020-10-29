package com.example.programmingquestionbank.VideoFile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.example.programmingquestionbank.R;

public class VideoMainActivity extends AppCompatActivity {

    private  static  final  int PICK_VIDEO = 1;
    VideoView videoView;
    Button button;
    ProgressBar progressBar;
    EditText editText;
    private Uri videoUri;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_main);

        videoView = findViewById(R.id.videoview_MainID);
        button = findViewById(R.id.button_upload_main);
        progressBar = findViewById(R.id.progressBar_mainID);
        editText = findViewById(R.id.et_video_nameID);
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }


    // for choose video in storage
    public void ChooseVideo(View view) {

        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult(intent,PICK_VIDEO);
    }

    public void ShowVideo(View view) {
    }
}