package com.example.programmingquestionbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private RadioButton optaion1, optaion2;

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
                if (optaion1.isChecked()) {

                    Intent i = new Intent(MainActivity.this, AdminActivity.class);
                    startActivity(i);
                } else if (optaion2.isChecked()) {

                    Intent io = new Intent(MainActivity.this, StudentLoginActivity.class);

                    startActivity(io);

                }
            }
        });


    }

    //menu item find

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //menu item selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (item.getItemId() == R.id.ShareId) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/type");
            String subject = "Note_Book app";
            String body = "This app  is very useful .\n com.example.notepad";
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(intent, "share with"));


        } else if (item.getItemId() == R.id.feedbackID) {
            Intent intent = new Intent(getApplicationContext(), DeveloperFeedbackActivity.class);
            startActivity(intent);


        } else if (id == R.id.aboutId) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;



        }
        return super.onOptionsItemSelected(item);
    }

}