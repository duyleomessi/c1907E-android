package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        listView = (ListView) findViewById(R.id.act_list_view_lv);
        String[] students = {"Pham Van Tan", "Phạm Viết Hồng Lĩnh", "Nguyễn Đức Huy", "Đặng Xuân Thanh", "Phạm Xuân Tùng", "Trần Quang Huy"};
        StudentNameAdapter adapter = new StudentNameAdapter(this, students);
        listView.setAdapter(adapter);
    }
}