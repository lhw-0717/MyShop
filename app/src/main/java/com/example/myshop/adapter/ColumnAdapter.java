package com.example.myshop.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class ColumnAdapter extends DelegateAdapter.Adapter {

    private ColumnLayoutHelper columnLayoutHelper;
    private List<HomeBean.DataBean.ChannelBean> list=new ArrayList<>();

    public ColumnAdapter(ColumnLayoutHelper columnLayoutHelper) {
        this.columnLayoutHelper = columnLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new GridsHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridsHolder holder2= (GridsHolder) holder;
        Glide.with(holder.itemView.getContext()).load(list.get(position).getIcon_url()).into(holder2.img);
        holder2.title.setText(list.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void getData(List<HomeBean.DataBean.ChannelBean> channel) {
        this.list.addAll(channel);
        notifyDataSetChanged();
    }

    public static class GridsHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView title;

        public GridsHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.grid_img);
            title = itemView.findViewById(R.id.grid_title);
        }
    }
}
