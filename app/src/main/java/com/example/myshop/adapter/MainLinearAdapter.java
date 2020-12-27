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

public class MainLinearAdapter extends DelegateAdapter.Adapter {
    private LinearLayoutHelper linearLayoutHelper2;
    private String title;

    public MainLinearAdapter(LinearLayoutHelper linearLayoutHelper2, String title) {
        this.linearLayoutHelper2 = linearLayoutHelper2;
        this.title = title;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_text, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder holder1 = (MyHolder) holder;
        holder1.title.setText(title);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
