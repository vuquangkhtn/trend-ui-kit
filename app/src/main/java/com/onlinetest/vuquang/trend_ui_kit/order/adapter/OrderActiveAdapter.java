package com.onlinetest.vuquang.trend_ui_kit.order.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.explore.adapter.FeedAdapter;
import com.onlinetest.vuquang.trend_ui_kit.order.model.OrderItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 8/6/2018.
 */

public class OrderActiveAdapter extends RecyclerView.Adapter<OrderActiveAdapter.OrderHolder> {
    private List<OrderItem> orderList;
    private Context mContext;

    public OrderActiveAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<OrderItem> listData) {
        this.orderList = listData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return orderList.get(position).getType();
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == OrderItem.PROCESS_TYPE) {
            return new ProcessHolder(LayoutInflater.from(mContext).inflate(R.layout.item_order_process, parent, false));
        } else if(viewType == OrderItem.DELIVERED_TYPE) {
            return new DeliveredHolder(LayoutInflater.from(mContext).inflate(R.layout.item_order_delivered, parent, false));
        } else {
            return new OnDeliveryHolder(LayoutInflater.from(mContext).inflate(R.layout.item_order_on_delivery, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (orderList != null) {
            return orderList.size();
        }
        return 0;
    }

    public class OrderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_order_no) protected TextView tvOrderNo;
        @BindView(R.id.tv_state_order) protected TextView tvState;
        @BindView(R.id.tv_order_time) protected TextView tvOrderTime;


        public OrderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public class ProcessHolder extends OrderHolder {
        @BindView(R.id.tv_estimated_time) protected TextView tvEstimatedTime;

        public ProcessHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public class DeliveredHolder extends OrderHolder {
        @BindView(R.id.tv_track) protected TextView tvTrack;

        public DeliveredHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public class OnDeliveryHolder extends OrderHolder {
        @BindView(R.id.tv_track) protected TextView tvTrack;
        @BindView(R.id.tv_estimated_time) protected TextView tvEstimatedTime;

        public OnDeliveryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
