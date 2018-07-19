package com.onlinetest.vuquang.trend_ui_kit.store;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseFragment;
import com.onlinetest.vuquang.trend_ui_kit.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/16/2018.
 */

public class StoreFragment extends BaseFragment {
    public static final String TAG = "ExploreFragment";
    @BindView(R.id.tab_layout) TabLayout mTabLayout;
    @BindView(R.id.rv_product_list) RecyclerView rvItemList;
    StoreAdapter mAdapter;

    String[] tabList = new String[] {"Clothing", "Jeans", "Shoes", "Bags", "Watches", "Accessories"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_store, null);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    protected void setUp(View view) {
        setupToolbar();
        for (int i = 0; i < tabList.length; i++) {
            TabLayout.Tab tab = mTabLayout.newTab().setText(tabList[i]);
            mTabLayout.addTab(tab);
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateData();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        rvItemList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mAdapter = new StoreAdapter(getContext());
        rvItemList.setAdapter(mAdapter);
        updateData();
    }

    private void setupToolbar() {
        if(getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();

            activity.setVisibleForAppBarIcon(false,R.id.app_bar_search);
            activity.setVisibleForAppBarIcon(true, R.id.app_bar_cart);
            activity.setVisibleForAppBarIcon(true, R.id.app_bar_filter);
        }
    }

    private void updateData() {
        List items = new ArrayList();
        for (int i = 0; i < 5; i++) {
            items.add(new StoreItem());
        }
        mAdapter.setData(items);
    }
}
