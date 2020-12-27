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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class MainGridAdapter extends DelegateAdapter.Adapter {

    private GridLayoutHelper gridLayoutHelper;
    private List<HomeBean.DataBean.NewGoodsListBean> list = new ArrayList<>();

    public MainGridAdapter(GridLayoutHelper gridLayoutHelper) {
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.newgoods_item, parent, false);
        return new GridHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        GridHolder1 holder1 = (GridHolder1) holder;
        Glide.with(holder.itemView.getContext()).load(list.get(position).getList_pic_url()).into(holder1.img);
        holder1.name.setText(list.get(position).getName());
        holder1.price.setText("￥"+list.get(position).getRetail_price());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void getData(List<HomeBean.DataBean.NewGoodsListBean> brandList) {
        this.list.addAll(brandList);
        notifyDataSetChanged();
    }


    public static class GridHolder1 extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView price;

        public GridHolder1(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_newgoods_img);
            name = itemView.findViewById(R.id.tv_newgoods_name);
            price = itemView.findViewById(R.id.tv_newgoods_retail_price);
        }
    }
}
