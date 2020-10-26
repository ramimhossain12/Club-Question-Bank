package com.example.programmingquestionbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;
import java.util.Arrays;
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


        
        //for image slider.............
        imageSlider = findViewById(R.id.slider1);
        List<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel("https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Best Pizza Collection "));
        slideModels.add(new SlideModel("https://cyber-breeze.com/wp-content/uploads/2017/02/featured-image-39.jpg","Pizza "));
        slideModels.add(new SlideModel("https://specials-images.forbesimg.com/imageserve/1152308114/960x0.jpg?fit=scale","Best Coffee Collection"));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Click The Butoon"));
        slideModels.add(new SlideModel("https://ichef.bbci.co.uk/news/660/cpsprodpb/3DAD/production/_104898751_gettyimages-844466808.jpg","Many items Food This Apps"));
        slideModels.add(new SlideModel("https://post.healthline.com/wp-content/uploads/sites/3/2020/02/324771_1100-1100x628.jpg","Tea"));

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
                    Intent in = new Intent(StudentDashBoardActivity.this,RetriveImageActivity.class);
                    startActivity(in);
                }
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

    }
}