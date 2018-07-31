package com.onlinetest.vuquang.trend_ui_kit.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by VuQuang on 7/29/2018.
 */

public class ColorRadioButton extends FrameLayout implements CustomRadioButton {

    @BindView(R.id.imv_circle) protected ImageView imvCircle;
    @BindView(R.id.imv_color) protected CircleImageView imvColor;

    private boolean isChecked;
    private OnCheckButtonClickListener onCheckButtonClickListener;

    public ColorRadioButton(@NonNull Context context) {
        this(context, null);
    }

    public ColorRadioButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorRadioButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View root = inflater.inflate(R.layout.layout_color_btn, this);
        init(root);
    }

    private void init(final View root) {
        ButterKnife.bind(this, root);
        imvColor.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onCheckButtonClickListener == null) {
                    return;
                }
                onCheckButtonClickListener.onClicked((CustomRadioButton) root);
            }
        });
        isChecked = false;
        updateBackground();
    }

    private void updateBackground() {
        if(isChecked) {
            imvCircle.setVisibility(VISIBLE);
        } else {
            imvCircle.setVisibility(GONE);
        }
    }

    public void setColor(int colorId) {
        imvColor.setColorFilter(colorId);
    }

    @Override
    public void setOnCheckButtonClickListener(OnCheckButtonClickListener onCheckButtonClickListener) {
        this.onCheckButtonClickListener = onCheckButtonClickListener;
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


}