package com.onlinetest.vuquang.trend_ui_kit.dialog;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseDialog;
import com.onlinetest.vuquang.trend_ui_kit.dialog.adapter.TagAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/18/2018.
 */

public class ArticleDialog extends BaseDialog {
    private static final String TAG = "ArticleDialog";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.rv_tag_list) RecyclerView rvTagList;
    @BindView(R.id.imb_like) ImageButton imbLike;
    @BindView(R.id.imb_unlike) ImageButton imbUnlike;
    @BindView(R.id.imb_comment) ImageButton imbComment;
    private TagAdapter tagAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.dialog_article, null);
        ButterKnife.bind(this, view);

        toolbar.setTitle("Article Test");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog(TAG);
            }
        });

        tagAdapter = new TagAdapter(getContext());
        rvTagList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvTagList.setAdapter(tagAdapter);

        imbLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imbLike.setVisibility(View.GONE);
                imbUnlike.setVisibility(View.VISIBLE);
            }
        });

        imbUnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imbLike.setVisibility(View.VISIBLE);
                imbUnlike.setVisibility(View.GONE);
            }
        });

        imbComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentDialog commentDialog = new CommentDialog();
                commentDialog.show(getFragmentManager(), TAG);
            }
        });

        return view;
    }

    @Override
    protected void setUp(View view) {
        List data = new ArrayList();
        for (int i = 0; i < 5; i++) {
            data.add("test "+i);
        }
        tagAdapter.setData(data);
    }

}
