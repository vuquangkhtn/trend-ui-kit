package com.onlinetest.vuquang.trend_ui_kit.dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseDialog;
import com.onlinetest.vuquang.trend_ui_kit.view.ButtonGroupHelper;
import com.onlinetest.vuquang.trend_ui_kit.view.CheckRadioButton;
import com.onlinetest.vuquang.trend_ui_kit.view.ColorRadioButton;
import com.onlinetest.vuquang.trend_ui_kit.view.CustomRadioButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/18/2018.
 */

public class FilterDialog extends BaseDialog{
    public static final String TAG = "FilterDialog";

    private int[] sortName = {R.string.most_popular, R.string.most_view, R.string.most_recent};
    private int[] typeName = {R.string.unisex, R.string.men, R.string.women};
    private String[] colorId = {"#000000","#D4D1CF","#55C4CF","#EAD7E1","#DADBF2","#E8F3D6"};

    @BindView(R.id.toolbar) protected Toolbar toolbar;

    @BindViews({R.id.checkbtn_most_popular, R.id.checkbtn_most_view, R.id.checkbtn_most_recent})
    List<CustomRadioButton> checkRadioButtonsSortList;
    ButtonGroupHelper sortGroup;

    @BindViews({R.id.color_btn_1,R.id.color_btn_2,R.id.color_btn_3,
            R.id.color_btn_4,R.id.color_btn_5,R.id.color_btn_6})
    List<CustomRadioButton> buttonsColorList;
    ButtonGroupHelper colorGroup;

    @BindViews({R.id.checkbtn_type_unisex, R.id.checkbtn_type_men, R.id.checkbtn_type_women})
    List<CustomRadioButton> checkRadioButtonsTypeList;
    ButtonGroupHelper typeGroup;

    @BindView(R.id.rdg_size) protected RadioGroup rdgSize;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.dialog_filter, null);
        ButterKnife.bind(this, view);
        setupToolbar();
        setupSortGroup();
        setupTypeGroup();
        setupSizeGroup();
        setupColorGroup();

        return view;
    }

    private void setupColorGroup() {
        for (int i=0;i<buttonsColorList.size();i++) {
            CustomRadioButton customBtn = buttonsColorList.get(i);
            if(customBtn instanceof ColorRadioButton) {
                ColorRadioButton colorBtn = (ColorRadioButton) customBtn;
                int color = Color.parseColor(colorId[i]);
                colorBtn.setColor(color);
            }
        }
        colorGroup = new ButtonGroupHelper(buttonsColorList);
        colorGroup.setBtnChecked(buttonsColorList.get(0));
    }

    private void setupSizeGroup() {
        rdgSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count = group.getChildCount();
                for (int i=0;i<count;i++) {
                    View o = group.getChildAt(i);
                    if (o instanceof RadioButton) {
                        RadioButton btn = (RadioButton) o;
                        if(btn.getId() == group.getCheckedRadioButtonId()) {
                            btn.setTextColor(getResources().getColor(R.color.colorWhite));
                        } else {
                            btn.setTextColor(getResources().getColor(R.color.colorBlack));
                        }
                    }
                }
            }
        });
    }

    private void setupTypeGroup() {

        for (int i = 0; i < checkRadioButtonsTypeList.size(); i++) {
            CustomRadioButton customBtn = checkRadioButtonsTypeList.get(i);
            if(customBtn instanceof CheckRadioButton) {
                CheckRadioButton btnType = (CheckRadioButton) customBtn;
                btnType.getTvCheck().setText(typeName[i]);
            }
        }
        typeGroup = new ButtonGroupHelper(checkRadioButtonsTypeList);
        typeGroup.setBtnChecked(checkRadioButtonsTypeList.get(0));

    }

    private void setupSortGroup() {
        for (int i = 0; i < checkRadioButtonsSortList.size(); i++) {
            CustomRadioButton customBtn = checkRadioButtonsSortList.get(i);
            if(customBtn instanceof CheckRadioButton) {
                CheckRadioButton btnSort = (CheckRadioButton) customBtn;
                btnSort.getTvCheck().setText(typeName[i]);
            }
        }
        sortGroup = new ButtonGroupHelper(checkRadioButtonsSortList);
        sortGroup.setBtnChecked(checkRadioButtonsSortList.get(0));

    }

    private void setupToolbar() {
        toolbar.setTitle(R.string.filter);
        toolbar.inflateMenu(R.menu.close_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.app_bar_close: {
                        dismissDialog(TAG);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    protected void setUp(View view) {

    }
}
