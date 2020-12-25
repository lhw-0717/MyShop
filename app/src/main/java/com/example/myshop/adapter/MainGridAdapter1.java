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
import com.example.myshop.bean.HomeBean;
import com.example.myshop.R;

import java.util.ArrayList;
import java.util.List;

public class MainGridAdapter1 extends DelegateAdapter.Adapter {

    private GridLayoutHelper gridLayoutHelper;
    private List<HomeBean.DataBean.BrandListBean> list = new ArrayList<>();

    public MainGridAdapter1(GridLayoutHelper gridLayoutHelper) {
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_text, parent, false);
            return new GridHolder(inflate);

        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_, parent, false);
        return new GridHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) != 0) {
            GridHolder1 holder1 = (GridHolder1) holder;
            Glide.with(holder.itemView.getContext()).load(list.get(position).getNew_pic_url()).into(holder1.img);
            holder1.name.setText(list.get(position).getName());
            holder1.price.setText(list.get(position).getFloor_price()+"元起");
        }else {
            GridHolder holder1= (GridHolder) holder;
            holder1.title.setText("品牌制造商直供");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void getData(List<HomeBean.DataBean.BrandListBean> brandList) {
        this.list.addAll(brandList);
        notifyDataSetChanged();
    }

    public static class GridHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        public GridHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }

    public static class GridHolder1 extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView price;

        public GridHolder1(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_brand_img);
            name = itemView.findViewById(R.id.tv_brand_name);
            price = itemView.findViewById(R.id.tv_brand_floor_price);
        }
    }
}
