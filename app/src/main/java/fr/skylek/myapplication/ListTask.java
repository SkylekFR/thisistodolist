package fr.skylek.myapplication;

import java.util.ArrayList;

public class ListTask {
    private ArrayList<Task> listTasks;

    public ListTask(){
        this.listTasks = new ArrayList<>();
    }

    public ArrayList<Task> getListTasks() {
        return listTasks;
    }

    public void setListTasks(ArrayList<Task> listTasks) {
        this.listTasks = listTasks;
    }
}
