package com.example.testproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.testproject.R;
import com.example.testproject.view.TextileMidge;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextileMidge text2 = findViewById(R.id.text2);
        String text ="你好世界你好中国";
        text2.setTv(true,text);
    }
}