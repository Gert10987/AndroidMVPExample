package info.gert.androidmvp.main.presenter;

import java.util.ArrayList;
import java.util.List;

import info.gert.androidmvp.main.model.Task;
import info.gert.androidmvp.main.view.ITaskView;

/**
 * Created by gert on 15.05.17.
 */

public class PresenterTask implements IPresenterTask{

    private ITaskView view;
    private List<Task> listOfTasks;

    public PresenterTask(ITaskView view){

        this.view = view;
        listOfTasks = new ArrayList<>();

        listOfTasks.add(new Task("name1", "ddsadsad"));
        listOfTasks.add(new Task("dsd", "dsadwad"));
        listOfTasks.add(new Task("ddw21312", "sdsadsads"));
        listOfTasks.add(new Task("dsadwada", "1321321321"));
    }

    @Override
    public void addNewTask(String name, String descOfTask) {

        listOfTasks.add(new Task(name, descOfTask));
    }

    @Override
    public List<Task> getAllTasks() {

        return listOfTasks;
    }

    @Override
    public void deleteTask(Object task) {

        Task t = (Task) task;
        listOfTasks.removeIf(x -> x.getName().equals(t.getName()));
    }

    @Override
    public void refresh() {

        if(view != null)
            view.loadData();
    }
}
