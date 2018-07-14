package com.onlinetest.vuquang.trend_ui_kit.signup;


import com.onlinetest.vuquang.trend_ui_kit.base.MvpPresenter;

/**
 * Created by VuQuang on 5/24/2018.
 */

public interface SignUpMvpPresenter<V extends SignUpMvpView> extends MvpPresenter<V> {
    void onNaviBackClicked();

    void onSignupClicked(String email, String password);
}
