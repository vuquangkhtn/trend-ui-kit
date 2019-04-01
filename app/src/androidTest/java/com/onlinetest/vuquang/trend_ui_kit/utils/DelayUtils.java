package com.onlinetest.vuquang.trend_ui_kit.utils;

/**
 * Created by VuQuang on 8/16/2018.
 */

public class DelayUtils {
    public static void delay(long delayTime) {
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
