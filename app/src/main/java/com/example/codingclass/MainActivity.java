package com.example.codingclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String checkQuestion5 = CoreLogic.withoutString("Hello there", "llo");
        System.out.print(checkQuestion5);
    }
}