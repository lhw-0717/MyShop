package com.example.myshop.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.bean.SpecialBean;

import java.util.ArrayList;
import java.util.List;

public class KnowladgeAdapter extends RecyclerView.Adapter{
    private List<SpecialBean.DataBean.DataBeans>list=new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.know_item, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder holder1= (MyHolder) holder;
        Glide.with(holder.itemView.getContext()).load(list.get(position).getScene_pic_url()).into(holder1.ivtwoscencepic);
        holder1.tvtwoprice.setText(list.get(position).getPrice_info()+"元起");
        holder1.tvtwosubtitle.setText(list.get(position).getSubtitle());
        holder1.tvtwotitle.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void getData(List<SpecialBean.DataBean.DataBeans> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView ivtwoscencepic;
        private final TextView tvtwotitle;
        private final TextView tvtwosubtitle;
        private final TextView tvtwoprice;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ivtwoscencepic = itemView.findViewById(R.id.iv_two_scence_pic);
            tvtwotitle = itemView.findViewById(R.id.tv_two_title);
            tvtwosubtitle = itemView.findViewById(R.id.tv_two_subtitle);
            tvtwoprice = itemView.findViewById(R.id.tv_two_price);
        }
    }

}
