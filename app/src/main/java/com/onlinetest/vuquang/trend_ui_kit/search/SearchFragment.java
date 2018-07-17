package com.onlinetest.vuquang.trend_ui_kit.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/16/2018.
 */

public class SearchFragment extends BaseFragment {
    TabLayout mTabLayout;
    RecyclerView rvItemList;
    SearchAdapter mAdapter;

    String[] tabList = new String[] {"Items", "Shops", "Bloggers", "Tags"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_search, null);
        mTabLayout = view.findViewById(R.id.tab_layout);
        rvItemList = view.findViewById(R.id.rv_search_items);
        return view;

    }

    @Override
    protected void setUp(View view) {
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
        mAdapter = new SearchAdapter(getContext());
        rvItemList.setAdapter(mAdapter);
        updateData();
    }

    private void updateData() {
        List items = new ArrayList();
        for (int i = 0; i < 5; i++) {
            items.add(new SearchItem());
        }
        mAdapter.setData(items);
    }
}
