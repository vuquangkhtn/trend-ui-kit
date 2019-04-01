package com.onlinetest.vuquang.trend_ui_kit.explore;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseFragment;
import com.onlinetest.vuquang.trend_ui_kit.data.model.Blogger;
import com.onlinetest.vuquang.trend_ui_kit.dialog.ArticleDialog;
import com.onlinetest.vuquang.trend_ui_kit.explore.adapter.FeedAdapter;
import com.onlinetest.vuquang.trend_ui_kit.explore.model.BloggerItem;
import com.onlinetest.vuquang.trend_ui_kit.explore.model.FeedItem;
import com.onlinetest.vuquang.trend_ui_kit.explore.model.ShopItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/16/2018.
 */

public class TrendFragment extends BaseFragment {
    public static final String TAG = "TrendFragment";
    @BindView(R.id.rv_trends) RecyclerView rvFeedList;
    private FeedAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_trends, null);
        ButterKnife.bind(this, view);
        rvFeedList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new FeedAdapter(getContext());
        rvFeedList.setAdapter(mAdapter);
        mAdapter.setExploreItemListener(new FeedAdapter.ExploreItemListener() {
            @Override
            public void onBlogItemClicked(BloggerItem item) {
                (new ArticleDialog()).show(getChildFragmentManager(), TAG);
            }

            @Override
            public void onShopItemClicked(ShopItem item) {
//                (new ArticleDialog()).show(getChildFragmentManager(), TAG);
            }
        });
        return view;
    }

    @Override
    protected void setUp(View view) {

        List dataList = new ArrayList<FeedItem>();
        for (int i = 0; i < 5; i++) {
            dataList.add(new BloggerItem());
        }
        mAdapter.setData(dataList);

    }
}
