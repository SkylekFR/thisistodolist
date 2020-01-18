package fr.skylek.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView listView;
    private Button btAddTask;
    String[] t = {"Test", "Tapis"};
    private ListTask listTask;
    private TaskAdapter taskAdapter;
    private DialogAddTask dialogAddTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
        this.listeners();
        listView.setAdapter(taskAdapter);

        Button popupBtAddTask = dialogAddTask.findViewById(R.id.popup_btaddTask);
        Button popupBtCancel = dialogAddTask.findViewById(R.id.pop_btCancel);
        popupBtAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText descEditText = dialogAddTask.findViewById(R.id.desc_editText);
                EditText titleEditText = dialogAddTask.findViewById(R.id.title_editText);
                listTask.getListTasks().add(new Task(titleEditText.getText().toString(), descEditText.getText().toString()));

                taskAdapter.notifyDataSetChanged();
                dialogAddTask.dismiss();
            }
        });
        popupBtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogAddTask.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   Intent intent = new Intent(MainActivity.this, DetailedTaskActivity.class);
                   intent.putExtra("myTask", listTask.getListTasks().get(position));
                   intent.putExtra("idTask", position);
                   startActivityForResult(intent, 1);

            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                if (data != null) {
                    listTask.getListTasks().remove(data.getExtras().getInt("idTask"));
                }
                taskAdapter.notifyDataSetChanged(); 
            }
        }
    }

    void init(){
        listView = findViewById(R.id.task_list);
        btAddTask = findViewById(R.id.btAddTask);
        listTask = new ListTask();
        taskAdapter = new TaskAdapter(this, listTask.getListTasks());
        dialogAddTask = new DialogAddTask(this);

    }
    void listeners(){
        btAddTask.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        dialogAddTask.show();
    }
}
