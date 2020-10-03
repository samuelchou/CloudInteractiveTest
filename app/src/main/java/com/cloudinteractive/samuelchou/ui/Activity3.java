package com.cloudinteractive.samuelchou.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cloudinteractive.samuelchou.R;

public class Activity3 extends AppCompatActivity {
    // TODO: 2020/10/3 呈現點擊當格的id, title, thumbnailUrl 所對應的圖片
    // TODO: 2020/10/3 id, title: 文字置中呈現
    // TODO: 2020/10/3 thumbnailUrl: ImageView 呈現於背景中
    // TODO: 2020/10/3 點擊畫面任意地方返回上一頁

    public static final String ARG_ID = "Arg_ID";

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        if (intent.getExtras() == null) {
            // TODO: 2020/10/3 跳出訊息告知使用者 該Activity未能成功載入
            finish();
            return;
        }
        id = intent.getIntExtra(ARG_ID, -1);

        this.findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}