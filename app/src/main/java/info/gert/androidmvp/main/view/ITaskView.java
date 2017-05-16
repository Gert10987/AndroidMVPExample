package info.gert.androidmvp.main.view;

/**
 * Created by gert on 15.05.17.
 */

public interface ITaskView {

    void loadData();

    void addTask();

    boolean onItemLongClick(int position);

    void clearData();
}
