package com.onlinetest.vuquang.trend_ui_kit.view;

import android.widget.FrameLayout;

/**
 * Created by VuQuang on 7/29/2018.
 */

public interface CustomRadioButton {
    void setOnCheckButtonClickListener(OnCheckButtonClickListener onCheckButtonClickListener);
    boolean isChecked();
    void setChecked(boolean checked);
}
