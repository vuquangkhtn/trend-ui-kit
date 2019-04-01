package com.onlinetest.vuquang.trend_ui_kit.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseDialog;
import com.onlinetest.vuquang.trend_ui_kit.explore.adapter.FeedAdapter;
import com.onlinetest.vuquang.trend_ui_kit.explore.model.BloggerItem;
import com.onlinetest.vuquang.trend_ui_kit.explore.model.ShopItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by VuQuang on 7/19/2018.
 */

public class ProfileDialog extends BaseDialog {
    private static final String TAG = "ProfileDialog";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.rv_profile_item) RecyclerView rvFeedList;
        @BindView(R.id.imv_profile) ImageView imvProfile;
        @BindView(R.id.tv_bio) TextView tvBio;
        @BindView(R.id.tv_followers_count) TextView tvFollowerCount;
        @BindView(R.id.btn_following) Button btnFollowing;
        @BindView(R.id.btn_follow) Button btnFollow;
        private FeedAdapter feedAdapter;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = View.inflate(getActivity(), R.layout.dialog_profile, null);
            ButterKnife.bind(this, view);

            toolbar.setTitle("Profile Test");
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismissDialog(TAG);
                }
            });

            feedAdapter = new FeedAdapter(getContext());
            rvFeedList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            rvFeedList.setAdapter(feedAdapter);

            feedAdapter.setExploreItemListener(new FeedAdapter.ExploreItemListener() {
                @Override
                public void onBlogItemClicked(BloggerItem item) {
                    (new ArticleDialog()).show(getChildFragmentManager(), TAG);
                }

                @Override
                public void onShopItemClicked(ShopItem item) {

                }
            });

        return view;
    }

    @Override
    protected void setUp(View view) {
        List data = new ArrayList();
        for (int i = 0; i < 5; i++) {
            data.add(new BloggerItem());
        }
        feedAdapter.setData(data);
    }

    @OnClick(R.id.btn_follow)
    void onFollowClicked() {
        btnFollow.setVisibility(View.GONE);
        btnFollowing.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btn_following)
    void onFollowingClicked() {
        btnFollow.setVisibility(View.VISIBLE);
        btnFollowing.setVisibility(View.GONE);
    }
}
