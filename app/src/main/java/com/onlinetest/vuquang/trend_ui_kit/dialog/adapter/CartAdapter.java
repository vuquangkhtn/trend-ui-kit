package com.onlinetest.vuquang.trend_ui_kit.dialog.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.dialog.model.CartItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/27/2018.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    private List<CartItem> cartList;
    private Context mContext;
    private CartItemListener cartItemListener;

    public CartAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<CartItem> listData) {
        this.cartList = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CartHolder(LayoutInflater.from(mContext).inflate(R.layout.item_cart, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CartHolder holder, int position) {
        final CartItem item = cartList.get(position);
        holder.imbDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItemListener.onCartItemDecreaseClicked(item);
            }
        });

        holder.imbIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItemListener.onCartItemIncreaseClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (cartList != null) {
            return cartList.size();
        }
        return 0;
    }

    public class CartHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imv_picture) protected ImageView imvPicture;
        @BindView(R.id.tv_name) protected TextView tvName;
        @BindView(R.id.tv_owner_company) protected TextView tvOwnerCompany;
        @BindView(R.id.tv_price) protected TextView tvPrice;
        @BindView(R.id.imb_decrease) protected ImageButton imbDecrease;
        @BindView(R.id.imb_increase) protected ImageButton imbIncrease;
        @BindView(R.id.tv_product_count) protected TextView tvProductCount;

        public CartHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setCartItemListener(CartItemListener cartItemListener) {
        this.cartItemListener = cartItemListener;
    }

    public interface CartItemListener {
        void onCartItemDecreaseClicked(CartItem item);
        void onCartItemIncreaseClicked(CartItem item);

    }
}