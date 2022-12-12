package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

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

}