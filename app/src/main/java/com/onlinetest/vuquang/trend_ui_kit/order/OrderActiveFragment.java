package com.onlinetest.vuquang.trend_ui_kit.order;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseFragment;
import com.onlinetest.vuquang.trend_ui_kit.order.adapter.OrderActiveAdapter;
import com.onlinetest.vuquang.trend_ui_kit.order.model.OrderItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderActiveFragment extends BaseFragment {
    public static final String TAG = "FeedFragment";
    @BindView(R.id.rv_orders)
    RecyclerView rvFeedList;
    private OrderActiveAdapter mAdapter;
    private List dataList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_order_active, null);
        ButterKnife.bind(this, view);
        rvFeedList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new OrderActiveAdapter(getContext());
        rvFeedList.setAdapter(mAdapter);
        return view;
    }

    @Override
    protected void setUp(View view) {

        dataList = new ArrayList<OrderItem>();
        for (int i = 0; i < 5; i++) {
            dataList.add(new OrderItem());
        }
        mAdapter.setData(dataList);

    }
}
