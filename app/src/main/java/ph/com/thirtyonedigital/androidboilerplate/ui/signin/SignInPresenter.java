package ph.com.thirtyonedigital.androidboilerplate.ui.signin;

import android.app.Activity;
import android.content.Intent;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

import ph.com.thirtyonedigital.androidboilerplate.ui.base.BasePresenter;

/**
 * Created by markcadag on 20/09/2017.
 */

public class SignInPresenter extends BasePresenter<SignInMvpView> {

    private LoginManager loginManager = LoginManager.getInstance();

    @Override
    public void attachView(SignInMvpView mvpView) {
        super.attachView(mvpView);
    }

    public void loginWithFacebook(activity,CallbackManager callbackManager) {
        loginManager.logInWithReadPermissions(new Activity(),Arrays.asList("public_profile"));
        loginManager.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                       getMvpView().showSignInSuccessful();
                    }

                    @Override
                    public void onCancel() {
                        getMvpView().showError();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        getMvpView().showError();
                    }
                });
    }

}
