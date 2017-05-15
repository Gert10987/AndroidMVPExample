package info.gert.androidmvp.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemLongClick;
import info.gert.androidmvp.R;
import info.gert.androidmvp.main.presenter.IPresenterTask;
import info.gert.androidmvp.main.presenter.PresenterTask;
import info.gert.androidmvp.main.tools.CustomAdapter;

public class TaskActivity extends AppCompatActivity implements ITaskView {

    private IPresenterTask presenterTask;

    @BindView(R.id.tasksList)
    ListView tasksList;

    @BindView(R.id.taskName)
    EditText nameOfTask;

    @BindView(R.id.tasksDesc)
    EditText descTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        presenterTask = new PresenterTask(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenterTask.refresh();
    }

    @Override
    public void loadData() {

        tasksList.setAdapter(new CustomAdapter(this, R.layout.custom_list, presenterTask.getAllTasks()));
    }

    @Override
    @OnClick(R.id.addTasks)
    public void addTask() {

        presenterTask.addNewTask(nameOfTask.getText().toString(), descTask.getText().toString());
        presenterTask.refresh();
    }

    @Override
    @OnItemLongClick(R.id.tasksList)
    public boolean onItemLongClick(int position) {

        presenterTask.deleteTask(tasksList.getItemAtPosition(position));
        presenterTask.refresh();

        return true;
    }
}
