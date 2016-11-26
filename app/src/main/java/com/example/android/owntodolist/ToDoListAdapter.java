package com.example.android.owntodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SunnyChan on 26/11/2016.
 */

public class ToDoListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ToDoItem> dataset;

    public ToDoListAdapter(Context context, ArrayList<ToDoItem> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int i) {
        return dataset.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.to_do_item_cell, viewGroup, false);
            viewHolder.tv_date = (TextView) view.findViewById(R.id.tv_date);
            viewHolder.tv_content = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ToDoItem toDoItem = (ToDoItem) getItem(i);
        viewHolder.tv_content.setText(toDoItem.getContent());
        viewHolder.tv_date.setText(toDoItem.getDate());

        return view;
    }

    static class ViewHolder {
        TextView tv_date;
        TextView tv_content;

    }

}
