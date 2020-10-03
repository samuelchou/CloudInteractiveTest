package com.cloudinteractive.samuelchou.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cloudinteractive.samuelchou.R;

public class Activity3 extends AppCompatActivity {
    // TODO: 2020/10/3 呈現點擊當格的id, title, thumbnailUrl 所對應的圖片
    // TODO: 2020/10/3 id, title: 文字置中呈現
    // TODO: 2020/10/3 thumbnailUrl: ImageView 呈現於背景中
    // TODO: 2020/10/3 點擊畫面任意地方返回上一頁

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }
}