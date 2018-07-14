package com.onlinetest.vuquang.trend_ui_kit.login;


import com.onlinetest.vuquang.trend_ui_kit.base.MvpPresenter;

/**
 * Created by VuQuang on 5/15/2018.
 */

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {
    void onSignInClicked(String email, String password);

    void onNaviBackClicked();
}
