package info.gert.androidmvp.main.presenter;

import java.util.ArrayList;
import java.util.List;

import info.gert.androidmvp.main.model.Task;
import info.gert.androidmvp.main.view.ITaskView;

/**
 * Created by gert on 15.05.17.
 */

public class PresenterTask implements IPresenterTask {

    private ITaskView view;
    private List<Task> listOfTasks;

    public PresenterTask(ITaskView view) {

        this.view = view;
        listOfTasks = new ArrayList<>();

        listOfTasks.add(new Task("task1", "desc......task1"));
        listOfTasks.add(new Task("task2", "desc......task2"));
        listOfTasks.add(new Task("task3", "desc......task3"));
        listOfTasks.add(new Task("task4", "desc.... task4"));
    }

    @Override
    public void addNewTask(String name, String descOfTask) {

        listOfTasks.add(new Task(name, descOfTask));
        view.clearData();
    }

    @Override
    public List<Task> getAllTasks() {

        return listOfTasks;
    }

    @Override
    public void deleteTask(Object t) {

        Task task = (t instanceof Task) ? (Task) t : null;

        if (task != null)
            listOfTasks.remove(task);
    }

    @Override
    public void refresh() {

        if (view != null)
            view.loadData();
    }
}
