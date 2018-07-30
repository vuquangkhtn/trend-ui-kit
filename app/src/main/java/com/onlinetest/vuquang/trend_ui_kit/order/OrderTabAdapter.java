package com.onlinetest.vuquang.trend_ui_kit.order;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;

/**
 * Created by VuQuang on 7/30/2018.
 */

public class OrderTabAdapter extends FragmentStatePagerAdapter {
    private Context mContext;

    private static final int ACTIVE_FRAGMENT_POSITION = 0;
    private static final int HISTORY_FRAGMENT_POSITION = 1;

    private int tabTitles[] = { R.string.active, R.string.history};

    public OrderTabAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case ACTIVE_FRAGMENT_POSITION:
                return new OrderActiveFragment();
            case HISTORY_FRAGMENT_POSITION:
                return new OrderHistoryFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(tabTitles[position]);
    }

    public View getCustomTabView(int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_tab_item, null);
        TextView tvName = (TextView) v.findViewById(R.id.tv_tab_name);
        tvName.setText(tabTitles[position]);
        return v;
    }
}