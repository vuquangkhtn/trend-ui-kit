package com.onlinetest.vuquang.trend_ui_kit;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.onlinetest.vuquang.trend_ui_kit.login.LoginActivity;
import com.onlinetest.vuquang.trend_ui_kit.main.MainActivity;
import com.onlinetest.vuquang.trend_ui_kit.signup.SignUpActivity;
import com.onlinetest.vuquang.trend_ui_kit.splash.SplashScreenActivity;

import org.junit.After;
import org.junit.Before;
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
 * Created by VuQuang on 8/14/2018.
 */

/**
 * Test UI in {@link SplashScreenActivity}
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SignupActivityTest {
    private final String STRING_USERNAME_INVALID = "testgmai@";
    private final String STRING_USERNAME_VALID = "test@gmail.com";
    private final String STRING_PASSWORD_VALID = "tests";
    private final String STRING_PASSWORD_INVALID = "test s";

    @Rule
    public ActivityTestRule<SignUpActivity> mActivityRule = new ActivityTestRule<>(
            SignUpActivity.class);


    @Before
    public void initIntent() {
        init();
    }

    @Test
    public void edtUsername_empty() {
        onView(withId(R.id.edt_email))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.edt_confirm_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());

        onView(withId(R.id.btn_create_account)).check(matches(not(isEnabled())));
    }

    @Test
    public void edtPassword_empty() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_confirm_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.btn_create_account)).check(matches(not(isEnabled())));

    }

    @Test
    public void edtConfirmPassword_empty() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_confirm_password))
                .perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.btn_create_account)).check(matches(not(isEnabled())));
    }

    @Test
    public void allEdt_empty() {
        onView(withId(R.id.edt_email))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.edt_confirm_password))
                .perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.btn_create_account)).check(matches(not(isEnabled())));

    }


    @Test
    public void edtUsername_InputInvalid() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_INVALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_confirm_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());

        onView(withId(R.id.btn_create_account)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.signup_invalid)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void edtPassword_InputInvalid() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_INVALID), closeSoftKeyboard());
        onView(withId(R.id.edt_confirm_password))
                .perform(typeText(STRING_PASSWORD_INVALID), closeSoftKeyboard());

        onView(withId(R.id.btn_create_account)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.signup_invalid)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void allEdt_InputInvalid() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_INVALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_INVALID), closeSoftKeyboard());
        onView(withId(R.id.edt_confirm_password))
                .perform(typeText(STRING_PASSWORD_INVALID), closeSoftKeyboard());

        onView(withId(R.id.btn_create_account)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.signup_invalid)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void allEdt_InputValid() {
        onView(withId(R.id.edt_email))
                .perform(typeText(STRING_USERNAME_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());
        onView(withId(R.id.edt_confirm_password))
                .perform(typeText(STRING_PASSWORD_VALID), closeSoftKeyboard());

        onView(withId(R.id.btn_create_account)).perform(click());

        intended(hasComponent(LoginActivity.class.getName()));
    }

    @After
    public void destroyIntent() {
        release();
    }
}

