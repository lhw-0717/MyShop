package com.example.myshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.bean.HomeBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HomeBean.DataBean.TopicListBean>list;

    public MyAdapter(Context context, List<HomeBean.DataBean.TopicListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_item, parent, false);
        return new GridsHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridsHolder holder2= (GridsHolder) holder;
        Glide.with(holder.itemView.getContext()).load(list.get(position).getScene_pic_url()).into(holder2.img);
        holder2.name.setText(list.get(position).getTitle());
        holder2.price.setText("￥"+list.get(position).getPrice_info()+"元起");
        holder2.subtitle.setText(list.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class GridsHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView name;
        private final TextView price;
        private final TextView subtitle;

        public GridsHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_topic_img);
            name = itemView.findViewById(R.id.tv_topic_name);
            price = itemView.findViewById(R.id.tv_topic_price);
            subtitle = itemView.findViewById(R.id.tv_topic_subtitle);
        }
    }
}
