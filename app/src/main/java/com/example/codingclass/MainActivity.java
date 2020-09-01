package com.example.codingclass;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrSample = {"1", "z", "3", "z", "1", "5", "a"};
        Map<String, Integer> checkQuestion = CoreLogic.sayWordCount(arrSample);
        System.out.print(checkQuestion);
    }
}