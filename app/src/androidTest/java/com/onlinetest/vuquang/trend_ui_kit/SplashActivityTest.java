package com.onlinetest.vuquang.trend_ui_kit;

/**
 * Created by VuQuang on 8/14/2018.
 */

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.onlinetest.vuquang.trend_ui_kit.login.LoginActivity;
import com.onlinetest.vuquang.trend_ui_kit.signup.SignUpActivity;
import com.onlinetest.vuquang.trend_ui_kit.splash.SplashScreenActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.init;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.release;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Test UI in {@link SplashScreenActivity}
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SplashActivityTest {

    @Rule
    public ActivityTestRule<SplashScreenActivity> mActivityRule = new ActivityTestRule<>(
            SplashScreenActivity.class);

    @Before
    public void initIntent() {
        init();
    }

    /*Test onBtnLoginClicked*/
    @Test
    public void clickLoginBtn() {
        onView(withId(R.id.btn_login))
                .perform(click());

        intended(hasComponent(LoginActivity.class.getName()));
    }

    @Test
    public void clickCreateAccBtn() {
        onView(withId(R.id.btn_create_account))
                .perform(click());

        intended(hasComponent(SignUpActivity.class.getName()));
    }

    @After
    public void releaseIntent() {
        release();
    }
}

