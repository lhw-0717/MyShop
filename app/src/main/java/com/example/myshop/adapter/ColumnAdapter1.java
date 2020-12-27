package com.example.myshop.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class ColumnAdapter1 extends DelegateAdapter.Adapter {

    private ColumnLayoutHelper columnLayoutHelper;
    private List<HomeBean.DataBean.TopicListBean> list=new ArrayList<>();
    private MyAdapter myAdapter;

    public ColumnAdapter1(ColumnLayoutHelper columnLayoutHelper) {
        this.columnLayoutHelper = columnLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new GridsHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridsHolder holder2= (GridsHolder) holder;
        LinearLayoutManager manager = new LinearLayoutManager(holder.itemView.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder2.recy.setLayoutManager(manager);
        myAdapter = new MyAdapter(holder.itemView.getContext(), list);
        holder2.recy.setAdapter(myAdapter);
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public void getData(List<HomeBean.DataBean.TopicListBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public static class GridsHolder extends RecyclerView.ViewHolder{

        private final RecyclerView recy;

        public GridsHolder(@NonNull View itemView) {
            super(itemView);
            recy = itemView.findViewById(R.id.recy_home);
        }
    }
}
