package com.onlinetest.vuquang.trend_ui_kit.explore;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;


/**
 * Created by CPU10584-local on 17-Jan-18.
 */

public class ExploreTabAdapter extends FragmentPagerAdapter {
    private Context mContext;

    private static final int TRENDS_FRAGMENT_POSITION = 0;
    private static final int FEED_FRAGMENT_POSITION = 1;

    private int tabTitles[] = { R.string.trends, R.string.feed};

    public ExploreTabAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TRENDS_FRAGMENT_POSITION:
                return new TrendFragment();
            case FEED_FRAGMENT_POSITION:
                return new FeedFragment();
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