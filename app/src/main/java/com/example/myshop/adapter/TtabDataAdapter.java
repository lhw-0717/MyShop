package com.example.myshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.bean.MeTabBean;

import java.util.List;


public class TtabDataAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<MeTabBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;

    public TtabDataAdapter(Context context, List<MeTabBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tab_data_itme, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder holder1= (MyHolder) holder;
        Glide.with(context).load(list.get(position).getWap_banner_url()).into(holder1.img);
        holder1.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.sort_name);
        }
    }
}
