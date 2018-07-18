package com.onlinetest.vuquang.trend_ui_kit.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseActivity;
import com.onlinetest.vuquang.trend_ui_kit.main.MainActivity;
import com.onlinetest.vuquang.trend_ui_kit.splash.SplashScreenActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by VuQuang on 7/14/2018.
 */

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";

    @BindView(R.id.edt_email) EditText mEdtEmail;
    @BindView(R.id.edt_password) EditText mEdtPassword;
    @BindView(R.id.btn_login) Button mBtnLogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mEdtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkAllEdtFilled();
            }
        });

        mEdtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkAllEdtFilled();
            }
        });

        checkAllEdtFilled();

    }


    @OnClick(R.id.imv_navi_back)
    public void onBackClicked() {
        goToSplash();
    }

    @OnClick(R.id.btn_login)
    public void onLoginClicked() {
        if(!validateForm()) {
            return;
        }
        goToMain();
    }

    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(mEdtEmail.getText().toString())) {
            mEdtEmail.setError("Required");
            result = false;
        } else {
            mEdtEmail.setError(null);
        }

        if (TextUtils.isEmpty(mEdtPassword.getText().toString())) {
            mEdtPassword.setError("Required");
            result = false;
        } else {
            mEdtPassword.setError(null);
        }

        return result;
    }

    private void checkAllEdtFilled() {
        if(!TextUtils.isEmpty(mEdtEmail.getText())
                && !TextUtils.isEmpty(mEdtPassword.getText()))
        {
            mBtnLogin.setEnabled(true);
        } else {
            mBtnLogin.setEnabled(false);
        }
    }

    public void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void goToSplash() {
        Intent i = new Intent(this, SplashScreenActivity.class);
        startActivity(i);
        finish();
    }
}
