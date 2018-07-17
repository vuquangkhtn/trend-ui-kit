package com.onlinetest.vuquang.trend_ui_kit.explore.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.explore.model.BloggerItem;
import com.onlinetest.vuquang.trend_ui_kit.explore.model.FeedItem;
import com.onlinetest.vuquang.trend_ui_kit.explore.model.ShopItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/17/2018.
 */

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int BLOGGER_TYPE = 0;
    private final int SHOP_TYPE = 1;

    private List<FeedItem> feedList;
    private Context mContext;

    public FeedAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<FeedItem> listData) {
        this.feedList = listData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(feedList.get(position) instanceof BloggerItem) {
            return BLOGGER_TYPE;
        }
        return SHOP_TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == SHOP_TYPE) {
            return new ShopHolder(LayoutInflater.from(mContext).inflate(R.layout.item_explore_shop, parent, false));
        }
        return new BloggerHolder(LayoutInflater.from(mContext).inflate(R.layout.item_explore_blogger, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case SHOP_TYPE: {
                ShopHolder shopHolder = (ShopHolder) holder;
                ShopItem item = (ShopItem) feedList.get(position);
                return;
            }
            case BLOGGER_TYPE: {
                BloggerHolder bloggerHolder = (BloggerHolder) holder;
                BloggerItem item = (BloggerItem) feedList.get(position);
                return;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (feedList != null) {
            return feedList.size();
        }
        return 0;
    }

    public class ShopHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_profile) protected ImageView imvProfile;
        @BindView(R.id.tv_name) protected TextView tvName;
        @BindView(R.id.tv_description) protected TextView tvDescription;
        @BindView(R.id.rv_products) protected RecyclerView rvProducts;

        public ShopHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }

    public class BloggerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_profile) protected ImageView imvProfile;
        @BindView(R.id.imv_banner) protected ImageView imvBanner;
        @BindView(R.id.tv_name) protected TextView tvName;
        @BindView(R.id.tv_time) protected TextView tvTime;
        @BindView(R.id.tv_view_count) protected TextView tvViewCount;
        @BindView(R.id.tv_comment_count) protected TextView tvCommentCount;

        public BloggerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
