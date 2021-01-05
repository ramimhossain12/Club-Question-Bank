package com.example.programmingquestionbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class AdminActivity extends AppCompatActivity {
    private EditText Name, Password;
    //private LottieAnimationView animationView;
    private  Button bt;
    private TextView info;
    private  int counter =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etpassword);
        bt = findViewById(R.id.btnLogin);
        info = findViewById(R.id.tvinfo);

        info.setText("No of attempts remaining : 5");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword) {

        if ((userName.equals("admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(AdminActivity.this,AdminDashBoardActivity.class);
            startActivity(intent);
        }else {
            counter--;
            info.setText("No of attempts remaining:" + String.valueOf(counter));
            if (counter == 0){
                bt.setEnabled(false);
            }
        }
    }
}