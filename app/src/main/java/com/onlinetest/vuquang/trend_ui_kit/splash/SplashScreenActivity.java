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

/**
 * Created by VuQuang on 7/14/2018.
 */

public class SplashScreenActivity extends BaseActivity implements SplashMvpView{
    private static final String TAG = "SplashScreenActivity";

    private SplashMvpPresenter<SplashMvpView> presenter;
    Button mBtnLogin, mBtnSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter<>();
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            presenter.onSignInClicked();
            }
        });

        mBtnSignUp = (Button) findViewById(R.id.btn_create_account);
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSignUpClicked();
            }
        });

        presenter.onAttach(SplashScreenActivity.this);

    }

    @Override
    public void goToSignInScreen() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void goToSignUpScreen() {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
        finish();
    }
}
