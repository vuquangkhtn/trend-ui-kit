package com.onlinetest.vuquang.trend_ui_kit.splash;

import com.onlinetest.vuquang.trend_ui_kit.base.BasePresenter;

/**
 * Created by VuQuang on 5/15/2018.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    @Override
    public void onSignInClicked() {
        getMvpView().goToSignInScreen();
    }

    @Override
    public void onSignUpClicked() {
        getMvpView().goToSignUpScreen();
    }



}
