package com.example.programmingquestionbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalanderActivity extends AppCompatActivity {

    CalendarView mCalanderView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);

        String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        display(date);
        mCalanderView = findViewById(R.id.calanderID);
        mCalanderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String  date = dayOfMonth + "-" + "0" + (month + 1) + "-" + year;
                display(date);
            }
        });
    }

    public void display(String date) {

        textView = findViewById(R.id.tCanl);
        textView.setText(""+ date);


    }
}