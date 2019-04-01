package com.onlinetest.vuquang.trend_ui_kit;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.view.Gravity;

import com.onlinetest.vuquang.trend_ui_kit.custom.ElapsedTimeIdlingResource;
import com.onlinetest.vuquang.trend_ui_kit.explore.ExploreFragment;
import com.onlinetest.vuquang.trend_ui_kit.main.MainActivity;
import com.onlinetest.vuquang.trend_ui_kit.search.SearchFragment;
import com.onlinetest.vuquang.trend_ui_kit.utils.DelayUtils;
import com.onlinetest.vuquang.trend_ui_kit.utils.ToolbarUtils;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.onlinetest.vuquang.trend_ui_kit.utils.RecyclerViewUtils.withRecyclerView;
import static org.hamcrest.core.IsNot.not;

/**
 * Test UI in {@link SearchFragment}
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SearchFragmentTest {
    private int TEST_ITEM_POS = 0;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void init(){
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_search));
    }

    @Test
    public void changeTitleTextInToolbar() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        CharSequence title = InstrumentationRegistry.getTargetContext()
                .getString(R.string.search);
        ToolbarUtils.matchToolbarTitle(title).check(matches(isDisplayed()));
    }

    @Test
    public void clickFollowAndUnfollowBtn() {
        ViewInteraction btnFollow = onView(withRecyclerView(R.id.rv_search_items)
                .atPositionOnView(TEST_ITEM_POS, R.id.btn_follow));

        btnFollow.check(matches(isDisplayed()));
        DelayUtils.delay(10);//fix for misunderstand click is long click
        btnFollow.perform(click());
        btnFollow.check(matches(not(isDisplayed())));

        ViewInteraction btnUnfollow = onView(withRecyclerView(R.id.rv_search_items)
                .atPositionOnView(TEST_ITEM_POS, R.id.btn_unfollow));
        btnUnfollow.check(matches(isDisplayed()));

        btnUnfollow.perform(click());
        btnUnfollow.check(matches(not(isDisplayed())));
        btnFollow.check(matches(isDisplayed()));
    }

    @Test
    public void clickSearchItem() {
        onView(withId(R.id.rv_search_items))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.rv_profile_item)).check(matches(isDisplayed()));
    }
}
