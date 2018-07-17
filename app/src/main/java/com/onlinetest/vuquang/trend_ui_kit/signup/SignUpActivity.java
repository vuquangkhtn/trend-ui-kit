package com.onlinetest.vuquang.trend_ui_kit.signup;

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
import com.onlinetest.vuquang.trend_ui_kit.splash.SplashScreenActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by VuQuang on 7/14/2018.
 */

public class SignUpActivity extends BaseActivity {
    private static final String TAG = "SignUpActivity";

    @BindView(R.id.edt_email) EditText mEdtEmail;
    @BindView(R.id.edt_password) EditText mEdtPassword;
    @BindView(R.id.edt_confirm_password) EditText mEdtConfirmPass;
    @BindView(R.id.btn_create_account) Button mBtnCreateAcc;

    @OnClick(R.id.btn_create_account) public void onCreateAccountClicked() {
        if(!validateForm() || !isValid()) {
            showSnackBar("Signup Failed");
        } else {
            showSnackBar("Signup Successful");
            goToLogin();

        }
    }

    @OnClick(R.id.imv_navi_back) public void onNaviBackClicked() {
        goToSplash();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        mEdtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkAllEditTextFilled();
            }
        });

        mEdtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkAllEditTextFilled();
            }
        });

        mEdtConfirmPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkAllEditTextFilled();
            }
        });

        checkAllEditTextFilled();
    }

    public void checkAllEditTextFilled() {
        if(!TextUtils.isEmpty(mEdtEmail.getText())
                && !TextUtils.isEmpty(mEdtPassword.getText())
                && !TextUtils.isEmpty(mEdtConfirmPass.getText())) {
            mBtnCreateAcc.setEnabled(true);
        } else {
            mBtnCreateAcc.setEnabled(false);
        }
    }

    public void goToSplash() {
        Intent intent = new Intent(this, SplashScreenActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    public void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    public boolean isValid() {
        if(mEdtConfirmPass.getText().toString().equals(mEdtPassword.getText().toString())) {
            return true;
        }
        return false;
    }

    public boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(mEdtConfirmPass.getText().toString())) {
            mEdtConfirmPass.setError("Required");
            result = false;
        } else {
            mEdtConfirmPass.setError(null);
        }

        if (TextUtils.isEmpty(mEdtPassword.getText().toString())) {
            mEdtPassword.setError("Required");
            result = false;
        } else {
            mEdtPassword.setError(null);
        }

        if (TextUtils.isEmpty(mEdtEmail.getText().toString())) {
            mEdtEmail.setError("Required");
            result = false;
        } else {
            mEdtEmail.setError(null);
        }

        return result;
    }
}
