package com.onlinetest.vuquang.trend_ui_kit.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseDialog;
import com.onlinetest.vuquang.trend_ui_kit.dialog.adapter.CommentAdapter;
import com.onlinetest.vuquang.trend_ui_kit.dialog.model.CommentItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 8/6/2018.
 */

public class CommentDialog extends BaseDialog {
    public static final String TAG = "CommentDialog";
    @BindView(R.id.toolbar) protected Toolbar toolbar;

    @BindView(R.id.rv_comments)
    RecyclerView rvCommentList;
    private CommentAdapter mAdapter;
    private List dataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.dialog_comment, null);
        ButterKnife.bind(this, view);
        setupToolbar();
        rvCommentList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new CommentAdapter(getContext());
        rvCommentList.setAdapter(mAdapter);
        return view;
    }

    private void setupToolbar() {
        toolbar.setTitle(R.string.comment_name);
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

        dataList = new ArrayList<CommentItem>();
        for (int i = 0; i < 5; i++) {
            dataList.add(new CommentItem());
        }
        mAdapter.setData(dataList);

    }
}
