package com.example.codingclass;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String checkQuestion5 = CoreLogic.withoutString("xxx", "xx");
        System.out.print(checkQuestion5);
    }
}