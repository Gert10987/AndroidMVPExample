package info.gert.androidmvp.login.presenter;

import info.gert.androidmvp.login.interactor.ILoginInteractor;
import info.gert.androidmvp.login.interactor.LoginInteractorImpl;
import info.gert.androidmvp.login.view.ILoginView;

/**
 * Created by gert on 15.05.17.
 */

public class PresenterLoginImpl implements IPresenterLogin, ILoginInteractor.OnLoginFinishedListener {

    private ILoginView loginView;
    private ILoginInteractor loginInteractor;

    public PresenterLoginImpl(ILoginView loginView){

        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onUsernameError() {

        if (loginView != null) {
            loginView.setUsenameError();
        }
    }

    @Override
    public void onPasswordError() {

        if (loginView != null) {
            loginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {

        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}
