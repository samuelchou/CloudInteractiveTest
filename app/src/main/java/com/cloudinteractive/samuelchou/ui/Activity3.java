package com.cloudinteractive.samuelchou.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cloudinteractive.samuelchou.R;
import com.cloudinteractive.samuelchou.data.InternetSourceAgent;
import com.cloudinteractive.samuelchou.databinding.Activity3Binding;
import com.cloudinteractive.samuelchou.viewmodel.SingleImageViewModel;

public class Activity3 extends AppCompatActivity {
    // COMPLETED: 2020/10/3 呈現點擊當格的id, title,
    // todo: 2020/10/3 thumbnailUrl 所對應的圖片
    // COMPLETED: 2020/10/3 id, title: 文字置中呈現
    // COMPLETED: 2020/10/3 thumbnailUrl: ImageView 呈現於背景中

    public static final String ARG_ID = "Arg_ID";

    private int id;
    private SingleImageViewModel singleImageViewModel;
    private Activity3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent.getExtras() == null) {
            // COMPLETED: 2020/10/3 跳出訊息告知使用者 該Activity未能成功載入
            Toast.makeText(this, R.string.msg_fail_to_load, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        id = intent.getIntExtra(ARG_ID, -1);
        if (id <= 0) {
            Toast.makeText(this, R.string.msg_fail_to_load, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        singleImageViewModel = new SingleImageViewModel(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_3);
        binding.setViewModel(singleImageViewModel);

        singleImageViewModel.RequestSingleImage(id);

        TestImageLoading();
    }

    private void TestImageLoading() {
        InternetSourceAgent agent = new InternetSourceAgent(this, "TEST");
        String url = "https://via.placeholder.com/150/9c184f";
        agent.RequestImage(url,
                binding.itemImage, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground);


    }
}