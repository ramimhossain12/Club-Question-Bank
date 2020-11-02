package com.example.programmingquestionbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.programmingquestionbank.Image.ImageActivity;
import com.example.programmingquestionbank.Image.ImageUploadActivity;

import java.util.ArrayList;
import java.util.List;

public class StudentDashBoardActivity extends AppCompatActivity {


    //image slider
    ImageSlider imageSlider;



    int[] images = {R.drawable.files, R.drawable.upload,R.drawable.picture, R.drawable.video, R.drawable.note, R.drawable.calendar, R.drawable.barcode};
    String[] title, desc;
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dash_board);
        getSupportActionBar().setTitle("Student DashBoard");



        //for image slider.............
        imageSlider = findViewById(R.id.slider1);
        List<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1498050108023-c5249f4df085?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Happy Coding"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1542903660-eedba2cda473?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Coding "));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1535551951406-a19828b0a76b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1046&q=80","PHP Coding"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1504384308090-c894fdcc538d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "Programming Contest"));
        slideModels.add(new SlideModel ("https://images.unsplash.com/photo-1560264418-c4445382edbc?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Team Work"));
        slideModels.add(new SlideModel ("https://images.unsplash.com/photo-1504384308090-c894fdcc538d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "Programming Contest"));

        imageSlider.setImageList(slideModels,true);

        recyclerView = findViewById(R.id.recyclerView);
        title = getResources().getStringArray(R.array.topic_name);
        desc = getResources().getStringArray(R.array.topic_desc);


        myAdapter = new MyAdapter(this,title,desc,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (position==0){
                    Intent in = new Intent(StudentDashBoardActivity.this,RetriveFileActivity.class);
                    startActivity(in);
                }

                if (position==1){
                    Intent in = new Intent(StudentDashBoardActivity.this, ImageUploadActivity.class);
                    startActivity(in);
                }

                if (position==2){
                    Intent in = new Intent(StudentDashBoardActivity.this, ImageActivity.class);
                    startActivity(in);
                }

                if (position==5){
                    Intent in = new Intent(StudentDashBoardActivity.this, CalanderActivity.class);
                    startActivity(in);
                }
                if (position==6){
                    Intent in = new Intent(StudentDashBoardActivity.this, BarCodeScanner.class);
                    startActivity(in);
                }
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

    }
}