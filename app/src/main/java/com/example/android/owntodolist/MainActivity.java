package com.example.android.owntodolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText et_addTask;
    ListView lv_taskList;
    ImageButton btn_addTask;
    ArrayList<ToDoItem> toDoItemArrayList;
    ToDoListAdapter toDoListAdapter;

    public final String PREFS_FILE = "PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toDoItemArrayList = new ArrayList<>();
        toDoListAdapter = new ToDoListAdapter(this, toDoItemArrayList);

        setUpUI();

    }

    private void setUpUI() {
        et_addTask = (EditText) findViewById(R.id.et_addTask);
        lv_taskList = (ListView) findViewById(R.id.list_view_main);
        btn_addTask = (ImageButton) findViewById(R.id.btn_addTask);
        lv_taskList.setAdapter(toDoListAdapter);

        btn_addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = String.valueOf(et_addTask.getText());
                String timeStamp = new SimpleDateFormat("dd/MM\nHH:mm:ss").format(Calendar.getInstance().getTime());
                ToDoItem toDoItem = new ToDoItem(content, timeStamp);
                toDoItemArrayList.add(toDoItem);
                toDoListAdapter.notifyDataSetChanged();
                et_addTask.setText("");
                logCat(content+", "+timeStamp);

            }
        });


    }

    private void setSharePreferences(String notes,int notesID){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(PREFS_FILE,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(notesID+"", notes).apply();

    }

    private void logCat(String message){
        Log.d("MainActivity", message);

    }

}
