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
 * Created by VuQuang on 7/19/2018.
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.TagHolder> {
    private List<String> tagList;
    private Context mContext;

    public TagAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> listData) {
        this.tagList = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TagHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TagHolder(LayoutInflater.from(mContext).inflate(R.layout.item_tags, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final TagHolder holder, int position) {
        holder.tvTagName.setText(tagList.get(position));
    }

    @Override
    public int getItemCount() {
        if (tagList != null) {
            return tagList.size();
        }
        return 0;
    }

    public class TagHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_tag_name) protected TextView tvTagName;


        public TagHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
