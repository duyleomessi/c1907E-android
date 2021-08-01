package com.example.c1907e_android;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StudentNameAdapter extends BaseAdapter {
    private String[] studentsName;
    private Activity activity;

    public StudentNameAdapter(Activity activity, String[] studentsName) {
        this.studentsName = studentsName;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return studentsName.length;
    }

    @Override
    public Object getItem(int position) {
        return studentsName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        convertView = inflater.inflate(R.layout.list_view_item_name, null);

        TextView textView = (TextView) convertView.findViewById(R.id.list_view_item_name_tv);
        textView.setText(studentsName[position]);

        return convertView;
    }
}
