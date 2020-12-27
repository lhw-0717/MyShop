package com.example.myshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.myshop.R;
import com.example.myshop.bean.HomeBean;

import java.util.ArrayList;

public class MainLinearAdapter1 extends DelegateAdapter.Adapter {
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataBean.TopicListBean> list;


    public MainLinearAdapter1(LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBean.DataBean.TopicListBean> list) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder holder1 = (MyHolder) holder;

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        

        public MyHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
