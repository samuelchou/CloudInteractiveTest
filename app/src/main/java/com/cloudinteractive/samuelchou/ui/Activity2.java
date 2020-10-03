package com.cloudinteractive.samuelchou.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudinteractive.samuelchou.R;
import com.cloudinteractive.samuelchou.data.Gallery;

import java.util.ArrayList;
import java.util.List;

import studio.ultoolapp.lotusutil.EasyRecyclerViewAdapter;

public class Activity2 extends AppCompatActivity {
    // COMPLETED: 2020/10/3 id,title: ⽂字center
    // COMPLETED: 2020/10/3 thumbnailUrl: 以ImageView呈現於背景中
    // COMPLETED: 2020/10/3 每⼀行放四個格⼦

    private final List<Gallery.SingleImage> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        SetupContent();
    }

    private void SetupContent() {
        EasyRecyclerViewAdapter<Gallery.SingleImage> adapter
                = new EasyRecyclerViewAdapter<Gallery.SingleImage>(this, R.layout.item_image_with_text, itemList) {
            @Override
            public void bindData(View itemView, int position, Gallery.SingleImage data) {
                // TODO: 2020/10/3 把API內容呈現： id, title, thumbnailUrl (image)
                // COMPLETED: 2020/10/3 點擊任一格進入第三個頁面
                final int id = data.getId();
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Activity2.this, Activity3.class);
                        intent.putExtra(Activity3.ARG_ID, id);
                        startActivity(intent);
                    }
                });

            }
        };

        // TODO: 2020/10/3 讀取API資料...？
        itemList.clear();
        for (int i = 0; i < 100; i++) {
            itemList.add(new Gallery.SingleImage());
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(adapter);

    }


}