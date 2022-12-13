package com.example.counter;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView counter;
//Button inc_btn,dec_btn,res_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // setting values from activity main . xml
        counter = findViewById(R.id.counter);/*
        inc_btn = findViewById(R.id.btn_inc);
        dec_btn = findViewById(R.id.btn_dec);
        res_btn = findViewById(R.id.btn_res);*/

        ReadData();
    }
    public void Increment(View v){
        int count = Integer.parseInt(counter.getText().toString());
        count++;
        counter.setText(Integer.toString(count));
    }


    public void Decrement(View v){
        int count = Integer.parseInt(counter.getText().toString());
        count--;
        counter.setText(Integer.toString(count));
    }

    public void Reset(View v){
        int count = Integer.parseInt(counter.getText().toString());
        count = 0;
        counter.setText(Integer.toString(count));
    }

    public void ReadData(){
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        String s1 = sh.getString("name", "0");

// We can then use the data
        counter.setText(s1);

    }


    public void SaveData(){

// Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
        myEdit.putString("name", counter.getText().toString());

        myEdit.commit();
    }

    @Override
    protected void onStart() {
        ReadData();
        super.onStart();
    }

    @Override
    protected void onStop() {
        SaveData();
        super.onStop();
    }
}