package com.example.myshop.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.myshop.R;
import com.example.myshop.adapter.ColumnAdapter;
import com.example.myshop.adapter.MainGridAdapter1;
import com.example.myshop.adapter.MainSingleAdapter;
import com.example.myshop.base.BaseFrgment;
import com.example.myshop.bean.HomeBean;
import com.example.myshop.contract.MainContract;
import com.example.myshop.persenter.MainPersenterImpl;

public class HomeFragment extends BaseFrgment<MainPersenterImpl> implements MainContract.MainView {
    private RecyclerView homeRl;
    private MainSingleAdapter mainSingleAdapter;
    private MainGridAdapter1 mainGridAdapter1;
    private ColumnAdapter columnAdapter;

    @Override
    protected void initData() {
        persenter.per();
    }

    @Override
    protected void initView(View inflate) {
        homeRl = inflate.findViewById(R.id.home_rl);

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        homeRl.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0, 12);

        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 公共属性
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setPadding(1,1,1,1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(2,2,2,2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        mainSingleAdapter = new MainSingleAdapter(linearLayoutHelper);

        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 公共属性
        columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        columnLayoutHelper.setPadding(6,6,6,6);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{20,20,20,20,20});// 设置该行每个Item占该行总宽度的比例
        columnAdapter = new ColumnAdapter(columnLayoutHelper);


        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper1.setItemCount(4);// 设置布局里Item个数
        gridLayoutHelper1.setPadding(1,1,1,1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper1.setMargin(2,2,2,2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper1.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper1.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper1.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper1.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper1.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper1.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper1.setSpanCount(2);// 设置每行多少个网格
        mainGridAdapter1 = new MainGridAdapter1(gridLayoutHelper1);




        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(mainSingleAdapter);
        adapter.addAdapter(columnAdapter);
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
        Log.e("TAG", "getData: "+data );
        if (data!=null){
            mainSingleAdapter.getData(data.getBanner());
            mainSingleAdapter.notifyDataSetChanged();
            columnAdapter.getData(data.getChannel());
            columnAdapter.notifyDataSetChanged();
            mainGridAdapter1.getData(data.getBrandList());
            mainGridAdapter1.notifyDataSetChanged();
        }
    }

    @Override
    public void getResult(String string) {
        Log.e("TAG", "getResult: "+string );
    }
}