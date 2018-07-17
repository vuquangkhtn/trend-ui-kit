package com.onlinetest.vuquang.trend_ui_kit.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseActivity;
import com.onlinetest.vuquang.trend_ui_kit.comment.CommentFragment;
import com.onlinetest.vuquang.trend_ui_kit.explore.ExploreFragment;
import com.onlinetest.vuquang.trend_ui_kit.order.OrderFragment;
import com.onlinetest.vuquang.trend_ui_kit.search.SearchFragment;
import com.onlinetest.vuquang.trend_ui_kit.shop.ShopFragment;
import com.onlinetest.vuquang.trend_ui_kit.wishlist.WishlistFragment;

/**
 * Created by VuQuang on 7/14/2018.
 */

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private DrawerLayout mDrawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    SearchView search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        mDrawer = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
        // Setup drawer view
        setDefaultFragment();
        setupDrawerContent(navigationView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                mDrawer.openDrawer(GravityCompat.START);
                if(search != null) {
                    search.setQuery("", false);
                    search.clearFocus();
                    search.onActionViewCollapsed();
                }
                return true;
            }
            case R.id.app_bar_search: {
                Log.d(TAG,"test");
                changeFragment(new SearchFragment(), item);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.action_main_menu, menu);
        toolbar.setTitle(R.string.explore_name);

        search = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        search.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"test search");
                changeFragment(new SearchFragment(),navigationView.getMenu().findItem(R.id.nav_search));
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void setDefaultFragment() {
        toolbar.setTitle(R.string.explore_name);
        navigationView.setCheckedItem(R.id.nav_explore);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, new ExploreFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_shop:
                fragmentClass = ShopFragment.class;
                break;
            case R.id.nav_orders:
                fragmentClass = OrderFragment.class;
                break;
            case R.id.nav_wishlist:
                fragmentClass = WishlistFragment.class;
                break;
            case R.id.nav_explore:
                fragmentClass = ExploreFragment.class;
                break;
            case R.id.nav_comment:
                fragmentClass = CommentFragment.class;
                break;
            case R.id.nav_search:
                fragmentClass = SearchFragment.class;
                break;
            default:
                fragmentClass = ExploreFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        changeFragment(fragment, menuItem);
    }

    private void changeFragment(Fragment fragment, MenuItem menuItem) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        navigationView.setCheckedItem(menuItem.getItemId());
        toolbar.setTitle(menuItem.getTitle());
        // Close the navigation mDrawer
        mDrawer.closeDrawers();
    }
}
