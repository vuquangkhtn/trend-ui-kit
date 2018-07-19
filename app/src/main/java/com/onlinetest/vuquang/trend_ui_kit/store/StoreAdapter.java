package com.onlinetest.vuquang.trend_ui_kit.store;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/19/2018.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreItemHolder> {
    private List<StoreItem> storeItemList;
    private Context mContext;

    public StoreAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<StoreItem> listData) {
        this.storeItemList = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StoreItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StoreItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_product_with_price, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final StoreItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (storeItemList != null) {
            return storeItemList.size();
        }
        return 0;
    }

    public class StoreItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imv_picture) protected ImageView imvProfile;
        @BindView(R.id.tv_name) protected TextView tvName;
        @BindView(R.id.tv_price) protected TextView tvPrice;

        public StoreItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
