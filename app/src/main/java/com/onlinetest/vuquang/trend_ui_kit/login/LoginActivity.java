package com.onlinetest.vuquang.trend_ui_kit.login;

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
import com.onlinetest.vuquang.trend_ui_kit.main.MainActivity;
import com.onlinetest.vuquang.trend_ui_kit.splash.SplashScreenActivity;

/**
 * Created by VuQuang on 7/14/2018.
 */

public class LoginActivity extends BaseActivity implements LoginMvpView {
    private static final String TAG = "LoginActivity";

    private View mBtnNaviBack;
    EditText mEdtEmail,mEdtPassword;
    Button mBtnLogin;

    private LoginMvpPresenter<LoginMvpView> presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter<>();

        mBtnNaviBack = findViewById(R.id.imv_navi_back);

        mBtnNaviBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNaviBackClicked();
            }
        });

        mEdtPassword = (EditText) findViewById(R.id.edt_password);
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

        mEdtEmail = (EditText) findViewById(R.id.edt_email);
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

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateForm()) {
                    return;
                }

                String email = String.valueOf(mEdtEmail.getText());
                String pass = String.valueOf(mEdtPassword.getText());

                presenter.onSignInClicked(email, pass);
            }
        });

        checkAllEdtFilled();
        presenter.onAttach(LoginActivity.this);

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

    @Override
    public void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void goToSplash() {
        Intent i = new Intent(this, SplashScreenActivity.class);
        startActivity(i);
        finish();
    }
}
