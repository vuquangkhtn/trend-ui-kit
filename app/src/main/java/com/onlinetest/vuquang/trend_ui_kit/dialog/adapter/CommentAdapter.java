package com.onlinetest.vuquang.trend_ui_kit.dialog.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onlinetest.vuquang.trend_ui_kit.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VuQuang on 8/6/2018.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {
    private List<String> tagList;
    private Context mContext;

    public CommentAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> listData) {
        this.tagList = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentHolder(LayoutInflater.from(mContext).inflate(R.layout.item_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CommentHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (tagList != null) {
            return tagList.size();
        }
        return 0;
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.tv_tag_name) protected TextView tvTagName;


        public CommentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
