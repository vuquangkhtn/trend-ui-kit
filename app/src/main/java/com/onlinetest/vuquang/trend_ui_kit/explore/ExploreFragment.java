package com.onlinetest.vuquang.trend_ui_kit.explore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseFragment;
import com.onlinetest.vuquang.trend_ui_kit.view.NoSwipeViewPager;

/**
 * Created by VuQuang on 7/16/2018.
 */

public class ExploreFragment extends BaseFragment{
    public static final String TAG = "ExploreFragment";
    NoSwipeViewPager mViewPager;
    ExploreTabAdapter mTabAdapter;
    TabLayout mTabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_explore, null);
        mViewPager = (NoSwipeViewPager) view.findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager.setOffscreenPageLimit(5);
        return view;

    }

    @Override
    protected void setUp(View view) {
        mTabAdapter = new ExploreTabAdapter(getFragmentManager(), this.getContext());
        mViewPager.setAdapter(mTabAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(mTabAdapter.getCustomTabView(i));
        }

        mTabAdapter.notifyDataSetChanged();
    }
}
