package com.example.myshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myshop.HomeBean;
import com.example.myshop.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainSingleAdapter extends DelegateAdapter.Adapter {
    private List<HomeBean.DataBean.BannerBean>list=new ArrayList();
    private LinearLayoutHelper linearLayoutHelper;

    public MainSingleAdapter(LinearLayoutHelper linearLayoutHelper) {
        this.linearLayoutHelper = linearLayoutHelper;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new SingleHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SingleHolder holder1= (SingleHolder) holder;
        holder1.bann.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBean.DataBean.BannerBean bean= (HomeBean.DataBean.BannerBean) path;
                Glide.with(context).load(list.get(position).getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public static class SingleHolder extends RecyclerView.ViewHolder{

        private final Banner bann;

        public SingleHolder(@NonNull View itemView) {
            super(itemView);
            bann = itemView.findViewById(R.id.bann);
        }
    }
}
