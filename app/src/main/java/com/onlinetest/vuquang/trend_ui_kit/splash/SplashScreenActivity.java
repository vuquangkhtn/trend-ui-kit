package com.onlinetest.vuquang.trend_ui_kit.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseActivity;
import com.onlinetest.vuquang.trend_ui_kit.login.LoginActivity;
import com.onlinetest.vuquang.trend_ui_kit.signup.SignUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by VuQuang on 7/14/2018.
 */

public class SplashScreenActivity extends BaseActivity {
    private static final String TAG = "SplashScreenActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_login)
    public void onLoginClicked() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    @OnClick(R.id.btn_create_account)
    public void onSignUpClicked() {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
        finish();
    }

}
