package fr.skylek.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(@NonNull Context context, List<Task> listTasks) {
        super(context, 0, listTasks);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new TweetViewHolder();
            viewHolder.title = convertView.findViewById(R.id.row_textView);
            viewHolder.checkBox = convertView.findViewById(R.id.row_checkBox);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Task task = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.title.setText(task.getName());


        return convertView;
    }

    private class TweetViewHolder {
        public TextView title;
        public CheckBox checkBox;

    }
}
