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

public class MainGridAdapter extends DelegateAdapter.Adapter {

    private GridLayoutHelper gridLayoutHelper;
    private List<HomeBean.DataBean.ChannelBean>list=new ArrayList<>();

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
        Glide.with(holder.itemView.getContext()).load(list.get(position).getIcon_url()).into(holder1.img);
        holder1.title.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class GridHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView title;

        public GridHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.grid_img);
            title = itemView.findViewById(R.id.grid_title);
        }
    }
}
