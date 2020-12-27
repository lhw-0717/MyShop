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
import com.example.myshop.adapter.MainGridAdapter;
import com.example.myshop.adapter.MainGridAdapter1;
import com.example.myshop.adapter.MainGridAdapter2;
import com.example.myshop.adapter.MainLinearAdapter;
import com.example.myshop.adapter.MainLinearAdapter1;
import com.example.myshop.adapter.MainSingleAdapter;
import com.example.myshop.base.BaseFrgment;
import com.example.myshop.bean.HomeBean;
import com.example.myshop.contract.MainContract;
import com.example.myshop.persenter.MainPersenterImpl;

import java.util.ArrayList;

public class HomeFragment extends BaseFrgment<MainPersenterImpl> implements MainContract.MainView {
    private RecyclerView homeRl;
    private MainSingleAdapter mainSingleAdapter;
    private ColumnAdapter columnAdapter;
    private MainGridAdapter1 mainGridAdapter1;
    private MainGridAdapter mainGridAdapter;
    private MainGridAdapter2 mainGridAdapter2;
    private MainLinearAdapter mainLinearAdapter;
    private MainLinearAdapter mainLinearAdapter1;
    private MainLinearAdapter mainLinearAdapter2;
    private MainLinearAdapter mainLinearAdapter3;
    private ArrayList<HomeBean.DataBean.TopicListBean> list;
    private MainLinearAdapter1 mainLinearAdapter11;

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

        //轮播图
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 公共属性
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        mainSingleAdapter = new MainSingleAdapter(linearLayoutHelper);
        mainLinearAdapter = new MainLinearAdapter(linearLayoutHelper,"品牌制造商直供");

        mainLinearAdapter1 = new MainLinearAdapter(linearLayoutHelper,"周一周四·新品首发");

        mainLinearAdapter2 = new MainLinearAdapter(linearLayoutHelper,"人气推荐");

        mainLinearAdapter3 = new MainLinearAdapter(linearLayoutHelper,"专题精选");


        //动态栏
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 公共属性
        columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        columnLayoutHelper.setPadding(6, 6, 6, 6);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});// 设置该行每个Item占该行总宽度的比例
        columnAdapter = new ColumnAdapter(columnLayoutHelper);

        //品牌制造商直供
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(4);// 设置布局里Item个数
        gridLayoutHelper.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格

        mainGridAdapter1 = new MainGridAdapter1(gridLayoutHelper);

        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper2.setItemCount(4);// 设置布局里Item个数
        gridLayoutHelper2.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper2.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper2.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper2.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper2.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper2.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper2.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper2.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper2.setSpanCount(2);// 设置每行多少个网格
        mainGridAdapter = new MainGridAdapter(gridLayoutHelper2);

        //人气推荐
        LinearLayoutHelper linearLayoutHelper1 = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(3);// 设置布局里Item个数
        linearLayoutHelper.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        mainGridAdapter2 = new MainGridAdapter2(linearLayoutHelper1);

        //专题精选
        ColumnLayoutHelper columnLayoutHelper1 = new ColumnLayoutHelper();
        // 公共属性
        columnLayoutHelper1.setItemCount(3);// 设置布局里Item个数
        columnLayoutHelper1.setPadding(6, 6, 6, 6);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper1.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper1.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper1.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // columnLayoutHelper特有属性
        columnLayoutHelper1.setWeights(new float[]{30,40,30});// 设置该行每个Item占该行总宽度的比例





        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, false);
        adapter.addAdapter(mainSingleAdapter);
        adapter.addAdapter(columnAdapter);
        adapter.addAdapter(mainLinearAdapter);
        adapter.addAdapter(mainGridAdapter1);
        adapter.addAdapter(mainLinearAdapter1);
        adapter.addAdapter(mainGridAdapter);
        adapter.addAdapter(mainLinearAdapter2);
        adapter.addAdapter(mainGridAdapter2);
        adapter.addAdapter(mainLinearAdapter3);

        list = new ArrayList<>();

        LinearLayoutHelper linearLayoutHelper2 = new LinearLayoutHelper();
        for (HomeBean.DataBean.TopicListBean bean : list) {
            linearLayoutHelper.setItemCount(3);// 设置布局里Item个数
            linearLayoutHelper.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
            linearLayoutHelper.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
            linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
            mainLinearAdapter11 = new MainLinearAdapter1(linearLayoutHelper2,list);
        }

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
        Log.e("TAG", "getData: " + data);
        if (data != null) {
            list.addAll(data.getTopicList());

            mainSingleAdapter.getData(data.getBanner());
            mainSingleAdapter.notifyDataSetChanged();
            columnAdapter.getData(data.getChannel());
            columnAdapter.notifyDataSetChanged();
            mainGridAdapter1.getData(data.getBrandList());
            mainGridAdapter1.notifyDataSetChanged();
            mainGridAdapter.getData(data.getNewGoodsList());
            mainGridAdapter.notifyDataSetChanged();
            mainGridAdapter2.getData(data.getHotGoodsList());
            mainGridAdapter2.notifyDataSetChanged();

        }
    }

    @Override
    public void getResult(String string) {
        Log.e("TAG", "getResult: " + string);
    }
}