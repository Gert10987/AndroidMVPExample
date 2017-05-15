package info.gert.androidmvp.login.interactor;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by gert on 15.05.17.
 */

public class LoginInteractorImpl implements ILoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
