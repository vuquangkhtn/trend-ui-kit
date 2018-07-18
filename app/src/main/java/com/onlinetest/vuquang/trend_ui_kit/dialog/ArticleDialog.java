package com.onlinetest.vuquang.trend_ui_kit.dialog;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.onlinetest.vuquang.trend_ui_kit.R;
import com.onlinetest.vuquang.trend_ui_kit.base.BaseDialog;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 7/18/2018.
 */

public class ArticleDialog extends BaseDialog {
    private static final String TAG = "ArticleDialog";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.dialog_article, null);
        ButterKnife.bind(this, view);

        toolbar.setTitle("ArticleArticleArticleArticleArticle");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog(TAG);
            }
        });
        return view;
    }

    @Override
    protected void setUp(View view) {

    }

}
