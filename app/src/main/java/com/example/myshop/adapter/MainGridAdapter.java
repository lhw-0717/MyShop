package com.example.myshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.v_layout.R;

public class MainGridAdapter extends DelegateAdapter.Adapter {

    private GridLayoutHelper gridLayoutHelper;

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
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new GridHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridHolder holder1= (GridHolder) holder;
        Glide.with(holder.itemView.getContext()).load("https://www.wanandroid.com/resources/image/pc/default_project_img.jpg").apply(new RequestOptions().circleCrop()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    public static class GridHolder extends RecyclerView.ViewHolder{

        private final ImageView img;

        public GridHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.month_grid);
        }
    }
}
