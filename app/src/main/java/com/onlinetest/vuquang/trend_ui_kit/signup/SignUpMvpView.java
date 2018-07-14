package com.onlinetest.vuquang.trend_ui_kit.signup;


import com.onlinetest.vuquang.trend_ui_kit.base.MvpView;

/**
 * Created by VuQuang on 5/24/2018.
 */

public interface SignUpMvpView extends MvpView {
    void goToLogin();
    boolean isValid();
}
