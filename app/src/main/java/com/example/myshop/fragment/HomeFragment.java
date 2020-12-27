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
import com.example.myshop.R;
import com.example.myshop.adapter.ColumnAdapter;
import com.example.myshop.adapter.ColumnAdapter1;
import com.example.myshop.adapter.MainGridAdapter;
import com.example.myshop.adapter.MainGridAdapter1;
import com.example.myshop.adapter.MainGridAdapter2;
import com.example.myshop.adapter.MainGridAdapter3;
import com.example.myshop.adapter.MainLinearAdapter;
import com.example.myshop.adapter.MainSingleAdapter;
import com.example.myshop.base.BaseFrgment;
import com.example.myshop.bean.HomeBean;
import com.example.myshop.contract.MainContract;
import com.example.myshop.persenter.MainPersenterImpl;

import java.util.List;

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
    private ColumnAdapter1 columnAdapter1;
    private MainLinearAdapter mainLinearAdapter4;
    private MainGridAdapter3 mainGridAdapter3;
    private MainLinearAdapter mainLinearAdapter5;
    private MainGridAdapter3 mainGridAdapter4;
    private MainLinearAdapter mainLinearAdapter6;
    private MainGridAdapter3 mainGridAdapter5;
    private MainLinearAdapter mainLinearAdapter7;
    private MainGridAdapter3 mainGridAdapter6;
    private MainLinearAdapter mainLinearAdapter8;
    private MainGridAdapter3 mainGridAdapter7;
    private MainLinearAdapter mainLinearAdapter9;
    private MainGridAdapter3 mainGridAdapter8;
    private MainLinearAdapter mainLinearAdapter0;
    private MainGridAdapter3 mainGridAdapter9;
    private MainLinearAdapter mainLinearAdapter11;
    private MainGridAdapter3 mainGridAdapter0;
    private MainLinearAdapter mainLinearAdapter12;
    private MainGridAdapter3 mainGridAdapter11;

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
        mainLinearAdapter = new MainLinearAdapter(linearLayoutHelper, "品牌制造商直供");

        mainLinearAdapter1 = new MainLinearAdapter(linearLayoutHelper, "周一周四·新品首发");

        mainLinearAdapter2 = new MainLinearAdapter(linearLayoutHelper, "人气推荐");

        mainLinearAdapter3 = new MainLinearAdapter(linearLayoutHelper, "专题精选");


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

        //周一周四·新品发布
        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper1.setItemCount(4);// 设置布局里Item个数
        gridLayoutHelper1.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper1.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper1.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper1.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper1.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper1.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper1.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper1.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper1.setSpanCount(2);// 设置每行多少个网格
        mainGridAdapter = new MainGridAdapter(gridLayoutHelper1);

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
        columnLayoutHelper1.setItemCount(1);// 设置布局里Item个数
        columnLayoutHelper1.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper1.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper1.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper1.setAspectRatio(1.7f);// 设置设置布局内每行布局的宽与高的比
        // columnLayoutHelper特有属性
        columnLayoutHelper1.setWeights(new float[]{100});// 设置该行每个Item占该行总宽度的比例
        columnAdapter1 = new ColumnAdapter1(columnLayoutHelper1);

        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper2.setItemCount(7);// 设置布局里Item个数
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

        mainLinearAdapter4 = new MainLinearAdapter(linearLayoutHelper, "居家");
        mainGridAdapter3 = new MainGridAdapter3(gridLayoutHelper2);

        GridLayoutHelper gridLayoutHelper3 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper3.setItemCount(7);// 设置布局里Item个数
        gridLayoutHelper3.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper3.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper3.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper3.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper3.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper3.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper3.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper3.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper3.setSpanCount(2);// 设置每行多少个网格
        mainLinearAdapter5 = new MainLinearAdapter(linearLayoutHelper, "餐厨");
        mainGridAdapter4 = new MainGridAdapter3(gridLayoutHelper3);

        GridLayoutHelper gridLayoutHelper4 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper4.setItemCount(7);// 设置布局里Item个数
        gridLayoutHelper4.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper4.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper4.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper4.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper4.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper4.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper4.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper4.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper4.setSpanCount(2);// 设置每行多少个网格
        mainLinearAdapter6 = new MainLinearAdapter(linearLayoutHelper, "饮食");
        mainGridAdapter5 = new MainGridAdapter3(gridLayoutHelper4);

        GridLayoutHelper gridLayoutHelper5 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper5.setItemCount(7);// 设置布局里Item个数
        gridLayoutHelper5.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper5.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper5.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper5.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper5.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper5.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper5.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper5.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper5.setSpanCount(2);// 设置每行多少个网格
        mainLinearAdapter7 = new MainLinearAdapter(linearLayoutHelper, "配件");
        mainGridAdapter6 = new MainGridAdapter3(gridLayoutHelper5);

        GridLayoutHelper gridLayoutHelper6 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper6.setItemCount(7);// 设置布局里Item个数
        gridLayoutHelper6.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper6.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper6.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper6.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper6.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper6.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper6.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper6.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper6.setSpanCount(2);// 设置每行多少个网格
        mainLinearAdapter8 = new MainLinearAdapter(linearLayoutHelper, "服装");
        mainGridAdapter7 = new MainGridAdapter3(gridLayoutHelper6);

        GridLayoutHelper gridLayoutHelper7 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper7.setItemCount(7);// 设置布局里Item个数
        gridLayoutHelper7.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper7.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper7.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper7.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper7.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper7.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper7.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper7.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper7.setSpanCount(2);// 设置每行多少个网格
        mainLinearAdapter9 = new MainLinearAdapter(linearLayoutHelper, "婴童");
        mainGridAdapter8 = new MainGridAdapter3(gridLayoutHelper7);

        GridLayoutHelper gridLayoutHelper8 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper8.setItemCount(7);// 设置布局里Item个数
        gridLayoutHelper8.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper8.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper8.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper8.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper8.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper8.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper8.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper8.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper8.setSpanCount(2);// 设置每行多少个网格
        mainLinearAdapter0 = new MainLinearAdapter(linearLayoutHelper, "杂货");
        mainGridAdapter9 = new MainGridAdapter3(gridLayoutHelper8);

        GridLayoutHelper gridLayoutHelper9 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper9.setItemCount(7);// 设置布局里Item个数
        gridLayoutHelper9.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper9.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper9.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper9.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper9.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper9.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper9.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper9.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper9.setSpanCount(2);// 设置每行多少个网格
        mainLinearAdapter11 = new MainLinearAdapter(linearLayoutHelper, "洗护");
        mainGridAdapter0 = new MainGridAdapter3(gridLayoutHelper9);

        GridLayoutHelper gridLayoutHelper0 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper0.setItemCount(7);// 设置布局里Item个数
        gridLayoutHelper0.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper0.setMargin(2, 2, 2, 2);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper0.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper0.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper0.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper0.setVGap(6);// 控制子元素之间的垂直间距
        gridLayoutHelper0.setHGap(6);// 控制子元素之间的水平间距
        gridLayoutHelper0.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper0.setSpanCount(2);// 设置每行多少个网格
        mainLinearAdapter12 = new MainLinearAdapter(linearLayoutHelper, "志趣");
        mainGridAdapter11 = new MainGridAdapter3(gridLayoutHelper0);


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
        adapter.addAdapter(columnAdapter1);

        adapter.addAdapter(mainLinearAdapter4);
        adapter.addAdapter(mainGridAdapter3);
        adapter.addAdapter(mainLinearAdapter5);
        adapter.addAdapter(mainGridAdapter4);
        adapter.addAdapter(mainLinearAdapter6);
        adapter.addAdapter(mainGridAdapter5);
        adapter.addAdapter(mainLinearAdapter7);
        adapter.addAdapter(mainGridAdapter6);
        adapter.addAdapter(mainLinearAdapter8);
        adapter.addAdapter(mainGridAdapter7);
        adapter.addAdapter(mainLinearAdapter9);
        adapter.addAdapter(mainGridAdapter8);
        adapter.addAdapter(mainLinearAdapter0);
        adapter.addAdapter(mainGridAdapter9);
        adapter.addAdapter(mainLinearAdapter11);
        adapter.addAdapter(mainGridAdapter0);
        adapter.addAdapter(mainLinearAdapter12);
        adapter.addAdapter(mainGridAdapter11);


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
            mainSingleAdapter.getData(data.getBanner());
            columnAdapter.getData(data.getChannel());
            mainGridAdapter1.getData(data.getBrandList());
            mainGridAdapter.getData(data.getNewGoodsList());
            mainGridAdapter2.getData(data.getHotGoodsList());
            columnAdapter1.getData(data.getTopicList());

            mainGridAdapter3.getData(data.getCategoryList().get(0).getGoodsList());
            mainGridAdapter3.notifyDataSetChanged();
            mainGridAdapter4.getData(data.getCategoryList().get(1).getGoodsList());
            mainGridAdapter4.notifyDataSetChanged();
            mainGridAdapter5.getData(data.getCategoryList().get(2).getGoodsList());
            mainGridAdapter5.notifyDataSetChanged();
            mainGridAdapter6.getData(data.getCategoryList().get(3).getGoodsList());
            mainGridAdapter6.notifyDataSetChanged();
            mainGridAdapter7.getData(data.getCategoryList().get(4).getGoodsList());
            mainGridAdapter7.notifyDataSetChanged();
            mainGridAdapter8.getData(data.getCategoryList().get(5).getGoodsList());
            mainGridAdapter8.notifyDataSetChanged();
            mainGridAdapter9.getData(data.getCategoryList().get(6).getGoodsList());
            mainGridAdapter9.notifyDataSetChanged();
            mainGridAdapter0.getData(data.getCategoryList().get(7).getGoodsList());
            mainGridAdapter0.notifyDataSetChanged();
            mainGridAdapter11.getData(data.getCategoryList().get(8).getGoodsList());
            mainGridAdapter11.notifyDataSetChanged();


        }
    }

    @Override
    public void getResult(String string) {
        Log.e("TAG", "getResult: " + string);
    }
}