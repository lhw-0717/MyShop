package com.example.myshop.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.myshop.R;
import com.example.myshop.adapter.MainGridAdapter;
import com.example.myshop.adapter.MainGridAdapter1;
import com.example.myshop.adapter.MainSingleAdapter;
import com.example.myshop.base.BaseFrgment;
import com.example.myshop.bean.HomeBean;
import com.example.myshop.contract.MainContract;
import com.example.myshop.persenter.MainPersenterImpl;

public class HomeFragment extends BaseFrgment<MainPersenterImpl> implements MainContract.MainView {
    private RecyclerView homeRl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        return inflate;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {
        homeRl = inflate.findViewById(R.id.home_rl);

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        pool.setMaxRecycledViews(0, 12);
        homeRl.setRecycledViewPool(pool);

        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 公共属性
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setPadding(1,1,1,1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(2,2,2,2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        MainSingleAdapter mainSingleAdapter = new MainSingleAdapter(linearLayoutHelper);

        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
// 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper.setPadding(1,1,1,1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(2,2,2,2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格
        MainGridAdapter mainGridAdapter = new MainGridAdapter(gridLayoutHelper);

        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
// 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper1.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper1.setPadding(1,1,1,1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper1.setMargin(2,2,2,2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper1.setBgColor(Color.GRAY);// 设置背景颜色
        gridLayoutHelper1.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper1.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper1.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper1.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper1.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper1.setSpanCount(5);// 设置每行多少个网格
        MainGridAdapter1 mainGridAdapter1 = new MainGridAdapter1(gridLayoutHelper);



        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(mainSingleAdapter);
        adapter.addAdapter(mainGridAdapter);
        adapter.addAdapter(mainGridAdapter1);

        homeRl.setLayoutManager(virtualLayoutManager);
        homeRl.setAdapter(adapter);

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void getData(HomeBean homeBean) {
        HomeBean.DataBean data = homeBean.getData();
        if (data!=null){
            
        }
    }

    @Override
    public void getResult(String string) {

    }
}