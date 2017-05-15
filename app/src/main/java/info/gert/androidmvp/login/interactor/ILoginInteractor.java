package info.gert.androidmvp.login.interactor;

/**
 * Created by gert on 15.05.17.
 */

public interface ILoginInteractor {

    interface OnLoginFinishedListener {

        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
