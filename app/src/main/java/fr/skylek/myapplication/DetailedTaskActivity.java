package fr.skylek.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailedTaskActivity extends AppCompatActivity {
    TextView tVtaskTitle;
    TextView tVtaskDesc;
    Task myTask;
    int idTask;
    Button btDeleteTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_task);
        tVtaskTitle = findViewById(R.id.detaile_task_activity_tv1);
        tVtaskDesc = findViewById(R.id.detaile_task_activity_tv2);
        btDeleteTask = findViewById(R.id.delete_btn_detailed_task_activity);


            myTask = getIntent().getParcelableExtra("myTask");
            Bundle bundle = getIntent().getExtras();
            idTask = bundle.getInt("idTask");
            tVtaskTitle.setText(myTask.getName());
            tVtaskDesc.setText(myTask.getDescription());

        btDeleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("idTask", idTask);
                setResult(RESULT_OK, result);
                finish();
            }
        });

    }
}
