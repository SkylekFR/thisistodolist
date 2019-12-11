package fr.skylek.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    private Button btAddTask;
    private ListTask listTask;
    private ArrayAdapter<Task> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
        this.listeners();
        listView.setAdapter(adapter);
    }




    void init(){
        listView = (ListView) findViewById(R.id.task_list);
        btAddTask = (Button) findViewById(R.id.btAddTask);
        listTask = new ListTask();
        listTask.getListTasks().add(new Task("No tasks defined", "This is the default task."));
        adapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, listTask.getListTasks().get());

    }
    void listeners(){
        btAddTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(listTask.getListTasks().get(0).getName() == "No tasks defined"){
            listTask.getListTasks().remove(0);
            listTask.getListTasks().add(new Task("MyFirstTask", "His descritpion"));
            adapter.notifyDataSetChanged();
        }else{
            listTask.getListTasks().add(new Task("MyFirstTask", "His descritpion"));
            adapter.notifyDataSetChanged();
        }
    }
}
