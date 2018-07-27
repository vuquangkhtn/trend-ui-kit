package com.onlinetest.vuquang.trend_ui_kit.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseDialog;
import com.onlinetest.vuquang.trend_ui_kit.dialog.adapter.CartAdapter;
import com.onlinetest.vuquang.trend_ui_kit.dialog.model.CartItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/18/2018.
 */

public class CartDialog extends BaseDialog {
    public static final String TAG = "CartDialog";

    @BindView(R.id.toolbar) protected Toolbar toolbar;
    @BindView(R.id.rv_cart_list) protected RecyclerView rvFeedList;

    private CartAdapter mAdapter;
    private List dataList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.dialog_cart, null);
        ButterKnife.bind(this, view);

        toolbar.setTitle(R.string.cart);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog(TAG);
            }
        });

        rvFeedList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new CartAdapter(getContext());
        rvFeedList.setAdapter(mAdapter);
        mAdapter.setCartItemListener(new CartAdapter.CartItemListener() {

            @Override
            public void onCartItemDecreaseClicked(CartItem item) {
                showMessage("cart item decrease clicked");
            }

            @Override
            public void onCartItemIncreaseClicked(CartItem item) {
                showMessage("cart item increase clicked");

            }
        });
        return view;
    }

    @Override
    protected void setUp(View view) {

        dataList = new ArrayList<CartItem>();
        for (int i = 0; i < 5; i++) {
            dataList.add(new CartItem());
        }
        mAdapter.setData(dataList);

    }
}
