package com.onlinetest.vuquang.trend_ui_kit.order.model;

import java.util.Random;

/**
 * Created by VuQuang on 8/6/2018.
 */

public class OrderItem {
    public static final int PROCESS_TYPE = 0;
    public static final int DELIVERED_TYPE = 1;
    public static final int ON_DELIVERY_TYPE = 2;

    private int type;

    public OrderItem() {
        type = (new Random()).nextInt(3);
    }

    public int getType() {
        return type;
    }
}
