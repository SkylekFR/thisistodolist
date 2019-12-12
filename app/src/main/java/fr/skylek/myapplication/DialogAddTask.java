package fr.skylek.myapplication;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

public class DialogAddTask extends Dialog {


    public DialogAddTask(@NonNull Context context) {
        super(context);
        this.setContentView(R.layout.layout_addtask_popup);
        this.setTitle("ADD TASK");


    }

    public Task getContentTask() {
        return null;
    }


}
