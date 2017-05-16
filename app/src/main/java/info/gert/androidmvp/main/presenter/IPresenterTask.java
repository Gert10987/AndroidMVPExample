package info.gert.androidmvp.main.presenter;

import java.util.List;

import info.gert.androidmvp.main.model.Task;

/**
 * Created by gert on 15.05.17.
 */

public interface IPresenterTask{

    void addNewTask(String name, String descOfTask);

    List<Task> getAllTasks();

    void deleteTask(Object name);

    void refresh();
}
