package com.example.programmingquestionbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class AdminDashBoardActivity extends AppCompatActivity {
    ImageSlider imageSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_board);


        //now we can create two types of slider first using viewpager
        //and another using third party library which is easy to use let's get started
         imageSlider=findViewById(R.id.slider);
         List<SlideModel> slideModel = new ArrayList<>();
        slideModel.add(new SlideModel("https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Best Pizza Collection "));
        slideModel.add(new SlideModel("https://cyber-breeze.com/wp-content/uploads/2017/02/featured-image-39.jpg","Pizza "));
        slideModel.add(new SlideModel("https://specials-images.forbesimg.com/imageserve/1152308114/960x0.jpg?fit=scale","Best Coffee Collection"));
        slideModel.add(new SlideModel("https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Click The Butoon"));
        slideModel.add(new SlideModel("https://ichef.bbci.co.uk/news/660/cpsprodpb/3DAD/production/_104898751_gettyimages-844466808.jpg","Many items Food This Apps"));
        slideModel.add(new SlideModel("https://post.healthline.com/wp-content/uploads/sites/3/2020/02/324771_1100-1100x628.jpg","Tea"));

        imageSlider.setImageList(slideModel,true);

    }
}