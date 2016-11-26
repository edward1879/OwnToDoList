package com.example.android.owntodolist;

/**
 * Created by SunnyChan on 26/11/2016.
 */

public class ToDoItem {
    private String content;
    private String date;

    public ToDoItem() {
    }

    public ToDoItem(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
