package com.cloudinteractive.samuelchou.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cloudinteractive.samuelchou.R;

public class Activity2 extends AppCompatActivity {
    // TODO: 2020/10/3 把API內容呈現： id, title, thumbnailUrl (image)
    // TODO: 2020/10/3 id,title: ⽂字center
    // TODO: 2020/10/3 thumbnailUrl: 以ImageView呈現於背景中
    // TODO: 2020/10/3 每⼀行放四個格⼦
    // TODO: 2020/10/3 點擊任一格進入第三個頁面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
}