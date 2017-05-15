package info.gert.androidmvp.main.tools;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import info.gert.androidmvp.R;
import info.gert.androidmvp.main.model.Task;

/**
 * Created by gert on 15.05.17.
 */

public class CustomAdapter extends ArrayAdapter<Task> {

    Context context;
    int layoutResourceId;
    List<Task> data = null;

    public CustomAdapter(Context context, int layoutResourceId, List<Task> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        TaskHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new TaskHolder();
            holder.taskName = (TextView)row.findViewById(R.id.taskNameCustom);
            holder.taskDesc = (TextView)row.findViewById(R.id.taskDescCustom);

            row.setTag(holder);
        }
        else
        {
            holder = (TaskHolder)row.getTag();
        }

        Task task = data.get(position);
        holder.taskName.setText(task.getName());
        holder.taskDesc.setText(task.getDescription());

        return row;
    }

    static class TaskHolder
    {
        TextView taskName;
        TextView taskDesc;
    }
}
