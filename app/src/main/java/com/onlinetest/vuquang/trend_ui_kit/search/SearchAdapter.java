package com.onlinetest.vuquang.trend_ui_kit.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/17/2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchItemHolder> {
    private final int BLOGGER_TYPE = 0;
    private final int SHOP_TYPE = 1;

    private List<SearchItem> searchItemList;
    private Context mContext;

    public SearchAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<SearchItem> listData) {
        this.searchItemList = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchItemHolder holder, int position) {
        final Button btnFollow = holder.btnFollow;
        final Button btnUnfollow = holder.btnUnfollow;
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFollow.setVisibility(View.GONE);
                btnUnfollow.setVisibility(View.VISIBLE);
            }
        });

        btnUnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFollow.setVisibility(View.VISIBLE);
                btnUnfollow.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (searchItemList != null) {
            return searchItemList.size();
        }
        return 0;
    }

    public class SearchItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imv_profile) protected ImageView imvProfile;
        @BindView(R.id.tv_name) protected TextView tvName;
        @BindView(R.id.tv_followers_count) protected TextView tvFollowerCount;
        @BindView(R.id.btn_follow) protected Button btnFollow;
        @BindView(R.id.btn_unfollow) protected Button btnUnfollow;


        public SearchItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}