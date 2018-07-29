package com.onlinetest.vuquang.trend_ui_kit.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/28/2018.
 */

public class CheckRadioButton extends FrameLayout implements CustomRadioButton{

    @BindView(R.id.btn_check) protected Button btnCheck;
    @BindView(R.id.tv_check) protected TextView tvCheck;
    private boolean isChecked;
    private OnCheckButtonClickListener onCheckButtonClickListener;

    public CheckRadioButton(@NonNull Context context) {
        this(context, null);
    }

    public CheckRadioButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CheckRadioButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View root = inflater.inflate(R.layout.layout_check_btn, this);
        init(root);
    }

    private void init(final View root) {
        ButterKnife.bind(this, root);
        btnCheck.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckButtonClickListener.onClicked((CustomRadioButton) root);
            }
        });
        isChecked = false;
        updateBackground();
    }

    private void updateBackground() {
        if(isChecked) {
            btnCheck.setBackground(getResources().getDrawable(R.drawable.bg_btn_checked));
        } else {
            btnCheck.setBackground(getResources().getDrawable(R.drawable.bg_btn_uncheck));
        }
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void setChecked(boolean checked) {
        isChecked = checked;
        updateBackground();
    }

    public TextView getTvCheck() {
        return tvCheck;
    }

    @Override
    public void setOnCheckButtonClickListener(OnCheckButtonClickListener onCheckButtonClickListener) {
        this.onCheckButtonClickListener = onCheckButtonClickListener;
    }
}
