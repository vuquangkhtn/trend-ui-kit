package com.onlinetest.vuquang.trend_ui_kit.custom;

import android.support.test.espresso.IdlingResource;
import android.util.Log;

/**
 * Created by VuQuang on 8/16/2018.
 */

public class ElapsedTimeIdlingResource implements IdlingResource {
    private final long startTime;
    private final long waitingTime;
    private IdlingResource.ResourceCallback resourceCallback;
    private final static String TAG="ElapsedTimeIdlingResource";

    public ElapsedTimeIdlingResource(long waitingTime) {
        this.startTime = System.currentTimeMillis();
        this.waitingTime = waitingTime;
    }

    @Override
    public String getName() {
        return ElapsedTimeIdlingResource.class.getName() + ":" + waitingTime;
    }

    @Override
    public boolean isIdleNow() {
        long elapsed = System.currentTimeMillis() - startTime;
        while (elapsed < waitingTime) {
            elapsed = System.currentTimeMillis() - startTime;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean idle = (elapsed >= waitingTime);
        Log.d(TAG, "isIdleNow ->" + (waitingTime - elapsed)+" ms. left " + idle);
        if (idle) {
            resourceCallback.onTransitionToIdle();
        }
        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(
            IdlingResource.ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }
}