package com.onlinetest.vuquang.trend_ui_kit.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/18/2018.
 */

public class ItemInfoDialog extends BaseDialog {

    private static final String TAG = "ArticleDialog";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.dialog_item_info, null);
        ButterKnife.bind(this, view);

        toolbar.setTitle("Detail");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog(TAG);
            }
        });
        toolbar.inflateMenu(R.menu.action_main_menu);

        setVisibleForAppBarIcon(false,R.id.app_bar_search);
        setVisibleForAppBarIcon(true, R.id.app_bar_cart);
        setVisibleForAppBarIcon(false, R.id.app_bar_filter);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.app_bar_cart: {
                        Log.d(TAG,"test cart");
                        CartDialog cartDialog = new CartDialog();
                        cartDialog.show(getFragmentManager(),TAG);
                        return true;
                    }
                }
                return false;
            }
        });
        return view;
    }


    public void setVisibleForAppBarIcon(boolean isEnable, int id) {
        MenuItem item = toolbar.getMenu().findItem(id);
        item.setVisible(isEnable);
    }

    @Override
    protected void setUp(View view) {

    }
}
