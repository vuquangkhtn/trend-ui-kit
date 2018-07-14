package com.onlinetest.vuquang.trend_ui_kit.login;

import android.support.annotation.NonNull;

import com.onlinetest.vuquang.trend_ui_kit.base.BasePresenter;

import java.util.GregorianCalendar;

/**
 * Created by VuQuang on 5/15/2018.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V>{

    @Override
    public void onSignInClicked(String email, String password) {
        getMvpView().goToMain();
    }

    @Override
    public void onNaviBackClicked() {
        getMvpView().goToSplash();
    }
}
