package com.cloudinteractive.samuelchou.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cloudinteractive.samuelchou.R;

public class Activity1 extends AppCompatActivity {
    // TODO: 2020/10/3 呈現名字及一個 Button，佔整體畫面各半之中間
    // TODO: 2020/10/3 點擊 Button 換場到下一個⾴面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }
}