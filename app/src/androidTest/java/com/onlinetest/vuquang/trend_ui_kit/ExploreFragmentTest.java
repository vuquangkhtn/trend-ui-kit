package com.onlinetest.vuquang.trend_ui_kit;

/**
 * Created by VuQuang on 8/15/2018.
 */


import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.custom.CustomScrollAction;
import com.onlinetest.vuquang.trend_ui_kit.explore.ExploreFragment;
import com.onlinetest.vuquang.trend_ui_kit.login.LoginActivity;
import com.onlinetest.vuquang.trend_ui_kit.main.MainActivity;
import com.onlinetest.vuquang.trend_ui_kit.utils.ToolbarUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.init;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.release;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Test UI in {@link ExploreFragment} which is contained by {@link MainActivity}
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExploreFragmentTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void init(){
        FragmentTransaction transaction = mActivityRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
        Fragment fragment = new ExploreFragment();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Test
    public void clickTrendItem() {
        onView(withId(R.id.rv_trends))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_article_headline)).check(matches(isDisplayed()));
    }

    @Test
    public void clickFeedItem() {
        onView(withId(R.id.view_pager)).perform(swipeLeft());
        onView(withId(R.id.rv_feeds))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_article_headline)).check(matches(isDisplayed()));
    }

    @Test
    public void changeTitleTextInToolbar() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        CharSequence title = InstrumentationRegistry.getTargetContext()
                .getString(R.string.explore_name);
        ToolbarUtils.matchToolbarTitle(title).check(matches(isDisplayed()));
    }

    @Test
    public void clickSearchItemInToolbar() {
        onView(withId(R.id.app_bar_search)).perform(click());
        onView(withId(R.id.rv_search_items)).check(matches(isDisplayed()));
    }


}
