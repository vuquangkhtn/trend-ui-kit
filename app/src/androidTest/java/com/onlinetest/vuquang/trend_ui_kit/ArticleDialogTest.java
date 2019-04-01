package com.onlinetest.vuquang.trend_ui_kit;

/**
 * Created by VuQuang on 8/16/2018.
 */

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.test.suitebuilder.annotation.LargeTest;

import com.onlinetest.vuquang.trend_ui_kit.custom.CustomScrollAction;
import com.onlinetest.vuquang.trend_ui_kit.dialog.ArticleDialog;
import com.onlinetest.vuquang.trend_ui_kit.explore.ExploreFragment;
import com.onlinetest.vuquang.trend_ui_kit.main.MainActivity;
import com.onlinetest.vuquang.trend_ui_kit.utils.DelayUtils;
import com.onlinetest.vuquang.trend_ui_kit.utils.ToolbarUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.onlinetest.vuquang.trend_ui_kit.utils.RecyclerViewUtils.withRecyclerView;
import static com.onlinetest.vuquang.trend_ui_kit.utils.ToolbarUtils.withToolbarTitle;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Test UI in {@link ArticleDialog} which is shown by items in recyclerview in {@link ExploreFragment}
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ArticleDialogTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void init(){
//        FragmentTransaction transaction = mActivityRule.getActivity()
//                .getSupportFragmentManager().beginTransaction();
//        Fragment fragment = new ExploreFragment();
//        transaction.replace(R.id.fragment_container, fragment);
//        transaction.commit();
        onView(withId(R.id.rv_trends))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test
    public void changeTitleTextInToolbar() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        CharSequence title = InstrumentationRegistry.getTargetContext()
                .getString(R.string.article);
        onView(isAssignableFrom(Toolbar.class))
                .check(matches(withToolbarTitle(is(title))));
//        ToolbarUtils.matchToolbarTitle(title).check(matches(isDisplayed()));
    }

    /*Wrong
    * can't click imb*/
    @Test
    public void clickLikeAndUnlikeBtn() {
        onView(withId(R.id.dialog_article)).perform(swipeUp());
        DelayUtils.delay(500);
        onView(withId(R.id.dialog_article)).perform(swipeUp());
//        onView(withId(R.id.imb_like)).perform(scrollTo(),click());

//        btnLike.check(matches(isDisplayed()));

        onView(withId(R.id.imb_like)).perform(click());
        onView(withId(R.id.imb_like)).check(matches(not(isDisplayed())));
        onView(withId(R.id.imb_unlike)).check(matches(isDisplayed()));

        onView(withId(R.id.imb_unlike)).perform(click());
        onView(withId(R.id.imb_unlike)).check(matches(not(isDisplayed())));
        onView(withId(R.id.imb_like)).check(matches(isDisplayed()));
    }

    /*can't click imb*/
    @Test
    public void clickCommentBtn() {
//        onView(withId(R.id.expandedImage)).perform(swipeUp());
        onView(withId(R.id.dialog_article)).perform(swipeUp());
        DelayUtils.delay(500);
        onView(withId(R.id.dialog_article)).perform(swipeUp());
//        onView(withId(R.id.imb_comment)).perform(CustomScrollAction.nestedScrollTo(),click());
        onView(withId(R.id.imb_comment)).perform(click());

        onView(withId(R.id.btn_send)).check(matches(isDisplayed()));
    }
}
