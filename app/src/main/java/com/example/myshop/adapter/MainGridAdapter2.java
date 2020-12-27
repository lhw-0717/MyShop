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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class MainGridAdapter2 extends DelegateAdapter.Adapter {

    private LinearLayoutHelper linearLayoutHelper;
    private List<HomeBean.DataBean.HotGoodsListBean> list = new ArrayList<>();

    public MainGridAdapter2(LinearLayoutHelper linearLayoutHelper) {
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotgoods_item, parent, false);
        return new GridHolder2(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        GridHolder2 holder1 = (GridHolder2) holder;
        Glide.with(holder.itemView.getContext()).load(list.get(position).getList_pic_url()).into(holder1.img);
        holder1.name.setText(list.get(position).getName());
        holder1.brief.setText(list.get(position).getGoods_brief());
        holder1.price.setText("￥"+list.get(position).getRetail_price());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void getData(List<HomeBean.DataBean.HotGoodsListBean> brandList) {
        this.list.addAll(brandList);
        notifyDataSetChanged();
    }


    public static class GridHolder2 extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView brief;
        private final TextView price;

        public GridHolder2(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_hotgoods_img);
            name = itemView.findViewById(R.id.tv_hotgoods_name);
            brief = itemView.findViewById(R.id.tv_hotgoods_goods_brief);
            price = itemView.findViewById(R.id.tv_hotgoods_retail_price);
        }
    }
}
