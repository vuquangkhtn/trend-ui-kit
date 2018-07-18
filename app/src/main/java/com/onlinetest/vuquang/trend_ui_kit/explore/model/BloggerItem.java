package com.onlinetest.vuquang.trend_ui_kit.explore.model;

import android.annotation.SuppressLint;
import android.os.Parcel;

/**
 * Created by VuQuang on 7/17/2018.
 */

@SuppressLint("ParcelCreator")
public class BloggerItem implements FeedItem {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
