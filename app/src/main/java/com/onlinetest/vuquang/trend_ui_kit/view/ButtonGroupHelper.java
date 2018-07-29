package com.onlinetest.vuquang.trend_ui_kit.view;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VuQuang on 7/28/2018.
 */

public class ButtonGroupHelper {
    private static final String TAG = "ButtonGroupHelper";
    List<CustomRadioButton> group;

    public ButtonGroupHelper() {
        group = new ArrayList<>();
    }

    public ButtonGroupHelper(List<CustomRadioButton> group) {
        this.group = group;
        for (CustomRadioButton btn :
                this.group) {

            btn.setOnCheckButtonClickListener(new OnCheckButtonClickListener() {
                @Override
                public void onClicked(CustomRadioButton btn) {
                    if(!btn.isChecked()) {
                        setBtnChecked(btn);
                    }
                }
            });
        }
    }

    public void addCheckButton(final CustomRadioButton checkRadioButton) {
        group.add(checkRadioButton);
        checkRadioButton.setOnCheckButtonClickListener(new OnCheckButtonClickListener() {
            @Override
            public void onClicked(CustomRadioButton btn) {
                if(!btn.isChecked()) {
                    setBtnChecked(btn);
                }
            }
        });
    }

    public CustomRadioButton getBtnChecked() {
        if(countBtnChecked() > 1) {
            Log.d(TAG,"too much checked btn");
            return null;
        }

        for (CustomRadioButton btn :
                group) {
            if (btn.isChecked()) {
                return btn;
            }
        }
        return null;

    }

    public void setBtnChecked(CustomRadioButton checkRadioButton) {
        if(!group.contains(checkRadioButton)) {
            return;
        }
        for (CustomRadioButton btn :
                group) {
            if (btn.equals(checkRadioButton)) {
                checkRadioButton.setChecked(true);
            } else {
                btn.setChecked(false);
            }
        }
    }

    private int countBtnChecked() {
        int count = 0;
        for (CustomRadioButton btn :
                group) {
            if(btn.isChecked()) {
                count++;
            }
        }
        return count;
    }
}
