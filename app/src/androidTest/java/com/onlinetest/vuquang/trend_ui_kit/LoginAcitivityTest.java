package com.onlinetest.vuquang.trend_ui_kit;

/**
 * Created by VuQuang on 8/14/2018.
 */


import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.onlinetest.vuquang.trend_ui_kit.login.LoginActivity;
import com.onlinetest.vuquang.trend_ui_kit.main.MainActivity;
import com.onlinetest.vuquang.trend_ui_kit.signup.SignUpActivity;
import com.onlinetest.vuquang.trend_ui_kit.splash.SplashScreenActivity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.init;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.release;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;

/**
 * Test UI in {@link SplashScreenActivity}
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginAcitivityTest {
    private final String STRING_USERNAME_INVALID = "testgmai@";
    private final String STRING_USERNAME_VALID = "test@gmail.com";
    private final String STRING_PASSWORD_VALID = "tests";
    private final String STRING_PASSWORD_INVALID = "test s";

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);


    @Before
    public void initIntent() {
        init();
    }

    @Test
    public void loginWithEmptyEmail() {
        onView(withId(R.id.edt_email))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).check(matches(not(isEnabled())));

    }

    @Test
    public void loginWithEmptyPassword() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).check(matches(not(isEnabled())));

    }

    @Test
    public void loginWithAllEmptyEdtText() {
        onView(withId(R.id.edt_email))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).check(matches(not(isEnabled())));

    }


    @Test
    public void loginWithInvalidEmail() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_INVALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.login_error)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void loginWithInvalidPassword() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_INVALID), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.login_error)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void loginWithAllInvalidEdtText() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_INVALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_INVALID), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.login_error)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void loginWithAllValidEdtText() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

        intended(hasComponent(MainActivity.class.getName()));
    }

    @After
    public void releaseIntent() {
        release();
    }
}
