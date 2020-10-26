package com.example.programmingquestionbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private RadioButton optaion1,optaion2;

    private LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Choose Activity");


        //find button.......
        optaion1 = findViewById(R.id.option1);
        optaion2 = findViewById(R.id.option2);
        lottieAnimationView = findViewById(R.id.submitID);

        //set on click listener........
        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optaion1.isChecked()){

                    Intent i = new Intent(MainActivity.this,AdminActivity.class);
                    startActivity(i);
                }
                else if (optaion2.isChecked()){

                    Intent io = new Intent(MainActivity.this,StudentDashBoardActivity.class);
                    startActivity(io);
//StudentLoginActivity
                }
            }
        });

    }
}