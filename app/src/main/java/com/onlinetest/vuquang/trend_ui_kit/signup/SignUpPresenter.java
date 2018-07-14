package com.onlinetest.vuquang.trend_ui_kit.signup;

import android.support.annotation.NonNull;

import com.onlinetest.vuquang.trend_ui_kit.base.BasePresenter;

/**
 * Created by VuQuang on 5/24/2018.
 */

public class SignUpPresenter<V extends SignUpMvpView> extends BasePresenter<V> implements SignUpMvpPresenter<V>{
    @Override
    public void onNaviBackClicked() {
        getMvpView().goToLogin();
    }

    @Override
    public void onSignupClicked(String email, String password) {
        if (getMvpView().isValid()) {
            getMvpView().showMessage("Signup Successfully!");
            getMvpView().goToLogin();
        } else {
            getMvpView().showMessage("password is unconfirmed");
        }
    }
}
