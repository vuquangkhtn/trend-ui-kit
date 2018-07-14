package com.onlinetest.vuquang.trend_ui_kit.splash;


import com.onlinetest.vuquang.trend_ui_kit.base.MvpPresenter;
import com.onlinetest.vuquang.trend_ui_kit.login.LoginMvpView;

/**
 * Created by VuQuang on 5/15/2018.
 */

public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {
    void onSignInClicked();
    void onSignUpClicked();
}
