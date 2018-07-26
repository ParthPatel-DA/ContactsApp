package com.example.jswn.contactsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JSWN on 23-03-2018.
 */

class MyAdapter extends BaseAdapter {
    ArrayList<MyData> arr;
    Context context;

    public MyAdapter(ArrayList<MyData> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.rowdesign,parent,false);
        TextView id = convertView.findViewById(R.id.id);
        TextView name = convertView.findViewById(R.id.name);
        TextView mobileno = convertView.findViewById(R.id.mobileNo);

//        id.setText(" " +arr.get(position).getId());
        name.setText(arr.get(position).getName());
        mobileno.setText(arr.get(position).getPhoneNo());

        return convertView;
    }
}
