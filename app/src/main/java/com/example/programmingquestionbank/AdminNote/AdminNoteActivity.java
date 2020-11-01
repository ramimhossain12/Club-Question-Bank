package com.example.programmingquestionbank.AdminNote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.programmingquestionbank.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminNoteActivity extends AppCompatActivity {

    //    Button
    private EditText editText, editText2,editText3;
    private Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_note);



//find the button
        editText = findViewById(R.id.editTextID);
        savebutton = findViewById(R.id.saveButtonID);
        editText2 = findViewById(R.id.editTextID2);
        editText3 = findViewById(R.id.editTextID3);


        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  text = editText.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText2.getText().toString();
                if (text!=null){
                    writeToFIle(text);
                }
                if (text2!=null){
                    writeToFIle2(text2);
                }
                if (text3!=null){
                    writeToFIle3(text3);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter some data",Toast.LENGTH_SHORT).show();
                }
            }
        });

        readFromFile();
    }



    private void writeToFIle(String text) {

        try {
            FileOutputStream fileOutputStream = openFileOutput("Note.text", Context.MODE_PRIVATE);
            try {
                fileOutputStream.write(text.getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(),"  Note saved ",Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeToFIle2(String text2) {

        try {
            FileOutputStream fileOutputStream = openFileOutput("Note.text2", Context.MODE_PRIVATE);
            try {
                fileOutputStream.write(text2.getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(),"  Note saved ",Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeToFIle3(String text3) {

        try {
            FileOutputStream fileOutputStream = openFileOutput("Note.text3", Context.MODE_PRIVATE);
            try {
                fileOutputStream.write(text3.getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(),"  Note saved ",Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {

        try {
            FileInputStream fileInputStream = openFileInput("Note.text");

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line ;
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine())!=null){

                stringBuffer.append(line+"\n");
            }

            editText.setText(stringBuffer.toString());
            editText2.setText(stringBuffer.toString());
            editText3.setText(stringBuffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}