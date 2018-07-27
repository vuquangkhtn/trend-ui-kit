package com.onlinetest.vuquang.trend_ui_kit.dialog.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by VuQuang on 7/27/2018.
 */

public class CartItem implements Parcelable {
    public CartItem() {}

    protected CartItem(Parcel in) {
    }

    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel in) {
            return new CartItem(in);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
