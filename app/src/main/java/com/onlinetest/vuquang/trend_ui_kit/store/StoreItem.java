package com.onlinetest.vuquang.trend_ui_kit.store;

import java.util.Random;

/**
 * Created by VuQuang on 7/19/2018.
 */

public class StoreItem {
    public boolean isSale;
    public StoreItem() {
        isSale = new Random().nextBoolean();
    }
}
