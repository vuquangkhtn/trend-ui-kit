package com.onlinetest.vuquang.trend_ui_kit.store;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/19/2018.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreItemHolder> {
    private final int SALE_TYPE = 0;
    private final int NORMAL_TYPE = 1;

    private List<StoreItem> storeItemList;
    private Context mContext;
    private StoreItemListener storeItemListener;

    public StoreAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<StoreItem> listData) {
        this.storeItemList = listData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        StoreItem item = storeItemList.get(position);
        if(item.isSale) {
            return SALE_TYPE;
        } else {
            return NORMAL_TYPE;
        }
    }

    @NonNull
    @Override
    public StoreItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StoreItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_product_with_price, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final StoreItemHolder holder, int position) {
        final StoreItem storeItem = storeItemList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeItemListener.onStoreItemClicked(storeItem);
            }
        });
        switch (holder.getItemViewType()) {
            case SALE_TYPE: {
                holder.imvSale.setVisibility(View.VISIBLE);
                holder.containerSaleText.setVisibility(View.VISIBLE);
                holder.tvPrice.setVisibility(View.GONE);
                break;
            }
            case NORMAL_TYPE: {
                holder.imvSale.setVisibility(View.GONE);
                holder.containerSaleText.setVisibility(View.GONE);
                holder.tvPrice.setVisibility(View.VISIBLE);
                break;
            }
        }
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
        @BindView(R.id.imv_sale) protected ImageView imvSale;
        @BindView(R.id.tv_price_sale) protected TextView tvSalePrice;
        @BindView(R.id.tv_old_price) protected TextView tvOldPrice;
        @BindView(R.id.container_price_sale) protected LinearLayout containerSaleText;

        public StoreItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setStoreItemListener(StoreItemListener storeItemListener) {
        this.storeItemListener = storeItemListener;
    }

    public interface StoreItemListener {
        void onStoreItemClicked(StoreItem storeItem);
    }

}
