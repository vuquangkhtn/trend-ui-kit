package com.onlinetest.vuquang.trend_ui_kit.order;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseFragment;
import com.onlinetest.vuquang.trend_ui_kit.main.MainActivity;
import com.onlinetest.vuquang.trend_ui_kit.view.NoSwipeViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/16/2018.
 */

public class OrderFragment extends BaseFragment {
    public static final String TAG = "ExploreFragment";
    @BindView(R.id.view_pager)
    protected NoSwipeViewPager mViewPager;
    @BindView(R.id.tab_layout)
    protected TabLayout mTabLayout;
    protected OrderTabAdapter mTabAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_order, null);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    protected void setUp(View view) {
        setupToolbar();
        mTabAdapter = new OrderTabAdapter(getFragmentManager(), this.getContext());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(mTabAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(mTabAdapter.getCustomTabView(i));
        }

        mTabAdapter.notifyDataSetChanged();
    }

    private void setupToolbar() {
        if(getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();

            activity.setVisibleForAppBarIcon(false,R.id.app_bar_search);
            activity.setVisibleForAppBarIcon(false, R.id.app_bar_cart);
            activity.setVisibleForAppBarIcon(false, R.id.app_bar_filter);
        }
    }
}
